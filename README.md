Shortest Path Finder Using BFS Algorithm

Author: Hunter Merrill

Description
This Java program finds the shortest path between two nodes in an unweighted graph using the Breadth-First Search (BFS) algorithm. 
The program reads the graph's adjacency list from a "data.txt" file and calculates the shortest path between user-specified start and end nodes.

Purpose
To provide a tool for efficiently finding the shortest path in an unweighted graph. Ideal for applications where understanding the shortest route or 
minimum number of steps between two points in a network is essential.

How It Works
The graph is represented as an adjacency list stored in "data.txt".
The program prompts users to enter the start and end nodes.
Utilizing BFS, it calculates the shortest path between these nodes if it exists and prints the path.
The program supports multiple queries and will continue to prompt the user until they decide to exit.
Handles invalid inputs and unreachable nodes robustly.

How to Use
Prepare "data.txt" with the adjacency list of the graph. Each line should represent connections from one node to others, separated by commas. For example:

1,2,3
2,4,5
3,6

This represents a graph where:

Node 1 is connected to Nodes 2 and 3.
Node 2 is connected to Nodes 4 and 5.
Node 3 is connected to Node 6.
Run the program. It will read the "data.txt" file and construct an adjacency list.

Follow the on-screen prompts to enter the start and end nodes. The program will then display the shortest path or notify the user if no path is found.

Users will have the option to find another path or exit the program.

Sample Output
Here is a sample output when finding the shortest path from Node 1 to Node 6 with the above example "data.txt":

Adjacency list:
Node 1 to Nodes 2, 3
Node 2 to Nodes 4, 5
Node 3 to Node 6

Paths to connect:
Start node: 1
End node: 6
Shortest path: 1 -> 3 -> 6

Dependencies
- Java
- The program reads from a file named "data.txt" which should be present in the project directory.

Notes
Ensure the "data.txt" file is formatted correctly to avoid errors. The program is intended for educational and informational purposes and can be adapted for various applications.













