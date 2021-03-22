package l3homework;
import java.util.*;


import java.io.*;

public class WCTrainingRegimen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), m = readInt();
		ArrayList<ArrayList<node>> adj = new ArrayList<ArrayList<node>>();
		for (int i = 0; i < n+1; i++) {
			adj.add(new ArrayList<node>());
		}
		
		long gl [] =  new long [n+1];
		for (int i = 1; i < n+1; i++) {
			gl[i] =  readLong();
		}
		
		for (int i = 0; i < m; i++) {
			int n1 = readInt(), n2 = readInt(); long w = readLong();
			adj.get(n1).add(new node (n2,w));
			adj.get(n2).add(new node (n1,w));
		}
		
		PriorityQueue<node> queue = new PriorityQueue<node>();
		long [] dis = new long [n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		queue.add(new node (1,0));
		dis[1] = 0;
		while (!queue.isEmpty()) {
			node cur = queue.poll(); int n2 = cur.to; long d = cur.weight;
			if(d > dis[n2]) continue;
			for (node e: adj.get(n2)) {
				int v = e.to; long  w = e.weight;
				if(dis[v] > Math.max(w, d)) {
					dis[v] = Math.max(w, d);
					queue.add(new node(v,dis[v]));
				}
			}
		}
		
		if (dis[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			ArrayList<node> dissort = new ArrayList<node>();
			dissort.add(new node(0,0));
			for (int i = 1; i < n+1; i++) {
				dissort.add(new node (i,dis[i]));
			}
			Collections.sort(dissort);
			ArrayList<node> order = new ArrayList<node>();
			long minw = gl[1];
			for (int i = 2; i < n+1; i++) {
				int u = dissort.get(i).to; long w = dissort.get(i).weight;
				if (gl[u] < minw && dis[u] < dis[n]) {
					minw = gl[u];
					order.add(new node (u,w));
				}
			}
			
			long level = 1;
			long time = 0;
			int u = 1;
			for (node a: order) {
				long w = a.weight;
				time += (w-level)*gl[u];
				level = w;
				u = a.to;
			}
			
			time+= (dis[n]-level)*gl[u];
			System.out.println(time);
		}
		
		
		
	}
	
	static class node implements Comparable<node>{
		private int to;
		private long weight;
		public node(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(node x) { return Long.compare(weight, x.weight); }
		
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
