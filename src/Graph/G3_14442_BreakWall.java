package Graph;

import java.io.*;
import java.util.*;

public class G3_14442_BreakWall {

    static int N, M, K, map[][];
    static boolean[][][] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        v = new boolean[N+1][M+1][K+1];

        for (int i=1; i<=N; i++) {
            String str = br.readLine();
            for (int j=1; j<=M; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {

        int[] r = { 0, 1, 0, -1 };
        int[] c = { 1, 0, -1, 0 };

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(new Pos(1, 1), 0, 1));
        v[1][1][0] = true;

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            Pos pos = pair.pos;

            if (pos.r == N && pos.c == M) {
                return pair.cnt;
            }

            for (int i=0; i<4; i++) {
                int ni = pos.r + r[i];
                int nj = pos.c + c[i];

                if ((1 <= ni && ni <= N) && (1 <= nj && nj <= M)) {
                    if (map[ni][nj] == 0 && !v[ni][nj][pair.wall]) {
                        q.offer(new Pair(new Pos(ni, nj), pair.wall, pair.cnt + 1));
                        v[ni][nj][pair.wall] = true;
                    }

                    else if (map[ni][nj] == 1 && pair.wall < K && !v[ni][nj][pair.wall + 1]) {
                        q.offer(new Pair(new Pos(ni, nj), pair.wall + 1, pair.cnt + 1));
                        v[ni][nj][pair.wall + 1] = true;
                    }
                }
            }
        }

        return -1;
    }

    static class Pair {

        int cnt;
        Pos pos;
        int wall;

        Pair(Pos pos, int wall, int cnt) {
            this.pos = pos;
            this.wall = wall;
            this.cnt = cnt;
        }
    }

    static class Pos {

        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}