package com.GGI.GoG.Game.Objects.Storage;

import com.GGI.GoG.Game.Objects.Item;
import com.GGI.GoG.Game.Objects.Player;

public class Weilding {

	public Player player;
	
	public Item head;
	public Item chest;
	public Item legs;
	public Item main;
	public Item off;
	public Weilding(Player player){
		this.player=player;
	}
	
}
