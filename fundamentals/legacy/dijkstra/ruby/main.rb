require_relative 'node'
require_relative 'edge'
require_relative 'graph'
require_relative 'dijkstra'

a = Node.new("A")
b = Node.new("B")
c = Node.new("C")
d = Node.new("D")
e = Node.new("E")
f = Node.new("F")

nodes = [a, b, c, d, e, f]

edges = [
  Edge.new(a, b, 7),
  Edge.new(a, c, 9),
  Edge.new(a, f, 14),
  Edge.new(b, c, 10),
  Edge.new(b, d, 15),
  Edge.new(c, f, 2),
  Edge.new(c, d, 11),
  Edge.new(f, e, 9),
  Edge.new(d, e, 6),
]

edges.each { |edge| edge.from.add_edge(edge) }

g = Graph.new(nodes, edges)

dijkstra = Dijkstra.new(g, a, e)
path = dijkstra.compute_shortest_path

path.each { |p| print "#{p} "}
puts

