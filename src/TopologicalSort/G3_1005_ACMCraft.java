package TopologicalSort;


import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1005
public class G3_1005_ACMCraft {

    static int N, K, D[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            D = new int[N+1];

            List<List<Integer>> list = new ArrayList<List<Integer>>();
            for(int i=0; i<N+1; i++) list.add(new ArrayList<Integer>());

            int[] in = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) D[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                in[v2]++;
            }

            int w = Integer.parseInt(br.readLine());
            topologicalSort(in, list, w);

        }
    }

    static void topologicalSort(int[] in, List<List<Integer>> list, int w) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[N+1];

        // 건물의 소요 기본 소요시간은 D[i]
        for(int i=1; i<=N; i++) {
            result[i] = D[i];

            if(in[i] == 0)
                q.offer(i);
        }

        // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
        // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
        while(!q.isEmpty()) {
            int node = q.poll();

            for(Integer i : list.get(node)) {
                result[i] = Math.max(result[i], result[node] + D[i]);
                in[i]--;

                if(in[i] == 0) q.offer(i);
            }
        }
        System.out.println(result[w]);
    }

}
