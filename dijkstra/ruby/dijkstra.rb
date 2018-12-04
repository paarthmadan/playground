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
      unvisited.sort_by { |k,v| v }
      current_node = unvisited.keys[0]
    end

    predecessors.each { |to, from| puts "#{to} --> #{from}" }

  end

end
