package customInterface;

import java.util.ArrayList;

import dataStructure.Edge;

/**
 * Interface that represents a graph.
 */
public interface IGraph<T extends Comparable<T>, E extends Comparable<E>>  {
	
	/**
	 * Determine that the graph is direct.
	 */
	public static final boolean DIRECTED = true;
	/**
	 * Determine that the graph is not direct
	 */
	public static final boolean NOT_DIRECTED = true;
	/**
	 * This method adds an edge to the graph
	 * @param from Origin of the edge
	 * @param destination Where the edge ends.
	 * @param directed True if the edge is directed or false if not.
	 * @param cost The edge cost value
	 */
	void addEdge(T from, T destination, boolean directed, double cost, E value);
	
	/**
	 * This method removes an edge of the graph.
	 * @param from  Origin of the edge
	 * @param destination Where the edge ends.
	 * @param directed True if the edge is directed or false if not.
	 * @param cost The edge cost value
	 */
	void removeEdge(T from, T destination, boolean directed, double cost);
	
	/**
	 * This method adds a vertex to the graph. 
	 * @param valueVertex The value that the vertex will have.
	 */
	void addVertex(T valueVertex);
	
	/**
	 * This method removes a vertex of the graph.
	 * @param valueVertex The vertex value that will be removed.
	 */
	void removeVertex(T valueVertex);
	
	
	/**
	 * This method verifies if two vertex are adjacent or not
	 * @param vertexA The origin vertex.
	 * @param vertexB The destination vertex.
	 * @return True if these vertices have an edge. False if not.
	 */
	boolean isAdjacent(T vertexA, T vertexB);
	
	/**
	 * This method gives the number vertices of the graph.
	 * @return number vertices of the graph
	 */
	int getNumVertex();

	/**
	 * This method returns the list of edges of the vertex
	 */
	ArrayList<Edge<?>> getEdgesOfVertex(T vertex);
	
	/**
	 * Returns the index of the vertex.
	 */
	int getIndexVertex(T valueVertex);
}
