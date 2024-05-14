package Graph;

import java.io.*;
import java.util.*;

public class S1_11403_FindRoute {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();

    }
}