# frozen_string_literal: true

class Point
  attr_reader :x, :y

  def initialize(x, y)
    @x = x
    @y = y
    @spoilt = false
  end

  def spoilt?
    @spoilt
  end

  def spoilt=(value)
    @spoilt = value
  end

  def distance_to(point)
    Math.sqrt((point.x - x)**2 + (point.y - y)**2)
  end
end

loop do
  input = gets.strip.split(' ')
  min_distance = input[0].to_f
  hives_count = input[1].to_i

  break if min_distance == 0.0 && hives_count.zero?

  hives = []

  hives_count.times do
    hives << last = Point.new(*gets.strip.split(' ').map(&:to_f))
    hives.each do |h|
      next if h == last
      next if h.spoilt?

      next unless h.distance_to(last) < min_distance

      h.spoilt = true
      last.spoilt = true
    end
  end
  spoilt_count = hives.count(&:spoilt?)
  puts "#{spoilt_count} sour, #{hives.size - spoilt_count} sweet"
end
