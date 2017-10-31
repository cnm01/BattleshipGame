//imports scanner class
import java.util.Scanner;

public class Game {
	
	//main method
	public static void main(String[] args) {
		
		//creates new board
		Board board = new Board();
		
		//creates new scanner
		Scanner scanner = new Scanner(System.in);
		
		int userRow;
		int userColumn;
		String userInput = "";
			
		//main game loop
		do {
		
		//print number of ships
		System.out.println("Number of ships: " + board.getNumOfShips());
		
		//print the board
		System.out.println(board);
		
		//prints the instructions
		System.out.println("Enter a single row number followed by a\n" +
							"single column number seperated by a space:");
		
		//assigns userInput variable as the next line of user input
		userInput = scanner.nextLine();
		
		//if user enters "quit" then program ends and scanner is closed
		if (userInput.equals("quit")) {
			scanner.close();
			return;
		}
		
		else {
			
			//splits userInput into an array
			String[] parts = userInput.split(" ");
			
			//turns the strings in the array to integers
			userRow = Integer.parseInt(parts[0]);
			userColumn = Integer.parseInt(parts[1]);
			
			//if variables are not on the board
			if (userRow > 4 && userColumn > 4) {
				
				//does a modified version of the mainloop to avoid an error
				do {
				//prints messages	
				System.out.println("Miss!");
				System.out.println("Enter a single row number followed by a\n" +
						"single column number seperated by a space:");
				//assigns variable as next line of user input
				userInput = scanner.nextLine();
				if (userInput.equals("quit")) {
					scanner.close();
					return;
				}
				parts = userInput.split(" ");
				userRow = Integer.parseInt(parts[0]);
				userColumn = Integer.parseInt(parts[1]);
				} while(!(userRow < 5) && !(userColumn < 5));
			}
			
			//does a hit at the coordinates
			System.out.println(board.hit(userRow, userColumn));
		
		}
		
		//does the above while the statement is true
		} while (!userInput.equals("quit"));
		
		//closes the scanner
		scanner.close();
		
	}
	
}
