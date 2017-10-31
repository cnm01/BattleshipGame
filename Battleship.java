public class Battleship {
	
	//field variables
	private int row;
	//battleship is made up of an array of Parts
	private Part[] parts;
	
	//constructor method passes parameters to fields and initialises a new Part array
	public Battleship(int row, int numOfParts) {
		
		this.row = row;
		//creates a new Part array with the number of slots specified
		this.parts = new Part[numOfParts];
		//for every slot a new part is created
		for ( int i = 0; i < numOfParts; i++ ) {
			parts[i] = new Part(this.row, i);
		}
		
	}
	
	//another constructor method takes different parameters to the other constructor method
	public Battleship(int row) {
		
		this.row = row;
		this.parts = new Part[5];
		for ( int i = 0; i < 5; i++ ) {
			parts[i] = new Part(this.row, i);
		}
		
	}
	
	//returns parts array
	public Part[] getParts() {
		
		return parts;
		
	}
	
	//hit method sets a part to destroyed if it exists on the ship
	public String hit(int row, int column) {
		
		//creates a new part with the coordinates passed in brackets
		Part hitPart = new Part(row, column);
		
		//for every part in Parts array
		for ( Part part : parts ) {
			//if this part is equivalent to the passed part
			if ( part.equals(hitPart) == true )  {
				//if this part is already destroyed
				if ( part.getDestroyed() == true ) {
					//return statement
					return "This part has already been destroyed!";
				} 
				//if part is not already destroyed
				else {
				//destroy part	
				part.destroyPart();
				//return statement
				return "Hit!";
				}
			}
		}
		
		//if part is not found return statement
		return "Miss!";
		
	}
	
	//overrides .equals method
	public boolean equals(Object ship) {
		
		//ships are equivalent if they have the same number of parts and arent sunk
		if ( ((Battleship)ship).getParts().length == getParts().length ) {
			
			//if ship is sunk
			boolean destroyed = true;
			for (Part part : ((Battleship)ship).getParts()) {
				if ( part.getDestroyed() == false) {
					destroyed = false;
				}
			}
			
			boolean destroyed2 = true;
			for (Part part : parts) {
				if ( part.getDestroyed() == false) {
					destroyed2 = false;
				}
			}
			
			//if both of the ships are not sunk
			if (destroyed == false && destroyed2 == false) {
				//returns true
				return true;
			
			//if one or both of the ships are sunk then they are not equivalent
			} else {
				//returns false
				return false;
			}
		
		//if ships do not have the same number of parts	
		} else {
			//returns false
			return false;
			
		}
		
	}
	
	//overrides toString method allows object to be printed in a readable format
	public String toString() {
		
		String toReturn = "";
		for ( int i = 0; i < parts.length; i++ ) {
			if ( parts[i].getDestroyed()==true ) {
				toReturn += "[X]";
			}
			else {
				toReturn += "[ ]";
			}
		}
		
		return toReturn;
		
	}
	
}