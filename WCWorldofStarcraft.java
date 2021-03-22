package l3homework;
import java.util.*;
import java.io.*;

public class WCWorldofStarcraft {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int [] link;
    static int [] size;
    
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		char [] races = readLine().toCharArray();
		link = new int [n+1];
		size = new int [n+1];
		for (int i = 1; i < n+1; i++)link[i] = i;
		for (int i = 1; i < n+1; i++) size[i] = 1;
		for (int i = 0; i < m; i++) {
			int n1 = readInt(), n2 = readInt();
			if (races[n1-1] ==  races[n2-1]) {
				merge(n1,n2);
			}
		}
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			int q1 = readInt(), q2 = readInt();
			if(sameSet(q1,q2))cnt++;
		}
		System.out.println(cnt);
		
	}
	static int find(int x) {
		while (x != link[x]) x = link[x];
		return x;
	}
	
	static boolean sameSet(int a, int b) {
		return find(a) == find(b);
	}
	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (size[a] < size[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		size[a] += size[b];
		link[b] = a;
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
