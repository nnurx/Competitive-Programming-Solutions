package l3homework;
import java.util.*;
import java.io.*;
public class BGOIBoxen {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static boolean open[];
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int [] sols = new int [2];
		for (int bruh = 0; bruh < 2; bruh++) {
			int q = readInt();
			int parent [] = new int [q+1];
			open = new boolean [q+1];
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < q+1; i++) {
				adj.add(new ArrayList<Integer>());
			}
			for (int i = 1; i < q+1; i++) {
				int nd = readInt();
				adj.get(nd).add(i);
				parent[i] = nd;
			}
			
			int sol = soxen(q,adj,parent);
			sols[bruh] = sol;
			Arrays.fill(open, false);
		}
		System.out.println(sols[0] + " " + sols[1]);
		
	}
	static int soxen(int q,ArrayList<ArrayList<Integer>> adj,int parent []) {
		int broken = 0;
		for (int i = 1; i <q+1; i++) {
			int cv = 0;
			if (!open[i]) {
				cv = i;
				do {
	                boxen(cv,adj); cv = parent[cv];
	            } while (!open[cv]);
				broken ++;
			}
		}
		
		return broken;
	}
	static void boxen(int box, ArrayList<ArrayList<Integer>> adj) {
		open[box] = true;
		for (int i = 0; i < adj.get(box).size(); i++) {
			if (!open[adj.get(box).get(i)]) {
				boxen(adj.get(box).get(i),adj);
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
