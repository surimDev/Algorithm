package Implementation;

import java.io.*;

public class S1_5525_IOIO {

    static int N, M;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0, ans = 0;
        for(int i=1; i<M-1; ) {
            if(str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == N) {
                    if(str.charAt(i-(cnt*2-1)) == 'I')
                        ans++;
                    cnt--;
                }
                i += 2;
            }
            else {
                cnt = 0;
                i++;
            }
        }
        System.out.println(ans);
    }
}