package DynamicProgramming;

import java.io.*;
import java.util.*;

public class G4_2631_LineUp {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i=0;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(N-max);
    }
}