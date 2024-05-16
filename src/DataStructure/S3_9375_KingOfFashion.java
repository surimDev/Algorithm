package DataStructure;

import java.io.*;
import java.util.*;

public class S3_9375_KingOfFashion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken(), type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (int val : map.values())
                ans *= val + 1;
            sb.append(ans - 1).append("\n");
        }

        System.out.println(sb);

    }
}
