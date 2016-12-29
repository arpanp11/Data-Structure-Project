import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
	public String name;
	public Vertex predVertex;
	public double minimumDist = Double.POSITIVE_INFINITY;
	public List<Edge> adjacentEdges;
	
	/**
	 * constructor used to initializes the variables
	 * 
	 * @param name
	 */
	public Vertex(String name) {
		this.name = name;
		adjacentEdges = new ArrayList<Edge>();
	}

	/**
	 * add the edge to the vertex
	 * 
	 * @param e
	 */
	public void addEdge(Edge e) {
		adjacentEdges.add(e);
	}

	/**
	 * This method return the name of vertex
	 */
	public String toString() {
		return name;
	}

	public int compareTo(Vertex obj) {
		return Double.compare(minimumDist, obj.minimumDist);
	}

}
