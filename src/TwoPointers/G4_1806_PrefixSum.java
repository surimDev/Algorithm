package TwoPointers;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1806
public class G4_1806_PrefixSum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //원소 수
        int S = Integer.parseInt(st.nextToken()); //최소 합
        int[] nums = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int sum = 0, start = 0, end = 0;
        int ans = 1000001;

        while (true) {
            if (sum >= S) {
                sum -= nums[start];
                ans = Math.min(ans, end - start);
                start++;
            } else if (end == N) {
                break;
            } else {
                sum += nums[end++];
            }
        }

        System.out.println(ans == 1000001 ? 0 : ans);
    }

}
