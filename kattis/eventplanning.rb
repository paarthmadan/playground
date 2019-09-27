# frozen_string_literal: true

line_one = gets.strip.split(' ').map(&:to_i)
participants = line_one[0]
budget = line_one[1]
hotels = line_one[2]
weeks = line_one[3]

answer = nil

hotels.times do
  price = gets.strip.to_i
  availability = gets.strip.split(' ').map(&:to_i)
  cost = price * participants
  index = availability.find_index { |w| w >= participants }
  next if cost > budget || index.nil? || index > weeks

  answer = [(answer || cost), cost].min
end

if answer.nil?
  puts 'stay home'
else
  puts answer
end
