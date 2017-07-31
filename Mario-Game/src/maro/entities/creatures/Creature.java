package maro.entities.creatures;

import maro.Handler;
import maro.entities.Entity;
import maro.game.Game;
import maro.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height); //this will connect to the constructor in class "Entity"
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		
		if (xMove > 0) { //moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //checks if no solid tile is present
				x += xMove;
			}
		}
		else if(xMove < 0) { //moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) { //checks if no solid tile is present
				x += xMove;
			}
		}
	}
	
	public void moveY() {
		if (yMove < 0) { //moving up
			
			int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			
		}
		else if (yMove > 0) { //moving down
			int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	//getters and setters begin here

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	class FireBall{
		
	}
	
	
	
}
