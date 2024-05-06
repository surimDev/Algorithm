package TopologicalSort;
import java.io.*;
import java.util.*;

public class G2_1766_WorkBook {

    static int N, M, in[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        in = new int[N+1];
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            a.get(first).add(last);
            in[last]++; // 특정 문제의 번호보다 먼저 풀어야하는 문제의 개수
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) { // 먼저 풀어야하는 문제가 없는 경우
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");

            // now와 연결된 문제가 있는지 확인.
            for (int next : a.get(now)) {
                // now에 해당하는 문제를 풀었기때문에
                // next보다 먼저 풀어야하는 문제의 개수가 1개 줄어듦.
                in[next]--;

                // 먼저 풀어야하는 문제가 없는 경우
                // 새롭게 큐에 데이터를 집어넣는다.
                if (in[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
