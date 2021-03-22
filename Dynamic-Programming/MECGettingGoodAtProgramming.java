package l3homework;
import java.util.*;
import java.io.*;

public class MECGettingGoodAtProgramming {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
    	int n = readInt(), m = readInt();
    	
    	int dp[] = new int [m+1];
    	
    	for (int b = 1; b <= n; b++) {
    		int lvls = readInt();
    		int v1 = 0;
    		int w1 = 0;
    		int []v = new int [lvls];
    		int []w = new int [lvls];
    		for (int a = 0; a < lvls; a++) {
    			w1 += readInt(); v1 += readInt();
    			v[a] = v1;
    			w[a] = w1;
    		}
    		for (int i = m; i >=0; i--) {
    			for(int j = 0; j < lvls; j++){
                    if(w[j] <= i){
                        dp[i] = Math.max(dp[i], dp[i - w[j]] + v[j]);
                    }
                }
    		}
    	}
    		
        
    	System.out.println(dp[m]);

    	
    	
    }
	
	static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
