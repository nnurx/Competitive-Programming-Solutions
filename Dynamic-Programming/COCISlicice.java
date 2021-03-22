package l3homework;
import java.util.*;
import java.io.*;

public class COCISlicice {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n =readInt(), m = readInt(), k = readInt();
		int [] cards = new int [n];
		int [] unique = new int [m+1];
		for (int i = 0; i <n; i++) {
			cards[i] = readInt();
		}
		for (int i =0 ;i < m+1; i++) {
			unique[i] = readInt();
		}
		
		int[][] dp= new int [2][k+1];
		
		for (int i = 0; i < n; i++) {
			for (int a = 0; a <=k; a++) {
				for (int j = 0; j <=k; j++) {
					if (j>a) break;
					int cardsleft = a-j;
					if (cards[i]+cardsleft> m) continue;
					dp[1][a] = Math.max(dp[1][a], dp[0][j]+unique[cards[i]+cardsleft]);  
					
				}
			}
			
			for (int a = 0; a <=k ; a++) {
				dp[0][a] =  dp[1][a];
			}
		}
		System.out.println(dp[1][k]);
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
