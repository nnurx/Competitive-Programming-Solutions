package l3homework;
import java.util.*;
import java.io.*;

public class WCGymTour {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int towns; static int gyms; static int dtown;
    static boolean gymtown[];
    static int deep;
    static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		towns = readInt(); gyms = readInt(); dtown = readInt();
		adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < towns+1; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		gymtown = new boolean [towns+1];
		deep = 0;

		int [] g = new int [gyms];

		for (int i = 0; i < gyms; i++) {
			int gym = readInt();
			g[i] = gym;
			gymtown[gym] = true;
		}
		for (int i = 0; i < towns-1; i++) {
			int from = readInt(), to = readInt();
			adj.get(from).add(to);
			adj.get(to).add(from);
		}
		checkgym(1,0);
		gymtown [1] = false;
 		boolean vis [] = new boolean [towns+1];
		vis[1] = true;
		int []reach = new int [towns+1];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < adj.get(cur).size(); i++) {
				if (gymtown[adj.get(cur).get(i)] && !vis[adj.get(cur).get(i)]) {
					queue.add(adj.get(cur).get(i));
					vis[adj.get(cur).get(i)] = true;
					reach[adj.get(cur).get(i)] = reach[cur]+1;
					deep = Math.max(deep, reach[adj.get(cur).get(i)]);
				}
			}
		}
		int e = 0;
		for (int i = 0; i < towns+1; i++) {
			if (gymtown[i]) e++;
		}
		int ans1 = 2*e-deep;
		
		gymtown [dtown] = true;
		checkgym(1,0);
		gymtown [1] = false;

		e=0;
		for (int i = 0; i < towns+1; i++) {
			if (gymtown[i]) e++;
		}
		
		System.out.println(Math.min(e, ans1));
		

	}
	
	static void checkgym(int cur, int prev ) {
		for (int i = 0; i < adj.get(cur).size(); i++) {
			if (adj.get(cur).get(i) == prev) continue;
			checkgym(adj.get(cur).get(i), cur);
			if (gymtown[adj.get(cur).get(i)]) { 
				gymtown [cur] = true;
			}
		}
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
