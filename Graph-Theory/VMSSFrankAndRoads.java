package l3homework;
import java.io.*;
import java.util.*;

public class VMSSFrankAndRoads {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int t = readInt(), n = readInt(), m = readInt(), g = readInt();
		ArrayList<ArrayList<node>> adj = new ArrayList<ArrayList<node>>();
		int foodbasics[] = new int [g];
		for (int i = 0; i < g; i++) {
			foodbasics[i] = readInt();
		}
		for (int i = 0; i < n+1; i++) {
			adj.add(new ArrayList<node>());
		}
		
		for (int i = 0; i < m; i++) {
			int u1 = readInt(), u2 = readInt(), w = readInt();
			adj.get(u1).add(new node(u2,w));
		}
		
		LinkedList<node> q1 = new LinkedList<node>();
		int []dis1 = new int [n+1];
		Arrays.fill(dis1, (int) 1e9);
		dis1[0] =  0;
		boolean inq[] = new boolean [n+1];
		q1.add(new node(0,0));
		inq[0] = true;
		while (!q1.isEmpty()) {
			node cur = q1.poll(); int u = cur.to, w = cur.weight;
			inq[u] = false;
			if (w>dis1[u])continue;
			for (node a: adj.get(u)) {
				int u1 = a.to, w1 = a.weight;
				if (dis1[u1]>dis1[u]+w1) {
					dis1[u1] = dis1[u] + w1;
					if (!inq[u1]) {
						q1.add(new node(u1,w1));
						inq[u1] = true;
					}
				}
				
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < g; i++) {
			if (t>=dis1[foodbasics[i]])cnt++;
		}
		System.out.println(cnt);
		
	}
	static class node implements Comparable<node>{
		private int to;
		private int weight;
		public node (int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(node x) { return Integer.compare(weight, x.weight); }

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
