
public class Board {
	
	//field values
	private Battleship[] ships;
	
	//constructor method
	public Board() {
		
		//initiates a new Battleship array with 5 slots
		//each slot models a row
		ships = new Battleship[5];
		//first slot holds a battleship
		ships[0] = new Battleship(0);
		//second slot holds a Cruiser
		ships[1] = new Cruiser(1);
		//third slot holds a cruiser
		ships[2] = new Cruiser(2);
		//fourth slot holds a frigate
		ships[3] = new Frigate(3);
		//last slot holds a minesweeper
		ships[4] = new Minesweeper(4);
		//since each ship has a number of parts these will serve as columns
		
	}
	
	//returs ships array
	public Battleship[] getShips() {
		
		return ships;
		
	}
	
	//hits a ship at the coordinates specified
	public String hit(int x, int y) {
		
		return ships[x].hit(x, y);
		
	}
	
	//overrides toString method to print object in  readable format
	public String toString() {
		
		return	ships[0] + "\n" +
				ships[1] + "[ ]" + "\n" +
				ships[2] + "[ ]" + "\n" +
				ships[3] + "[ ][ ]" + "\n" +
				ships[4] + "[ ][ ][ ]";
				
	}
	
	//return the number of unsunken ships on the board
	public int getNumOfShips() {

		int numOfShips = 0;
				
				//for every ship on the board
				for (Battleship ship : ships) {
					
					boolean destroyed = true;
					
					//if a part on the ship is not destroyed then ship is not sunk
					for (Part part : ship.getParts() ) {
						
						if (part.getDestroyed()==false) {
							destroyed = false;
						}
					}
					//if ship is not sunk then add one to number of ships
					if (destroyed == false) {
						numOfShips++;
					}
				}
				
		//return the number of ships		
		return numOfShips;		
	}
	
}