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

class Node
  attr_reader :type

  def initialize(type)
    @type = type
  end
end

class Edge
  def initialize(from, to, cost)
    @from = from
    @to = to
    @cost = cost
  end
end

class Map
  attr_reader :length, :width
  attr_accessor :layout

  def initialize(length, width)
    @length = length
    @width = width
    @layout = {}
  end

  # Recursive Traversal Evaluation (used to determine where conveyors end)
  def determine_end(x, y)
    symbol = @layout[[x,y]].type
    case symbol
    when "."
      return [x,y]
    when "D"
      determine_end(x, y + 1)
    when "U"
      determine_end(x, y - 1)
    when "L"
      determine_end(x - 1, y)
    when "R"
      determine_end(x + 1, y)
    else
      return -1
    end
  end

end

# Create map with user input
map = Map.new(*gets.split(' ').map(&:to_i))

# Populate map layout with user data
map.length.times do |y|
  nodes = gets.split('').map { |symbol| Node.new(symbol) }
  nodes.each_with_index { |n, x| map.layout[[x,y]] = n }
end

1.upto(map.length - 2) do |y|
  1.upto(map.width - 2) do |x|
    print map.determine_end(x, y)
  end
  puts
end
