package DynamicProgramming;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/9084
public class G5_9084_Coin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j - coins[i] > 0) {
                        dp[j] = dp[j] + dp[j-coins[i]];
                    } else if (j - coins[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.print(sb);
    }
}
