package Graph;

import java.io.*;
import java.util.*;

public class G5_6593_SangbumBuilding {

    static class Pos {
        int l, y, x;

        public Pos(int l, int y, int x) {
            this.l = l;
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "l=" + l +
                    ", y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    static boolean map[][][], v[][][];
    static int L, R, C, dist[][][];
    static Pos start, end;
    static int[] dy={-1, 1, 0, 0, 0, 0}, dx={0, 0, -1, 1, 0, 0}, dl={0, 0, 0, 0, -1, 1}; //상하좌우위아래

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){

            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken()); //빌딩의 층수
            R = Integer.parseInt(st.nextToken()); //행
            C = Integer.parseInt(st.nextToken()); //열

            if(L==0 && R==0 && C==0) break;

            map = new boolean[L][R][C];
            v = new boolean[L][R][C];
            dist = new int[L][R][C];

            start = new Pos(-1, -1, -1);
            end = new Pos(-1, -1, -1);

            for(int l=0; l<L; l++){
                for(int i=0; i<R; i++){
                    String s = br.readLine();
                    for(int j=0; j<C; j++){
                        if(s.charAt(j)=='.') map[l][i][j] = true;
                        else if(s.charAt(j)=='S') {
                            start = new Pos(l, i, j);
                            map[l][i][j] = true;
                        }
                        else if(s.charAt(j)=='E') {
                            end = new Pos(l, i, j);
                            map[l][i][j] = true;
                        }
                    }
                }
                br.readLine();
            }

            BFS(start);

            // printMap();

            if(dist[end.l][end.y][end.x]>0) sb.append("Escaped in ").append(dist[end.l][end.y][end.x]-1).append(" minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");

        }

        System.out.println(sb);

    }

    private static void printMap() {

        for(int l=0; l<L; l++){
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    System.out.printf("%2d ", dist[l][i][j]);
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

    private static void BFS(Pos start) {

        Queue<Pos> q = new LinkedList<>();

        v[start.l][start.y][start.x] = true;
        dist[start.l][start.y][start.x] = 1;
        q.add(start);

        while (!q.isEmpty()){

            Pos cur = q.poll();

            for(int d=0; d<6; d++){
                int nl = cur.l + dl[d];
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if(nl<0 || nl>=L || ny<0 || ny>=R || nx<0 || nx>=C || v[nl][ny][nx] || !map[nl][ny][nx]) continue;
                v[nl][ny][nx] = true;
                q.offer(new Pos(nl, ny, nx));
                dist[nl][ny][nx] = dist[cur.l][cur.y][cur.x]+1;
            }

        }



    }
}
