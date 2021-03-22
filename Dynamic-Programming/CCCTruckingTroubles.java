package l3homework;
import java.util.*;

import l3homework.CCCShopandShip.pair;

import java.io.*;

public class CCCTruckingTroubles {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
   
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int c = readInt(), r = readInt(), d = readInt();
		ArrayList<ArrayList<node>> adj = new ArrayList<ArrayList<node>>();
		for (int i = 0; i < c+1; i++) {
			adj.add(new ArrayList<node>());
		}
		for (int i = 0; i < r; i++) {
			int to = readInt(), from = readInt(), weight = readInt();
			adj.get(to).add(new node (from, weight));
			adj.get(from).add(new node (to, weight));

		}
		int [] wnt = new int [d];
		for (int i = 0; i < d; i++) {
			wnt[i] = readInt();
		}
		
		PriorityQueue<node> queue = new PriorityQueue<node>();
		int wmax[] = new int [c+1];
		boolean vis[] = new boolean [c+1];		
		wmax[1] = Integer.MAX_VALUE;
		
		queue.add(new node(1,0));
		while (!queue.isEmpty()) {
			node cur = queue.poll(); int u = cur.to; int w = cur.weight;
			if(w > wmax[u]) continue;
			for (node k: adj.get(u)) {
				int u1 = k.to; int w1 = k.weight;
				if (w1 > wmax[u1]) {
					wmax[u1] = w1;
					queue.add(new node(u1,w1));
				}
			}

		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < d; i++) {
			ans = Math.min(ans, wmax[wnt[i]]);
		}
		System.out.println(ans);
	}
	static class node implements Comparable<node>{
		private int to;
		private int weight;
		public node (int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(node x) { return -Integer.compare(weight, x.weight); }

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
