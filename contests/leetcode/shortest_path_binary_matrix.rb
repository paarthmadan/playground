require_relative "input"
require "set"

def shortest_path_binary_matrix(grid)
    queue = Queue.new
    queue << [[0, 0], 1]
    step = 0
    
    visited = Set.new
    
    return -1 if grid[0][0] == 1

    visited << 0
    
    until queue.empty?
        node, step = queue.pop
        
        if node == [grid.length - 1, grid.length - 1]
            return step
        end

        p node
        puts visited.count

        positions(grid, node).each do |pos|
          if !visited.include?(encode(grid.length, pos)) && grid[pos[0]][pos[1]] == 0
                visited << encode(grid.length, pos)
                queue.push([pos, step + 1])
          end
        end
    end
    
    -1
end

def positions(grid, curr_pos)
    row, col = curr_pos
    
    up = [row - 1, col]
    down = [row + 1, col]
    
    left = [row, col - 1]
    right = [row, col + 1]
    
    down_right = [row + 1, col + 1]
    down_left = [row + 1, col - 1]
    
    up_right = [row - 1, col + 1]
    up_left = [row - 1, col - 1]
    
    opts = []
    
    if row > 0 && col > 0
        opts << up_left
    end
    
    if row > 0 && col < grid.length - 1
        opts << up_right
    end
    
    if row < grid.length - 1 && col > 0
        opts << down_left
    end
    
    if row < grid.length - 1 && col < grid.length - 1
        opts << down_right
    end
        
    opts << left if col > 0
    opts << right if col < grid.length - 1
    opts << up if row > 0
    opts << down if row < grid.length - 1
    
    opts
end

def encode(n, pos)
  n * pos[0] + pos[1]
end

puts shortest_path_binary_matrix(SampleInput::MATRIX)
