package l3homework;
import java.util.*;
import java.io.*;

public class COCIMuzikari {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
    	int T = readInt(), n = readInt(), id [] = new int [T+1], t [] = new int [n+1];
    	boolean dp[] =  new boolean[T+1]; dp[0] = true;
    	for (int i = 1; i <=n; i++) {
    		t[i] = readInt();
    		for (int j = T; j >=t[i]; j--) {
    			if (!dp[j]&& dp[j-t[i]]) {
    				dp[j] =  true;
    				id[j] =  i;
    			}
    		}
    	}
    	int max = T, track[] = new int [n+1];
    	while (!dp[max])max--;
    	for (int i = max; i != 0; i-=t[id[i]]) {
    		track[id[i]] =  1;
    		
    	}
    	int s0 = 0, s1 = 0;
    	
    	for (int i = 1; i <=n ;i++) {
    		if (track[i] == 0) {
    			System.out.print(s0 + " "); s0 +=t[i];
    		}
    		else {
    			System.out.print(s1 + " "); s1 +=t[i];
    		}
    	}
    	System.out.println();
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
