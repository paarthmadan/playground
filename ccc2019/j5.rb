@substitution = 3.times.map { gets.split(' ') }.to_h
input = gets.split(' ')
@steps = input[0].to_i
start_seq = input[1]
@end_seq = input[2]

def valid_subs(string)
  @substitution.keys.select { |key| string.include?(key) }
end

p valid_subs(start_seq)

def apply_sub(step_count, seq)
  return -1 if step_count > 7
  return 1 if seq == @end_seq && step_count == @steps  
  valid_subs(seq).each do |sub|
    # Call each sub
  end
end

apply_sub(1, start_seq)

