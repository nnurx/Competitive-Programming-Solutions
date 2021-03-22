package l3homework;
import java.util.*;
import java.io.*;

public class Knapsack2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt();
		int w = readInt();
		int qn[] = new int [n];
		int qv[] = new int [n];
		int tv = 0;
		
		for (int i = 0; i < n; i++){
			qn[i] = readInt();
			qv[i] =  readInt();
		}
		for (int i = 0; i < n; i++) {
			tv += qv[i];
		}
		long [][] kys = new long [n+1][tv+1];
		Arrays.fill(kys[0], (long)1e9 +1);
		
		kys [0][0] = 0;
		for(int i=1;i<=n;i++) {
			for(int a=0;a<=tv;a++) {
				kys[i][a] = kys[i-1][a];
				if(qv[i-1]<=a) {
					kys[i][a] = Math.min(kys[i][a], kys[i-1][a-qv[i-1]]+qn[i-1]);
				}
			}
		}
		
		long sol = 0;
		for(int i=0;i<=tv;i++) {
			if(kys[n][i]<=w) sol = i;
		}
			
		System.out.println(sol);
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
