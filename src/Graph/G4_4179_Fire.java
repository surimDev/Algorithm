//package Graph;
//
//import java.io.*;
//import java.util.*;
//
//public class G4_4179_Fire {
//
//    static class Pos{
//        int y, x;
//        public Pos(int y, int x) {
//            this.y = y;
//            this.x = x;
//        }
//    }
//
//    static final int[] di={-1, 0, 1, 0}, dj={0, 1, 0, -1}; //상우하좌
//    static int R, C, map[][], fMap[][], pMap[][];
//    static boolean v[][];
//    static Pos player;
//    static LinkedList<Pos> fire;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine(), " ");
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        map = new int[R+2][C+2];
//        fMap = new int[R+2][C+2];
//        pMap = new int[R+2][C+2];
//        fire = new LinkedList<>();
//
//        for(int i=1; i<=R; i++){
//            String s = br.readLine();
//            for(int j=1; j<=C; j++){
//                if(s.charAt(j)=='#') map[i][j] = 2;
//                else if(s.charAt(j)=='F') {
//                    map[i][j] = 2;
//                    fire.add(new Pos(i, j));
//                }
//                else if(s.charAt(j)=='J') player = new Pos(i, j);
//            }
//        }
//
//        for(int time=1; ; time++){
//
//            // 플레이어 시뮬레이션
//            v = new boolean[R][C];
//            getDistPlayer(player);
//
//            // 불 번짐
//            v = new boolean[R][C];
//            spreadFire();
//
//            // 살아있는 플레이어 있는지 확인
//            if(isDone()) {
//                System.out.println("IMPOSSIBLE");
//                break;
//            }
//
//        }
//    }
//
//    private static void getDistPlayer(Pos player) {
//
//    }
//
//    private static boolean movePlayer() {
//        int size = player.size();
//
//        for(int i=0; i<size; i++){
//
//            Pos now = player.poll();
//
//            if(map[now.y][now.x]==2) continue; //불에 먹힘
//            for (int d = 0; d < 4; d++) {
//                int ni = now.y + di[d];
//                int nj = now.x + dj[d];
//                if(ni<0 || ni>=R || nj<0 || nj>=C) return true;
//                if(v[ni][nj] || map[ni][nj]==2) continue;
//                if(map[ni][nj]==0) {
//                    player.add(new Pos(ni, nj));
//                    v[ni][nj] = true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static void spreadFire() {
//        int size = fire.size();
//
//        for(int i=0; i<size; i++){
//            Pos cur = fire.poll();
//
//            for(int d=0; d<4; d++){
//                int ni = cur.y + di[d];
//                int nj = cur.x + dj[d];
//
//                if(ni<0 || ni>=R || nj<0 || nj>=C || v[ni][nj]) continue;
//                if(map[ni][nj]==0) {
//                    map[ni][nj] = 2;
//                    fire.add(new Pos(ni, nj));
//                    v[ni][nj] = true;
//                }
//            }
//        }
//    }
//}
