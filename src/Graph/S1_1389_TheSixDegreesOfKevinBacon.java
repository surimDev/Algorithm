package Graph;

import java.io.*;
import java.util.*;

public class S1_1389_TheSixDegreesOfKevinBacon {

    static final int INF = 987654321;
    static int N, M, map[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                map[i][j] = INF;
                if (i==j) map[i][j] = 0;
            }
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i=1; i<=N; i++) {
            int total = 0;
            for (int j=1; j<=N; j++) {
                total += map[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx + "\n");

    }
}