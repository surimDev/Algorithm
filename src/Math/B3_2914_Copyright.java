package Math;

import java.io.*;
import java.util.*;

public class B3_2914_Copyright {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        System.out.println(A*(I-1)+1);
    }
}
