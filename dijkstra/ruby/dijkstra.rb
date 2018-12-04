class Dijkstra

  def initialize(graph, origin, destination)
    @graph = graph
    @origin = origin
    @destination = destination
  end

  def compute_shortest_path
    unvisited = {}

    @graph.nodes.each do |node|
      unvisited[node] = (node == @origin) ? 0 : Float::MAX.to_i
    end

    p unvisited
  end

end
