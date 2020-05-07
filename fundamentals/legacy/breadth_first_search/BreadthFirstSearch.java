package breadth_first_search;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BreadthFirstSearch {
	
	public final static int EDGE_WEIGHT = 6;
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int q = input.nextInt();
		for(int query = 0; query < q; query++){
			
			int n = input.nextInt();
			int m = input.nextInt();
			
			Node[] nodes = new Node[n];
			
			for(int i = 0; i < n; i++)
				nodes[i] = new Node(i + 1);

			for(int edge = 0; edge < m; edge++){
				int src = input.nextInt();
				int dest = input.nextInt();
				if(!nodes[src - 1].getAdjacentNodes().contains(nodes[dest - 1])){
					nodes[src - 1].addAdjacentNode(nodes[dest - 1]);
					nodes[dest - 1].addAdjacentNode(nodes[src - 1]);
				}
			}
			
			int startingNode = input.nextInt();
	
			int [] distances = search(nodes, startingNode);
			
			for(int d : distances)
				if(d != 0)
					System.out.print(d + " ");
			System.out.println();
		}
	}
	public static int[] search(Node[] nodes, int startingNode){
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(nodes[startingNode - 1]);
		
		int [] distances = new int[nodes.length];
		for(int d = 0; d < distances.length; d++)
			distances[d] = -1;
		
		distances[startingNode - 1] = 0;
		
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			ArrayList<Node> neighbours = currentNode.getAdjacentNodes();
			
			for(Node n : neighbours){
				if(distances[n.getLabel() - 1] == -1){
					distances[n.getLabel() - 1] = distances[currentNode.getLabel() - 1] + EDGE_WEIGHT;
					queue.add(n);
				}
			}
		}
		
		return distances;
	}
	
}
