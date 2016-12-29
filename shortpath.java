import java.io.*;
import java.util.*;

public class ShortPath {

    static Map<String, Vertex> vertexMap;
    static Map<String, Integer> vertexMapCheck;

    public static void main(String args[]) {

        findRoutes();
    }

    private static void readFromFile() {

        vertexMap = new HashMap<String, Vertex>();
        vertexMapCheck = new HashMap<String, Integer>();
        int i = 0;
        File text = new File("graph.txt");

        try {
            Scanner scnr = new Scanner(text);
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                // store the source and destination edges
                String[] vertexEdgeDetails = line.split(" ");
                String from = vertexEdgeDetails[0];
                String to = vertexEdgeDetails[1];
                double weight = Double.parseDouble(vertexEdgeDetails[2]);

                Vertex vertexFromObj;
                Vertex vertexToObj;
                if (vertexMapCheck.get(from) == null) {// if new source vertex
                    vertexMapCheck.put(from, i);// add to map
                    vertexFromObj = new Vertex(from);// create object
                    vertexMap.put(from, vertexFromObj);
                    i++;
                }
                if (vertexMapCheck.get(to) == null) {// if new destination
                    // vertex
                    vertexMapCheck.put(to, i);
                    vertexToObj = new Vertex(to);
                    vertexMap.put(to, vertexToObj);
                    i++;
                }

                Vertex vertex = vertexMap.get(from);
                if (vertex != null) {
                    vertex.addEdge(new Edge(vertexMap.get(to), weight));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read from	file");
            System.out.println("graph.txt (The system cannot find the file specified)");
        }
    }

    private static void findRoutes() {

        Scanner sc = new Scanner(System.in);
        int sourceIndex;
        int destinationIndex;
        String awnser = "";
        Helper helper = new Helper();
        do {

            readFromFile();
            System.out.println("Following City Airports are Avaliable!!");
            Map<String, Integer> sortedMap = helper.getSortedMapByValues(vertexMapCheck);
            helper.printMenu(sortedMap);
            System.out.println();
            System.out.print("Enter the origin airport: ");
            sourceIndex = sc.nextInt();
            while (sourceIndex < 0 || sourceIndex >= sortedMap.size()) {
                System.out.println("Not a valid Index\nReEnter the source Index");
                sourceIndex = sc.nextInt();
            }

            System.out.print("Enter the destination Airport: ");
            destinationIndex = sc.nextInt();
            while (destinationIndex < 0 || destinationIndex >= sortedMap.size()) {
                System.out.println("Not a valid Index\nReEnter the destination Index");
                destinationIndex = sc.nextInt();
            }
            String sourceName = helper.getVertexByID(vertexMapCheck, sourceIndex);
            String destName = helper.getVertexByID(vertexMapCheck, destinationIndex);
            Vertex source = vertexMap.get(sourceName);
            Vertex destination = vertexMap.get(destName);
            Dijkstra dijkstra = new Dijkstra();
            System.out.println(" ");
            System.out.println("Shortest paths from(origin airport): " + source);
            dijkstra.computePaths(source);
            List<Vertex> path = dijkstra.getShortestPathTo(destination);
            System.out.println();
            System.out.println("Path: " + path);
            System.out.println();
            System.out.println("Do u want to continue?");
            System.out.println("Continue(Y/N)");
            awnser = sc.next();
        } while (awnser.equalsIgnoreCase("y"));
    }
} 
