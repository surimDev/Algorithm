package Math;

import java.io.*;
import java.util.*;

public class S1_6064_KaingCalender {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / GCD(M, N);

            x--;
            y--;

            int year = x;
            while (year <= lcm) {
                if (year % N == y) {
                    sb.append(year + 1).append("\n");
                    break;
                }
                year += M;
            }

            if (year > lcm) sb.append(-1).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}
