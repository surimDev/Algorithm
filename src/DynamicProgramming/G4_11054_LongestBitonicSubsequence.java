package DynamicProgramming;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/11054
public class G4_11054_LongestBitonicSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] up = new int[N];
        int[] down = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());


        // i:가장 큰 수가 될 인덱스
        for(int i=0; i<N; i++){
            up[i] = 1;

            for(int j=0; j<i; j++){
                if(nums[j]<nums[i] && up[i]<up[j]+1) {
                    up[i] = up[j] + 1;
                }
            }
        }
        // i:가장 큰 수가 될 인덱스
        for(int i=N-1; i>=0; i--){
            down[i] = 1;

            for(int j=N-1; j>=i; j--){
                if(nums[j]<nums[i] && down[i] < down[j]+1) {
                    down[i] = down[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) max = Math.max(max, up[i]+down[i]-1);
        System.out.println(max);

    }
}
