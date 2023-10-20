/*
 * Author    : Hunter Merrill
 * Purpose   : This program is designed to find the shortest path between two nodes 
 *             in an unweighted graph using Breadth-First Search (BFS) algorithm. The graph is 
 *             represented as an adjacency list which is read from a file named "data.txt". 
 *             The user is prompted to enter the start and end nodes, and the program calculates 
 *             the shortest path between these nodes, if it exists, and prints it out. The program 
 *             supports multiple queries and will continue to prompt the user until they decide 
 *             to exit. It ensures robust handling of different cases including invalid inputs and 
 *             unreachable nodes.
 * */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestPath {

	private static Map<Integer, List<Integer>> graph = new HashMap<>();

	public static void main(String[] args) {
		String fileName = "data.txt";
		readGraphFromFile(fileName);
		printAdjacencyList();

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Paths to connect:");
			System.out.print("Start node: ");
			int startNode = scanner.nextInt();
			System.out.print("End node: ");
			int endNode = scanner.nextInt();

			if (!nodeExists(startNode) || !nodeExists(endNode)) {
				System.out.println("Invalid nodes. Try again.");
				continue;
			}

			List<Integer> path = bfs(startNode, endNode);
			if (path != null) {
				System.out.println("Shortest path: " + path.toString().replace("[", "").replace("]", ""));
			} else {
				System.out.println("Path not found.");
			}

			System.out.print("Input another path to connect? (Y/N) ");
			String choice = scanner.next();
			if (choice.equalsIgnoreCase("N")) {
				break;
			}

			printAdjacencyList();
		}
		scanner.close();
	}

	private static void readGraphFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] nodes = line.split(",");
				int parent = Integer.parseInt(nodes[0].trim());
				graph.put(parent, new ArrayList<>());
				for (int i = 1; i < nodes.length; i++) {
					int child = Integer.parseInt(nodes[i].trim());
					graph.get(parent).add(child);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printAdjacencyList() {
		System.out.println("Adjacency list:");
		graph.forEach((parent, children) -> {
			if (children.size() == 1) {
				System.out.println("Node " + parent + " to Node " + children.get(0));
			} else {
				System.out.println(
						"Node " + parent + " to Nodes " + children.toString().replace("[", "").replace("]", ""));
			}
		});
	}

	private static boolean nodeExists(int node) {
		if (graph.containsKey(node))
			return true;
		return graph.values().stream().anyMatch(children -> children.contains(node));
	}

	private static List<Integer> bfs(int start, int end) {
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(start));
		Set<Integer> visited = new HashSet<>();
		visited.add(start);

		while (!queue.isEmpty()) {
			List<Integer> path = queue.poll();
			int node = path.get(path.size() - 1);

			if (node == end) {
				return path;
			}

			for (int adjacent : graph.getOrDefault(node, Collections.emptyList())) {
				if (!visited.contains(adjacent)) {
					visited.add(adjacent);
					List<Integer> newPath = new ArrayList<>(path);
					newPath.add(adjacent);
					queue.add(newPath);
				}
			}
		}

		return null;
	}
}

