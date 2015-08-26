package com.GGI.GoG.Game.Objects;

public class Item {

	private int ID;
	private boolean edible = false;
	private boolean weildable = false;
	
	public Item(int ID){
	ID=ID;
	lookup(ID);
	}

	private void lookup(int x) {
		// TODO get item stats
		
	}
	
	public int eat(){
		if(edible){
			// TODO return correct health
		}
		return -1;
	}
	
}
