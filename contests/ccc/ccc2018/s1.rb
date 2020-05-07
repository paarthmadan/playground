v = gets.to_i.times.map { |_| gets.to_i }.sort!
min = Float::MAX
(1...v.length - 1).each { |i| min = [min, ((v[i+1] + v[i])/2) - ((v[i] + v[i-1]) / 2)].min }

puts format("%.1f", min)
