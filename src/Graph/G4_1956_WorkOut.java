package Graph;

import java.io.*;
import java.util.*;

public class G4_1956_WorkOut {

    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] arr = new int[V+1][V+1];

        for (int i=1; i<=V; i++) {
            for (int j=1; j<=V; j++) {
                if (i!=j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        // 플로이드 와샬
        for (int k=1; k<=V; k++) {
            for (int i=1; i<=V; i++) {
                for (int j=1; j<=V; j++) {

                    if (i==j) continue;

                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int ans = INF;
        for (int i=1; i<=V; i++) {
            for (int j=1; j<=V; j++) {
                if (i==j) continue;

                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }

        ans = (ans == INF) ? -1 : ans;
        System.out.println(ans);

    }
}
