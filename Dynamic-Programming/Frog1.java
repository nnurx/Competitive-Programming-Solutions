package l3homework;
import java.util.*;
import java.io.*;

public class Frog1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt();
		int [] frog = new int [n+1];
		
		for (int i = 1; i <= n; i++) {
			frog[i] = readInt();
		}
		int dis [] =  new int [n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		dis[1] = 0;
		for (int i = 1; i < n; i++) {
			dis[i+1] =  Math.min(dis[i+1], dis[i]+Math.abs(frog[i]-frog[i+1]));
			if (i != n-1) {
				dis[i+2] =  Math.min(dis[i+2], dis[i]+Math.abs(frog[i]-frog[i+2]));
			}
		}
		System.out.println(dis[n]);
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
