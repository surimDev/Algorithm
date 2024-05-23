package Implementation;

import java.io.*;
import java.util.*;

public class S2_18111_Minecraft {

    static final int INF = 987654321;
    static int N, M, B, map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int min = INF;
        int max = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(min > map[i][j]) min = map[i][j];
                if(max < map[i][j]) max = map[i][j];
            }
        }

        int time = INF;
        int high = 0;
        for(int i = min; i <= max; i++) {
            int count = 0;
            int block = B;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(i < map[j][k]) {
                        count += ((map[j][k] - i) * 2);
                        block += (map[j][k] - i);
                    }else {
                        count += (i - map[j][k]);
                        block -= (i - map[j][k]);
                    }
                }
            }

            if(block < 0) break;

            if(time >= count) {
                time = count;
                high = i;
            }
        }

        System.out.println(time + " " + high);

    }
}
