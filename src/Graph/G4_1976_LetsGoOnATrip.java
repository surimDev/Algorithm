package Graph;

import java.io.*;
import java.util.*;

public class G4_1976_LetsGoOnATrip {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (i == j) { // 출발점과 도착점이 같은 경우도 항상 여행이 가능함.
                    arr[i][j] = 1;
                }
            }
        }

        // 플로이드 와샬
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (arr[start][now] == 0) {
                System.out.println("NO\n");
                br.close();
                return;
            }
        }

        System.out.println("YES\n");
        br.close();

    }
}
