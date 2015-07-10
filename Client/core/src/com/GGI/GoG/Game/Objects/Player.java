package com.GGI.GoG.Game.Objects;

public class Player{
	public float x,y;
	public int dX,dY;
	public float speed;
	
	
	public void render(){
		float theta = (float) Math.atan((dY-y)/(dX-x));
		x+=speed*Math.cos(theta);
		y+=speed*Math.sin(theta);
	}
}
