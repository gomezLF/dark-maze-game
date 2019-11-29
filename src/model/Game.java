package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.ietf.jgss.Oid;

import dataStructure.Edge;
import dataStructure.Vertex;
import javafx.scene.media.VideoTrack;

/**
 * Represents the game.
 */
public class Game {
	
	/**
	 * Indicates the number of trails that the character can illuminate.
	 */
	public static final int LIGHTING_LIMIT = 3;
	
	/**
	 * It represents the maze to create.
	 */
	private Maze maze;
	
	
	/**
	 * Create a new game.
	 */
	public Game() {
		
    }
	
	/**
	 * Return the maze.
	 * @return maze - It's the maze.
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * Inicializa todo el proceso para comenzar la creacion de un nuevo laberinto
	 * @param isMatrix
	 * @throws IOException 
	 */
	public void genareteMaze(boolean isMatrix) throws IOException{
		this.maze = new Maze(isMatrix);
		this.maze.fillMatrix();
		
		if (isMatrix) {
			this.maze.createMatrixAdyacent();
		}else {
			this.maze.createListAdyacent();
		}
	}


	/**
	 * Load the game state.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void loadGame() throws IOException, ClassNotFoundException, NullPointerException {
		ObjectInputStream ois = null;
		File file = new File("resourses/serialization/serialization.dat");
		if (!file.exists()) {
			file.createNewFile();
		} else {
			ois = new ObjectInputStream(new FileInputStream(file));
			maze = (Maze) ois.readObject();
		}
		ois.close();
	}
	
	
	/**
	 * Save the game state.
	 * @throws IOException 
	 */
	public void saveGame() throws IOException {
		File file = new File("resourses/serialization/serialization.dat");
		if (file.exists()) {
			file.delete();
		}
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(maze);
		oos.close();
	}
}
