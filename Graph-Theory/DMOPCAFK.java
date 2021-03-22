package l3homework;
import java.util.*;
import java.io.*;

public class DMOPCAFK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int tc = readInt();
		for (int b = 0; b < tc; b++) {
			int x = readInt(); int y = readInt();
			int spx = 0; int spy = 0; int fx = 0; int fy = 0;
			char [][] home = new char [x][y];
			for (int i = 0; i < y; i++) {
				char[] curval = readLine().toCharArray();
				for (int a = 0; a < curval.length; a++) {
					if (curval[a] == 'C') {
						spx = a; spy = i; home[a][i] = curval[a];
					}
					else if (curval[a] == 'W') {
						fx = a; fy = i; home [a][i] = curval[a];
					}
					else {
						home[a][i] = curval[a];
					}
 				}
			}
			ArrayList <point> queue = new ArrayList<point>();
			boolean [][] reached = new boolean [x][y];
			int [][] steps = new int [x][y];
			queue.add(new point (spx, spy));
			reached[spx][spy] = true;
			steps [spx][spy] = 0;
			while (!queue.isEmpty()) {
				point cur = queue.get(0);
				if (cur.x > 0) {
					if (home [cur.x-1][cur.y] != 'X') {
						if (!reached[cur.x-1][cur.y]) {
							queue.add(new point (cur.x-1,cur.y));
							steps[cur.x-1][cur.y] = steps[cur.x][cur.y]+1;
							reached[cur.x-1][cur.y]=true;
						}
					}
				}
				if (cur.x < x-1) {
					if (home [cur.x+1][cur.y] != 'X') {
						if (!reached[cur.x+1][cur.y]) {
							queue.add(new point (cur.x+1,cur.y));
							steps[cur.x+1][cur.y] = steps[cur.x][cur.y]+1;
							reached[cur.x+1][cur.y]=true;
						}
					}
				}
				if (cur.y < y-1) {
					if (home [cur.x][cur.y+1] != 'X') {
						if (!reached[cur.x][cur.y+1]) {
							queue.add(new point (cur.x,cur.y+1));
							steps[cur.x][cur.y+1] = steps[cur.x][cur.y]+1;
							reached[cur.x][cur.y+1]=true;
						}
					}
				}
				if (cur.y > 0) {
					if (home [cur.x][cur.y-1] != 'X') {
						if (!reached[cur.x][cur.y-1]) {
							queue.add(new point (cur.x,cur.y-1));
							steps[cur.x][cur.y-1] = steps[cur.x][cur.y]+1;
							reached[cur.x][cur.y-1]=true;
						}
					}
				}
				queue.remove(0);
			}
			if (steps[fx][fy]>=60||steps[fx][fy]==0) {
				System.out.println("#notworth");
			}
			else {
				System.out.println(steps[fx][fy]);
			}
			
			
		}
	}

	static class point{
		private int x;
		private int y;
		point (int x, int y){
			this.x = x;
			this.y = y;
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
