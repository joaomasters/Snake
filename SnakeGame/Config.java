package org.crockeo.snake;

import org.newdawn.slick.Input;

import java.io.*;

/*
 * Class: Config
 * 
 * Purpose:
 *  Main configuration file for Snake game.
 */

public class Config {
	public static boolean writeConfig() {
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(new File(fileLocation)));
			
			// Display config
			writer.write(displayWidthPrefix + " " + displayWidth + '\n');
			writer.write(displayHeightPrefix + " " + displayHeight + '\n');
			
			// Key config
			writer.write(upKeyPrefix + " " + upKey + '\n');
			writer.write(downKeyPrefix + " " + downKey + '\n');
			writer.write(leftKeyPrefix + " " + leftKey + '\n');
			writer.write(rightKeyPrefix + " " + rightKey + '\n');
			writer.write(selectKeyPrefix + " " + selectKey + '\n');
			
			// Game config
			writer.write(boardWidthPrefix + " " + boardWidth + '\n');
			writer.write(boardHeightPrefix + " " + boardHeight + '\n');
			
			writer.close();
		} catch (IOException e) { return true; }
		
		return false;
	}
	
	public static boolean readConfig() {
		BufferedReader reader;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(new File(fileLocation)));
			
			while ((line = reader.readLine()) != null) {
				if (line.split(" ")[0] == displayWidthPrefix)
					displayWidth = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == displayHeightPrefix)
					displayHeight = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == upKeyPrefix)
					upKey = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == downKeyPrefix)
					downKey = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == leftKeyPrefix)
					leftKey = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == rightKeyPrefix)
					rightKey = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == selectKeyPrefix)
					selectKey = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == boardWidthPrefix)
					boardWidth = Integer.parseInt(line.split(" ")[1]);
				else if (line.split(" ")[0] == boardHeightPrefix)
					boardHeight = Integer.parseInt(line.split(" ")[1]);
			}
			
			reader.close();
		} catch (IOException e) { return true; }
		
		return false;
	}
	
	private static final String fileLocation = "config.cfg";
	
	// Display config
	public static int displayWidth  = 640; public static final String displayWidthPrefix  = "display_width";
	public static int displayHeight = 640; public static final String displayHeightPrefix = "display_height";
	
	// Key config
	public static int upKey     = Input.KEY_W;     public static final String upKeyPrefix     = "key_up";
	public static int downKey   = Input.KEY_S;     public static final String downKeyPrefix   = "key_down";
	public static int leftKey   = Input.KEY_A;     public static final String leftKeyPrefix   = "key_right";
	public static int rightKey  = Input.KEY_D;     public static final String rightKeyPrefix  = "key_right";
	public static int selectKey = Input.KEY_SPACE; public static final String selectKeyPrefix = "key_select";
	
	// Game config
	public static int boardWidth  = 20; public static final String boardWidthPrefix  = "board_width";
	public static int boardHeight = 20; public static final String boardHeightPrefix = "board_height";
}
