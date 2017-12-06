/*
 * Name: Youssef Hussein
 * NetID: yhussein
 * 
 * "the work on this project is totally my own and I didn't receive any help on it".
 */


public class Cell {
	private int number = 0;
	private boolean empty = true;
	private boolean movable = true;
	
	
	public void print() {
		if(number == 0) 
			System.out.print(" *    ");
		else if(number < 10 && number> 0)
			System.out.print(" "+number+"    ");
		else if(number < 100 && number > 10)
			System.out.print(" "+number+"   ");
		else if(number < 1000 && number > 100)
			System.out.print(" "+number+"  ");
		else 
			System.out.print(" "+number+" ");
	}
	
	
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public boolean isMovable() {
		return movable;
	}
	public void setMovable(boolean addable) {
		this.movable = addable; 
	}
	
	
}
