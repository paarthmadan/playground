def get_cycle(o)
  o.cycle.each_slice(2).take(2)
end

count = Hash.new(0).tap { |h| gets.chomp.each_char { |c| h[c] += 1 } }
output = [*1..4]

output = get_cycle(output).rotate.flatten if count['H'] % 2 == 1
output = get_cycle(output).map { |s| s.reverse }.flatten if count['V'] % 2 == 1

output.each_slice(2) { |s| puts s.join(' ') }
