package Graph;

import java.io.*;
import java.util.*;

public class G1_9328_Key {

    static char[][] map;
    static boolean key[], v[][];
    static ArrayList<Point>[] gates;
    static int H, W, cnt;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] inputMap = br.readLine().split(" ");

            H = Integer.parseInt(inputMap[0]);
            W = Integer.parseInt(inputMap[1]);

            map = new char[H+2][W+2];
            v = new boolean[H+2][W+2];
            key = new boolean[26];
            gates = new ArrayList[26];

            cnt = 0;

            for (int i = 0; i < 26; i++) {
                gates[i] = new ArrayList<>();
            }

            for (int i=0; i<H+2; i++) {
                for (int j=0; j<W+2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i=1; i<=H; i++) {
                String input = br.readLine();
                for (int j=1; j<=W; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String input = br.readLine();
            if (!input.equals("0")) {
                for (int i = 0; i < input.length(); i++) {
                    int temp = input.charAt(i) - 'a';
                    key[temp] = true;
                }
            }

            bfs();
            System.out.println(cnt);
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H + 2 || ny >= W + 2) {
                    continue;
                }

                if (map[nx][ny] == '*' || v[nx][ny]) {
                    continue;
                }

                int elem = map[nx][ny];
                if (elem - 'A' >= 0 && elem - 'A' <= 25) {
                    // 문 발견
                    if (key[elem - 'A']) {
                        map[nx][ny] = '.';
                        v[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    } else {
                        gates[elem - 'A'].add(new Point(nx, ny));
                    }
                } else if (elem - 'a' >= 0 && elem - 'a' <= 25) {
                    // 열쇠 발견
                    key[elem - 'a'] = true;
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));

                    for (int j = 0; j <= 25; j++) {
                        if (gates[j].size() != 0 && key[j]) {
                            for (int z = 0; z < gates[j].size(); z++) {
                                Point temp = gates[j].get(z);
                                map[temp.x][temp.y] = '.';
                                v[temp.x][temp.y] = true;
                                q.add(new Point(temp.x, temp.y));
                            }
                        }
                    }
                } else if (elem == '$') {
                    // 문서 발견
                    cnt++;
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                } else {
                    // 빈 칸 '.'
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }

            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
