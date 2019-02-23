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

class Map
  attr_reader :length, :width
  attr_accessor :layout

  def initialize(length, width)
    @length = length
    @width = width
    @layout = {}
  end
end

# Create map with user input
map = Map.new(*gets.split(' ').map(&:to_i))

# Populate map layout with user data
map.length.times do |y|
  nodes = gets.split('').map { |symbol| Node.new(symbol) }
  nodes.each_with_index { |n, x| map.layout[[x,y]] = n }
end

puts map.layout
