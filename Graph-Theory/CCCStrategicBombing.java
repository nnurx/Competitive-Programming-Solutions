import java.util.*;
import java.io.*;

public class CCCStrategicBombing {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static ArrayList<String> roads;
    static ArrayList<ArrayList<Integer>> properadj;
    static int [] []  adj;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input = "";
		adj = new int [27][27];
		properadj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 27; i++) {
			properadj.add(new ArrayList<Integer>());
		}
		roads = new ArrayList<String>();
		while (true) {
			input = readLine();
			if (input.equals("**")) {
				break;
			}
			roads.add(input);
			char [] parse = input.toCharArray();
			
			adj[translateChar(parse[0])][translateChar(parse[1])]=1;
			adj[translateChar(parse[1])][translateChar(parse[0])]=1;
			properadj.get(translateChar(parse[0])).add(translateChar(parse[1]));
			properadj.get(translateChar(parse[1])).add(translateChar(parse[0]));

		}
		int c = 0;
		for (int i = 0; i < roads.size(); i++) {
			char [] split = roads.get(i).toCharArray();
			int to = translateChar(split[0]); int from = translateChar(split[1]);
			boolean reached = bfs(to,from);
			if (!reached) {
				System.out.println(roads.get(i));
				c++;
			}
		}
		System.out.println("There are "+c+ " disconnecting roads.");
		
	}
	static boolean bfs (int n1, int n2) {
		boolean vis[] = new boolean [27];
		adj[n1][n2] =0;
		adj[n2][n1] =0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		vis[1] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < properadj.get(cur).size(); i++) {
				if (adj[cur][properadj.get(cur).get(i)] == 1) {
					if (!vis[properadj.get(cur).get(i)]) {
						vis[properadj.get(cur).get(i)] = true;
						queue.add(properadj.get(cur).get(i));
					}
				}
			}
		}
		adj[n1][n2] =1;
		adj[n2][n1] =1;
		return vis[2];
		
	}
	static int translateChar(char c) {
		return c-64;
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
