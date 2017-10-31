//uses inheritance with Battleship as parent class
public class Minesweeper extends Battleship{
	
	//constructor method
	public Minesweeper(int row) {
		
		//send values to Battleship contructor
		super(row, 2);
		
	}
	
	//overrides hit method and replaces it with this method
	public String hit(int row, int column) {
			
			//makes new part with coordinates in brackets
			Part hitPart = new Part(row, column);
			
			//for every part in parts array
			for ( Part part : getParts() ) {
				//if this part has the same coordinates as the hitPart
				if ( part.equals(hitPart) == true )  {
					//if part is already destroyed
					if ( part.getDestroyed() == true ) {
						return "This part has already been destroyed!";
					} 
					//if part is not already destroyed
					else {
					//generate a random number 0 or 1 to simulate a 50% chance of damage	
					int chance = (int) Math.floor(Math.random() * 2);
					if ( chance == 0 ) {
						part.destroyPart();
						return "Part has been destroyed!";	
					} else {
						return "Ship was not damaged by hit, ship too resilient!";
					}
					
					}
				}
			}
			
			return "You missed!";
			
		}

}
