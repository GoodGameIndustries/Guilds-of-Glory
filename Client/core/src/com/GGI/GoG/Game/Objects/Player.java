package com.GGI.GoG.Game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player{
	public float x,y;
	public int dX,dY;
	public float speed = 1;
	public float gridSize;
	public int id =0;
	public ShapeRenderer shape;
	public float theta=0,anim=0;
	public boolean up=true,move=false;
	public float w=Gdx.graphics.getWidth(),h=Gdx.graphics.getHeight();
	public TextureRegion head,body,legs,arms;
	public SpriteBatch pic = new SpriteBatch();
	
	public Player(float x, float y, int dX, int dY,float gridSize){
		this.gridSize=gridSize;
		shape = new ShapeRenderer();
		this.x=x;this.y=y;this.dX=dX;this.dY=dY;
		head = new TextureRegion(new Texture(Gdx.files.internal("Player/Head.png")));
		body = new TextureRegion(new Texture(Gdx.files.internal("Player/Body.png")));
		legs = new TextureRegion(new Texture(Gdx.files.internal("Player/Legs.png")));
		arms = new TextureRegion(new Texture(Gdx.files.internal("Player/Arms.png")));
	}
	
	public void render(float oX, float oY){
		float xR=-1;float yR=-1;
		boolean xU=false;
		move=false;
		if(dX*gridSize>x){x+=speed;xU=true;move=true;}
		else if(dX*gridSize<x){x-=speed;move=true;}
		if(dY*gridSize>y){y+=speed;move=true;}
		else if(dY*gridSize<y){y-=speed;move=true;}
		
		if(move){
		if(up){anim+=speed/2;if(anim>7){up=false;}}
		else{anim-=speed/2;if(anim<-7){up=true;}}
		}else{
			anim=0;
		}
		
		if(dX*gridSize>x||xU){
			if(dY*gridSize>y){theta=315;}
			else if(dY*gridSize<y){theta=225;}
			else{theta=270;}
		}
		else if(dX*gridSize<x){
			if(dY*gridSize>y){theta=45;}
			else if(dY*gridSize<y){theta=135;}
			else{theta=90;}
		}	
		else{
			if(dY*gridSize>y){theta=0;}
			else if(dY*gridSize<y){theta=180;}
		}
			
		
		//System.out.println("X: " + x +"Y: "+y);
		/*shape.begin(ShapeType.Filled);
		shape.setColor(Color.WHITE);
		//System.out.println(theta);
			shape.rect((x)-oX,(y+3*gridSize/8)-oY,gridSize/2,gridSize/8,gridSize,gridSize/4,1,1,theta+anim);
		shape.end();*/
		
		pic.begin();
		System.out.println(theta);
		
		pic.draw(legs, (x)-oX, y-oY, gridSize/2, gridSize/2, gridSize, gridSize, 1, 1, theta-anim);
		pic.draw(arms, (x)-oX, y-oY, gridSize/2, gridSize/2, gridSize, gridSize, 1, 1, theta+(int)(2*anim));
		pic.draw(body, (x)-oX, y-oY, gridSize/2, gridSize/2, gridSize, gridSize, 1, 1, theta+anim);
		pic.draw(head, (x)-oX, y-oY, gridSize/2, gridSize/2, gridSize, gridSize, 1, 1, theta);
		pic.end();
	}

	public boolean isNaN(float x){return x != x;}
}
