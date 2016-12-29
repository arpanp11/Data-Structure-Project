public class Edge {
	public final double weight;
	public Vertex targetVetex;

	public Edge(Vertex t, double w) {
		targetVetex = t;
		weight = w;
	}
}
