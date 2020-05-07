def diff_char(i, c, s)
  i += 1 until s[i] != c || i == s.length
  return i
end

gets.to_i.times do
  encoded = ''
  seq = gets.split('')
  curr = 0
  until curr >= seq.length - 1 do
    diff = diff_char(curr, seq[curr], seq)
    encoded << "#{diff - curr} #{seq[curr]} "
    curr = diff
  end
  puts encoded.strip
end
