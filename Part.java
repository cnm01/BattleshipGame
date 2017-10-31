public class Part {
	
	//field variables
	private int row;
	private int column;
	private boolean destroyed;
	
	//constructor method
	public Part(int row, int column) {
		
		//assigns row passed in constructor to row field variable
		this.row = row;
		//assigns column passed in constructor to column field variable
		this.column = column;
		//sets destroyed to false as a default
		destroyed = false;
		
	}
	
	//returns row
	//no way of accessing from outside of class
	private int getRow() {
		
		return row;
		
	}
	
	//return column
	//no way of accessing from outside of class
	private int getColumn() {
		
		return column;
		
	}
	
	//sets a part as destroyed
	public void destroyPart() {
		
		destroyed = true;
		
	}
	
	//return whether or not a part is destroyed
	public boolean getDestroyed() {
		
		return destroyed;
		
	}
	
	//overides the .equals method
	//models that two parts can be equivalent if they have the same coordinates
	public boolean equals(Object part) {
		
		//if passed object is not a Part return false
		if ( !(part instanceof Part) ) {
			return false;
		}
		
		//if passed object is a Part
		else {
			
			//if the passed Part has the same coordinates as the one it is being compared to return true
			if (((Part)part).getRow()==row&&((Part)part).getColumn()==column) {
				return true;
			}
			
			else {
				//otherwise return false
				return false;
			}
		
		}
		
	}
	
	//overrides the toString method
	//allows the object to be printed in a suitable format
	public String toString() {
		
		//if part is destroyed
		if (destroyed == true) {
			return "[X]";
		}
		
		//if part is not destroyed
		else {
			return "[ ]";
		}
		
	}

}
