/*
 * Name: Youssef Hussein
 * NetID: yhussein
 * 
 * "the work on this project is totally my own and I didn't receive any help on it".
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//welcome the user to the game
		System.out.println("Welcome to the \"2048\" game.\nIn every turn you are going ot be "
				+ "given a random number of either \'2\' or \'4\' and you will give a direction."
				+ " \n\'w\' to add numbers upwards \n\'s\' to move numbers downwards.\n\'a\' to add"
				+ " up to the left.\'d\' to add up to the right.\n Also you can press \'q\' for "
				+ "quit and \'r\' for restart.\nNow let's start the game");
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		String input = "";
		do {
			//Start the game
			Game game = new Game();
			//check to see if it's the first time running the game
			if(board.getIsInitial() || input.equals("r")) {
				board = new Board();
				board.fillCell();
				board.setIsInitial(false);
				
			}
			board.fillCell();
			board.print();
//			System.out.print("Next Direction: ");
			do {
				System.out.print("Next Direction: ");
				input = scan.next();				
			}while(!(game.contains(input)));
			//if the input is any of the known functions 
			if(input.equals("r")) {
				board.setIsInitial(true);
				continue;
			}
			if(input.equals("q")) {
				break;
			}
			board.shiftCells(input);
			if(board.full()) {
				System.out.println("The game is Over");
				
				do {
					System.out.println("you could either choose \'r\' to restart or \'q\' to quit");
					input = scan.next();				
				}while(!(input.equals("r") || input.equals("q")));
			}
			
		}while(!(input.equals("q")));
		
		System.out.println("Thank You for playing the game");
		
	}
	
}
