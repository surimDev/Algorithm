package TopologicalSort;

import java.io.*;
import java.util.*;

public class G3_2252_LineUp {

    static List<List<Integer>> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();
    static int N, M;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N+1];
        for(int i = 0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            count[B]++;
        }

        //위상 정렬
        topologicalSort();

        System.out.println(sb);

    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=N; i++)
            if(count[i] == 0)
                q.offer(i);

        for(int i = 0; i<N; i++) {
            if (!q.isEmpty()) {
                int num = q.poll();
                sb.append(num).append(" ");

                for (int j = 0; j < list.get(num).size(); j++) {
                    count[list.get(num).get(j)]--;

                    if (count[list.get(num).get(j)] == 0)
                        q.offer(list.get(num).get(j));
                }
            }
        }
    }
}
