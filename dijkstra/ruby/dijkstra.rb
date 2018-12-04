class Dijkstra

  def initialize(graph, origin, destination)
    @graph = graph
    @origin = origin
    @destination = destination
  end

  def compute_shortest_path
    unvisited = {}
    predecessors = {}
    @graph.nodes.each { |node| unvisited[node] = (node == @origin) ? 0 : Float::MAX.to_i }

    current_node = @origin

    until unvisited.length == 0 || !unvisited.keys.include?(@destination)
      current_node.edges.each do |outgoing_edge|
        if unvisited[current_node] + outgoing_edge.cost < unvisited[outgoing_edge.to]
          predecessors[outgoing_edge.to] = current_node
          unvisited[outgoing_edge.to] = unvisited[current_node] + outgoing_edge.cost
        end
      end

      unvisited.delete(current_node)
      break if unvisited.length == 0

      current_node = unvisited.min_by { |k,v| v }[0]
    end

    path = extract_path(predecessors)
  end

  private
  def extract_path(predecessors)
    current_node = @destination

    path = [current_node]

    until current_node == @origin
      path << predecessors[current_node]
      current_node = predecessors[current_node]
    end

    path.reverse
  end

end
