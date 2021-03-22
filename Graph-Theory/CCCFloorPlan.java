package l3homework;
import java.util.*;
import java.io.*;

public class CCCFloorPlan {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int [][] plan;
    static int f;
    static int r;
    static int c;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		f = readInt(); r = readInt(); c = readInt();
		plan = new int[r][c];
		for (int i = 0; i < r; i++) {
			String cura = readLine();
			for (int a = 0; a < c; a++) {
				char cur = cura.charAt(i);
				if (cur == 'I') {
					plan[i][a] = -1;	
				}
				else {
					plan[i][a] = 0;
				}
			}
		}
		
		int roomcount = 1;
		for (int i = 0; i < r; i++) {
			for (int a = 0; a < r; a++) {
				if (plan[i][a] == 0) {
					dfs(i,a,roomcount);
					roomcount++;
				}
			}
		}
		ArrayList<Integer>rooms = new ArrayList<Integer>();
		for (int i = 0; i < 500; i++) {
			rooms.add(0);
		}
		
		for (int i = 0; i < r; i++) {
			for (int a = 0; a < c; a++) {
				if (plan[i][a]>0) {
					rooms.set(plan[i][a], rooms.get(plan[i][a])+1);
				}
			}
		}
		Collections.sort(rooms);
		Collections.reverse(rooms);
		
		int floored = 0;
		for (int i = 0; i < rooms.size(); i++) {
			if (f-rooms.get(i)>=0 && rooms.get(i)!=0) {
				f-=rooms.get(i);
				floored++;
			}
			else {
				break;
			}
		}
		if (floored == 1) {
			System.out.println(floored + " room, "+ f + " square metre(s) left over");
		}
		else {
			System.out.println(floored + " rooms, "+ f + " square metre(s) left over");
		}
		
	}
	static void dfs(int cr, int cc, int roomcount) {
		if (cr>=0 && cr< r && cc<c&&cc>=0 && plan[cr][cc]==0) {
			plan [cr][cc] = roomcount;
			dfs(cr-1, cc, roomcount);
			dfs(cr+1,cc,roomcount);
			dfs(cr,cc+1,roomcount);
			dfs(cr,cc-1,roomcount);
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
