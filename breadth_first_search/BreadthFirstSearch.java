package breadth_first_search;
import java.util.Scanner;

public class BreadthFirstSearch {
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
				
				nodes[src - 1].addAdjacentNode(nodes[dest - 1]);
			}
			int startingNode = input.nextInt();
			
			for(int i = 0; i < nodes.length; i++){
				for(int j = 0; j < nodes[i].getAdjacentNodes().size(); j++){
					System.out.println(nodes[i].getLabel() + " --> " + nodes[i].getAdjacentNodes().get(j).getLabel());
				}
			}
		}
	}
}
