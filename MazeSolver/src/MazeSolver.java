import java.util.LinkedList;

public class MazeSolver {
	
	static int[][] maze = {
			{1,1,1,1,0,1,1,1,0,1,0},
			{0,0,1,1,1,1,0,1,1,1,0},
			{0,0,0,1,0,1,1,0,1,1,1},
			{1,1,1,2,0,1,0,1,0,1,0},
			{0,0,1,0,1,1,0,0,0,1,0},
			{0,0,0,1,0,1,1,0,1,1,0}
	};
	//0= wall
	//1= path
	//2= destination
	
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
	
		Position p = new Position(4,9);
		path.push(p);
		
		
		while(true) {
			int x = path.peek().x;
			int y = path.peek().y;
			maze[x][y] = 0;
			if(isValid(x+1,y)) {
				//down
				if(maze[x+1][y]==2) {
					System.out.println("Moved down. \nYou won!");
					return;
				}else if(maze[x+1][y] ==1) {
					System.out.println("Moved down.");
					path.push(new Position(x+1,y));
					continue;
				}
			}
			
			
			if(isValid(x,y-1)) {
				//left
				if(maze[x][y-1]==2) {
					System.out.println("Moved left. \nYou won!");
					return;
				}else if(maze[x][y-1] ==1) {
					System.out.println("Moved left.");
					path.push(new Position(x,y-1));
					continue;
				}
			}
			
			if(isValid(x-1,y)) {
				//up
				if(maze[x-1][y]==2) {
					System.out.println("Moved up. \nYou won!");
					return;
				}else if(maze[x-1][y] ==1) {
					System.out.println("Moved up.");
					path.push(new Position(x-1,y));
					continue;
				}
			}
			
			if(isValid(x,y+1)) {
				//right
				if(maze[x][y+1]==2) {
					System.out.println("Moved right. \nYou won!");
					return;
				}else if(maze[x][y+1] ==1) {
					System.out.println("Moved right.");
					path.push(new Position(x,y+1));
					continue;
				}
			}
			path.pop();
			System.out.println("Moved back.");
			if(path.size() <= 0) {
				System.out.println("No path.");
				return;
			}
		}
	}
	public static boolean isValid(int x, int y) {
		if(x<0 || x >= maze.length || y<0|| y>=maze[x].length) {
			return false;
		}
		return true;
	}
}
