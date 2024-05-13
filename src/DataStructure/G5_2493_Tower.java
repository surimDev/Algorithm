package DataStructure;

import java.io.*;
import java.util.*;

class Tower {
    int id;
    int height;

    Tower(int id, int height) {
        this.id = id;
        this.height = height;
    }
}

public class G5_2493_Tower {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Tower> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Tower(i, height));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Tower(i, height));
                        break;
                    }

                    Tower tower = stack.peek();

                    if (tower.height > height) {
                        sb.append(tower.id + " ");
                        stack.push(new Tower(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

}