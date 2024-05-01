package DynamicProgramming;

import java.io.*;
import java.util.*;

public class G5_15989_123plus4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int dp[][] = new int[10001][4];

        dp[1][1] = 1; //1
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 1; //1+1
        dp[2][2] = 1; //2
        dp[2][3] = 0;

        dp[3][1] = 1; //1+1+1
        dp[3][2] = 1; //2+1
        dp[3][3] = 1; //3

        dp[4][1] = 1; //1+1+1+1
        dp[4][2] = 2; //2+1+1, 2+2
        dp[4][3] = 1; //3+1

        for(int i=5; i<=10000; i++){
            dp[i][1] = 1;
            dp[i][2] = dp[i-2][1]+ dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append("\n");
        }

        System.out.println(sb);

    }
}
