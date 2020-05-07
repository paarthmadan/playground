AB = 2.times.map { 3.times.inject(0) { |sum, i| sum + (3 - i) * (gets.to_i) } }
puts (AB[0] == AB[1]) ? 'T' : ((AB[0] > AB[1]) ? 'A' : 'B') 
