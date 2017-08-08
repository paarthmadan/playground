word = raw_input()
coordinates = []

for letter in word:
    if letter == ' ':
        coordinates.append([2, 4])
    elif letter == '-':
        coordinates.append([3, 4])
    elif letter == '.':
        coordinates.append([4, 4])
    else:
        x = (ord(letter) - 65) % 6
        y = (ord(letter) - 65) / 6
        coordinates.append([x, y])

coordinates.append([5, 4])

total_length = 0
prev_pair = [0, 0]

for pair in coordinates:
    total_length += abs(pair[0] - prev_pair[0]) + abs(pair[1] - prev_pair[1])
    prev_pair = pair

print total_length
