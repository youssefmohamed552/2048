/*
 * Name: Youssef Hussein
 * NetID: yhussein
 * 
 * "the work on this project is totally my own and I didn't receive any help on it".
 */


public class Board {
	private final int length = 4;
	private final int width = 4;
	private Cell[][] board;
	private boolean isInitial = true;
	private int numPerBoard = 0;
	private boolean moveHappened = false;
	private int numOfValid = 0;
	
	
	public boolean getIsInitial() {
		return this.isInitial;
	}
	
	public void setIsInitial(boolean isInitial) {
		this.isInitial = isInitial;
	}
	
//	public int getNumberPerBoard() {
//		return numPerBoard;
//	}
//	
//	public void setNumberPerBoard(int numPerBoard) {
//		this.numPerBoard = numPerBoard;
//	}
	
	public Board() {
		board = new Cell[length][width];
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				board[i][j] = new Cell();
			}
		}
		
	}
	public int getNumOfValid() {
		if(moveHappened) {
			numOfValid++;
		}
		return this.numOfValid;
	}
	
	
	public void print() {
		moveHappened = false;
		numPerBoard = 0;
		System.out.println("-     -     -     -     -     -");
		for(int i = 0 ; i < length; i++) {
			System.out.print("|    ");
			for(int j = 0; j < width; j++) {
				board[i][j].print();
			}
			System.out.println(" |");
		}
		System.out.println("-     -     -     -     -     -");
//		System.out.println("number of valid moves is " +getNumOfValid());
	}
	
	public void fillCell(){
		int length = (int)(Math.random()*4);
		int width = (int)(Math.random()*4);
		//as long as the cell is not empty then
		while(!(board[length][width].isEmpty())){
			length = (int)(Math.random()*4);
			width = (int)(Math.random()*4);		
		}
		if(board[length][width].isEmpty()) {
			board[length][width].setNumber(randomInput());
			board[length][width].setEmpty(false);
		}
//		numPerBoard+=2;
	}
	//can any cell move
	
	public int randomInput() {
		double rand = Math.random();
		if(rand < 0.8)
			return 2;
		else
			return 4;
		
	}
	public void shiftCells(String dir) {
		switch(dir){
		//moving up
		case "w":
			moveUp();
			break;
		//moving down
		case "s":
			moveDown();
			break;
		//moving left
		case "a":
			moveLeft();
			break;
		//moving right
		case "d":
			moveRight();
			break;
		//if it's any other input
		default:
			System.out.print("Sorry! didn't recognise that");
		}
	}
	public void moveUp() {
		//numbers are moving up
		for(int j = 0;j < this.length;j++) {
			columnAddingUp(j);
		}
	}

	public void moveDown() {
		//numbers are moving down
		for(int j = 0;j < this.length;j++) {
			columnAddingDown(j);
		}
	}
	public void moveLeft() {
		//numbers are moving left
		for(int i = 0; i < this.width; i++) {
			rowAddingLeft(i);
		}
	}
	public void moveRight() {
		//number are moving right
		for(int i = 0; i < this.width; i++) {
			rowAddingRight(i);
		}
	}
	//adding up columns 
	public void columnAddingUp(int j) {
//		Cell temp = new Cell();
		int k = 0;
//		if(dir == 'u') {
//			k = 0;
//		}else if (dir == 'd') {
//			k = this.length - 1;
//		}
		
		for(int i = k; i < length;i++) {
			if(!(board[i][j].isEmpty())) {
				//move it to the highest empty
				board[k][j].setNumber(board[i][j].getNumber());
				//set it to full
				board[k][j].setEmpty(false);
				if(i != k ) {
					emptyUp(i,j);
				}
				//if the following has the same as the one above it then add it to it
				if(k != 0 && (board[k][j].getNumber() == board[k-1][j].getNumber())) {
					board[k-1][j].setNumber(board[k-1][j].getNumber() + board[k][j].getNumber());
					emptyUp(k,j);
//					numPerBoard--;
				}else {
						k++;
				}
				
				
//				return k+1;
			}
		}
	}
	public void columnAddingDown(int j) {
//		Cell temp = new Cell();
		int k = 0;
//		if(dir == 'u') {
//			k = 0;
//		}else if (dir == 'd') {
			k = this.length - 1;
//		}
		int l = k;
		
		for(int i = k; i >= 0; i--) {
			if(!(board[i][j].isEmpty())) {
				//save a temporary value for the number
//				temp.setNumber(board[i][j].getNumber());
				//move it to the highest empty
				board[k][j].setNumber(board[i][j].getNumber());
				//set it to full
				board[k][j].setEmpty(false);
				if(i != k ) {
					emptyUp(i,j);
				}
				//if the following has the same as the one above it then add it to it
				if(k != l && (board[k][j].getNumber() == board[k+1][j].getNumber())) {
					board[k+1][j].setNumber(board[k+1][j].getNumber() + board[k][j].getNumber());
					emptyUp(k,j);
//					numPerBoard--;
				}else {
						k--;
				}
				
				
//				return k+1;
			}
		}
	}
	//adding up rows
	public void rowAddingLeft(int i) {
//		Cell temp = new Cell();
		int k = 0;
		for(int j = k; j < width; j++) {
			if(!(board[i][j].isEmpty())) {
				//save a temporary value for the number
//				temp.setNumber(board[i][j].getNumber());
				//move it to the highest empty
				board[i][k].setNumber(board[i][j].getNumber());
				//empty up the old cell
				if(j != k) {
					emptyUp(i,j);
				}
				//set it to full
				board[i][k].setEmpty(false);
				//if the following has the same as the one above it then add it to it
				if(k != 0 && (board[i][k].getNumber() == board[i][k-1].getNumber())) {
					board[i][k-1].setNumber(board[i][k-1].getNumber() + board[i][k].getNumber());
					emptyUp(i,k);
//					numPerBoard--;
				}else {
					k++;
				}
				
				
//				return k+1;
			}
		}
	}
	
	public void rowAddingRight(int i) {
//		Cell temp = new Cell();
		int k = width-1;
		for(int j = k; j >= 0; j--) {
			if(!(board[i][j].isEmpty())) {
				//move it to the highest empty
				board[i][k].setNumber(board[i][j].getNumber());
				//empty up the old cell
				if(j != k) {
					emptyUp(i,j);
				}
				//set it to 
				board[i][k].setEmpty(false);
				//if the following has the same as the one above it then add it to it
				if(k != width-1 && (board[i][k].getNumber() == board[i][k+1].getNumber())) {
					board[i][k+1].setNumber(board[i][k+1].getNumber() + board[i][k].getNumber());
					emptyUp(i,k);
//					numPerBoard--;
				}else {
					k--;
				}
				
				
//				return k+1;
			}
		}
	}
	
	public void emptyUp(int i, int j) {
		board[i][j].setNumber(0);
		board[i][j].setEmpty(true);
		moveHappened = true;
	}
	
	public boolean full() {
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				if(!(board[i][j].isEmpty())) {
					numPerBoard++;
				}
			}
		}
		if(numPerBoard >= 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
//	public int emptyVertically(int j) {
//		int total = 0;
//		for(int i = 0; i < this.length; i ++) {
//			if(board[i][j].isEmpty()) {
//				total += 1;
//			}
//		}
//		return total;
//		
//	}
//	public int emptyHorizontally(int i) {
//		int total = 0;
//		for(int j = 0; j < this.length; j ++) {
//			if(board[i][j].isEmpty()) {
//				total += 1;
//			}
//		}
//		return total;
//		
//	}
}
