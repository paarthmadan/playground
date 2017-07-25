package dijkstra;

public class Vertex {
	
	private String name;
	
	public Vertex(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean equals(Vertex that){
		if(this.name.equals(that.getName())){
			return true;
		}else{
			return false;
		}
	}
	
}
