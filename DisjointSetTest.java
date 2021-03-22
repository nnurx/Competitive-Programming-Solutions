package l3homework;
import java.util.*;
import java.io.*;

public class DisjointSetTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int [] link;
    static int [] size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), q = readInt();
		link = new int [n+1];
		size = new int [n+1];
		for (int i = 1; i < n+1; i++)link[i] = i;
		for (int i = 1; i < n+1; i++) size[i] = 1;
		int order[] = new int [n-1];
		int cnt = 0;
		for (int i = 0; i < q; i++) {
			int n1 = readInt(), n2 = readInt();
			if (!sameSet(n1,n2)) {
				merge(n1,n2);
				order[cnt++] = i+1;
			}
		}
		
		if (cnt == n-1) {
			for (int i = 0; i < n-1; i++) {
				System.out.println(order[i]);
			}
		}
		else {
			System.out.println("Disconnected Graph");
		}
		
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
