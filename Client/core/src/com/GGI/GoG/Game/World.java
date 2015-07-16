package com.GGI.GoG.Game;

import java.util.ArrayList;

import com.GGI.GoG.Game.Objects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class World {
	public int gridX=50,gridY=50;
	public ArrayList<Player> players = new ArrayList<Player>();
	public float gridSize;
	public float w=Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	public float oX=0,oY=0;
	public ShapeRenderer shape;
	public boolean debugGrid = false;
	public Texture bg;
	public Texture grass1,grass2,grass3,grass4,grass5;
	public SpriteBatch pic;
	public int[][] grid = new int[gridX][gridY];
	public World(){
		gridSize=h/10;
		pic = new SpriteBatch();
		grass1= new Texture(Gdx.files.internal("Ground/Grass/1.jpg"));
		grass2= new Texture(Gdx.files.internal("Ground/Grass/2.jpg"));
		grass3= new Texture(Gdx.files.internal("Ground/Grass/3.jpg"));
		grass4= new Texture(Gdx.files.internal("Ground/Grass/4.jpg"));
		grass5= new Texture(Gdx.files.internal("Ground/Grass/5.jpg"));
		shape = new ShapeRenderer();
		
		for(int i = 0;i<gridX;i++){
			for(int j = 0;j<gridY;j++){
				grid[i][j]=(int)(Math.random()*5)+1;
			}
		}
	}
	
	public void render(int id) {
		for(int i = 0; i<players.size();i++){
			if(id==players.get(i).id){
				oX=players.get(i).x-w/2;
				oY=players.get(i).y-h/2;
			}
		}
		
		
		//
		
		
		shape.begin(ShapeType.Line);
		shape.setColor(Color.WHITE);
		
		
		
		pic.begin();
		
		for(int i = 0;i<gridX;i++){
			for(int j = 0; j<gridY;j++){
				switch(grid[i][j]){
				case 1:pic.draw(grass1,i*gridSize-oX,j*gridSize-oY,gridSize,gridSize);break;
				case 2:pic.draw(grass2,i*gridSize-oX,j*gridSize-oY,gridSize,gridSize);break;
				case 3:pic.draw(grass3,i*gridSize-oX,j*gridSize-oY,gridSize,gridSize);break;
				case 4:pic.draw(grass4,i*gridSize-oX,j*gridSize-oY,gridSize,gridSize);break;
				case 5:pic.draw(grass5,i*gridSize-oX,j*gridSize-oY,gridSize,gridSize);break;
				}
			}
		}
		//pic.draw(bg,-oX,-oY,gridSize*gridX,gridSize*gridY);
		pic.end();
		if(debugGrid){
			System.out.println(oX);
			System.out.println(oY);
		for(int i =0;i<gridX;i++){
			//pic.draw(grass,i*gridSize-oX,0-oY,gridSize,gridSize);
			shape.line(i*gridSize-oX,0-oY,i*gridSize-oX,gridY*gridSize-oY);
		}
		for(int i =0;i<gridY;i++){
			//pic.draw(grass,0-oX,i*gridSize-oY,gridSize,gridSize);
			shape.line(0-oX,i*gridSize-oY,gridX*gridSize-oX,i*gridSize-oY);
		}
		}
		//pic.end();
		shape.end();
		
		
		
		for(int i =0;i<players.size();i++){
			players.get(i).render(oX,oY);
		}
		
	}

	public void addPlayer(float x, float y, int dX, int dY){
		players.add(new Player(x,y,dX,dY,gridSize));
	}

	public void movePlayer(int id, int screenX, int screenY) {
		for(int i =0;i<players.size();i++){
			if(players.get(i).id==id){
				players.get(i).dX=(int) ((screenX+oX)/gridSize);
				players.get(i).dY=(int) ((screenY+oY)/gridSize);
			}
		}
		
	}
	
}
