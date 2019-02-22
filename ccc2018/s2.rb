def rotate(a)
  b = []
  a.length.times do |i|
    c = []
    a[i].length.times do |j|
      c << a[j][i]
    end
    b << c.reverse
  end
  b
end

def verify(data)
  data.length.times do |i|
    data[i].length.times do |j|
      return false if i < data.length - 1 && data[i][j] > data[i+1][j]
      return false if j < data.length - 1 && data[i][j] > data[i][j+1]
    end
  end
  true
end

f = []
gets.to_i.times { f << gets.split(" ").map(&:to_i) }

until verify(f)
  f = rotate(f)
end

f.each do |row|
  output = ""
  row.each { |value| output << "#{value} " }
  puts output.strip
end
