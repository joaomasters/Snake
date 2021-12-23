package Components;

import Game.World;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

/*
 * Class: Tile
 * 
 * Purpose:
 *  Base tile type
 */

public class Tile {
	private Tiles tileType;
	private int x, y;
	private int lX, lY;
	
	public Tile(Tiles tileType,
				int x, int y) {
		this.tileType = tileType;
		
		this.x = x;
		this.y = y;
		
		lX = x;
		lY = y;
	}
	
	// toStringing! :D
	public String toString() { return "TileType: " + tileType + "\nX: " + x + "\nY: " + y; }
	
	// Checking if the tile is on another tile
	public boolean on(Tile t) { return getX() == t.getX() && getY() == t.getY(); }
	
	// Moving
	public void moveTo(int x, int y) { setPosition(x, y); }
	public void move(int dX, int dY) {
		setX(getX() + dX);
		setY(getY() + dY);
	}
	
	public void moveUp() { move(0, -1); }
	public void moveDown() { move(0, 1); }
	public void moveLeft() { move(-1, 0); }
	public void moveRight() { move(1, 0); }
	
	// Drawing
	public void render(Graphics g, World w) {
		g.setColor(new Color(220, 220, 220));
		g.fillRect(x * w.getTileWidth(), y * w.getTileHeight(), w.getTileWidth(), w.getTileHeight());
		
		g.setColor(new Color(155, 155, 155));
		g.fillRect(x * w.getTileWidth() + w.getTileWidth() - 2, y * w.getTileHeight(), 2, w.getTileHeight());
		g.fillRect(x * w.getTileWidth(), y * w.getTileHeight() + w.getTileHeight() - 2, w.getTileWidth(), 2);
		
		g.setColor(new Color(255, 255, 255));
		g.fillRect(x * w.getTileWidth(), y * w.getTileHeight(), w.getTileWidth(), 2);
		g.fillRect(x * w.getTileWidth(), y * w.getTileHeight(), 2, w.getTileHeight());
	}
	
	// Accessors
	public Tiles getTileType() { return tileType; }
	public int[] getPosition() { return new int[] { getX(), getY() }; }
	public int getX() { return x; }
	public int getY() { return y; }
	public int[] getLastPosition() { return new int[] { getLastX(), getLastY() }; }
	public int getLastX() { return lX; }
	public int getLastY() { return lY; }
	
	// Mutators
	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void setX(int x) {
		lX = this.x;
		this.x = x;
	}
	
	public void setY(int y) {
		lY = this.y;
		this.y = y;
	}
}
