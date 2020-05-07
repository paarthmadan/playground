# Pseudo
# 1. Create Node representing each cell
# 2. Store possible routes from each cell, as edge, on each cell
# 3. Store all nodes, with reference to their coordinate
# 4. Use Dijkstra's to determine shortest path to each cell
# 5. Output data, based on coordinate
# 
# Notes: 
# All edges will have a cost of 1, so a conveyor belt can link two nodes
# regardless of distance between them, and it'll be treated as 1 move 
#
# A preliminary screening will be run, to determine which nodes are affected
# from the camera, and effectively remove these edges.
#
# New considerations:
# Dijkstra's isn't the best implementation.
# Because the cost of each edge is 1, a BFS is likely faster
# Currently, the implementation gets the correct answer, but TLE's (5.6 > 1)
# Also: Ruby's slow asf


class Node
  attr_reader :type, :edges
  attr_accessor :label

  def initialize(type)
    @type = type
    @edges = []
  end

  def to_s
    "#{@label}, #{@type}"
  end

  def add_edge(edge)
    @edges << edge if edge.from == self
  end
end

class Edge
  attr_reader :from, :to, :cost
  def initialize(from, to, cost)
    @from = from
    @to = to
    @cost = cost
  end

  def to_s
    "#{@from} ⟶  #{@to}"
  end
end

class Map
  attr_reader :length, :width
  attr_accessor :layout, :edges

  def initialize(length, width)
    @length = length
    @width = width
    @layout = {}
    @edges = []
  end

  # Recursive Traversal Evaluation (used to determine where conveyors end)
  def determine_end(x, y)
    symbol = @layout[[x,y]].type
    case symbol
    when '.'
      return [x,y]
    when 'D'
      determine_end(x, y + 1)
    when 'U'
      determine_end(x, y - 1)
    when 'L'
      determine_end(x - 1, y)
    when 'R'
      determine_end(x + 1, y)
    else
      return -1
    end
  end

end

MOVES = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
]

start_time = Time.now

# Create map with user input
map = Map.new(*gets.split(' ').map(&:to_i))

# Populate map layout with user data
map.length.times do |y|
  gets.chomp.split('').each_with_index { |symbol, x| map.layout[[x,y]] = Node.new(symbol) }
end

b1_time = Time.now

origin = nil

# Create edges
1.upto(map.length - 2) do |y|
  1.upto(map.width - 2) do |x|
    move_start = [x,y]
    start_node = map.layout[move_start]
    origin = start_node if start_node.type == 'S'
    if start_node.type == '.' || start_node.type == 'S'
      MOVES.each do |move|
        move_pos = [x + move[0], y + move[1]]
        move_end = map.determine_end(*move_pos)
        unless move_end == -1 || move_end == move_start
          edge = Edge.new(start_node, map.layout[move_end], 1)
          map.edges << edge
          start_node.add_edge(edge)
          # puts "#{[x,y]}, #{move_end}"
        end
      end
    end
  end
end

b2_time = Time.now

# Dijkstra's
unvisited = {}
predecessors = {}

map.layout.each do |_, node|
  unvisited[node] = (node == origin) ? 0 : Float::MAX.to_i if %w(. S).include?(node.type)
end

current_node = origin

until unvisited.length == 0
  current_node.edges.each do |outgoing_edge|
    if unvisited[outgoing_edge.to]
      if unvisited[current_node] + outgoing_edge.cost < unvisited[outgoing_edge.to]
        predecessors[outgoing_edge.to] = current_node
        unvisited[outgoing_edge.to] = unvisited[current_node] + outgoing_edge.cost
      end
    end
  end

  unvisited.delete(current_node)
  break if unvisited.length == 0

  current_node = unvisited.min_by { |k,v| v }[0]
end

b3_time = Time.now

def trace(ending_node, starting_node, p)
  if ending_node == starting_node
    return 0
  elsif p[ending_node] == nil
    return -1
  else
    return 1 + trace(p[ending_node], starting_node, p)
  end
end 

map.layout.each do |_, node|
  puts trace(node, origin, predecessors) if node.type == "."
end

b4_time = Time.now

puts b1_time - start_time
puts b2_time - b1_time
puts b3_time - b2_time
puts b4_time - b3_time
