import sys

playlist = ['A', 'B', 'C', 'D', 'E']


def one():
    first = playlist[0]
    temp = playlist[1:]
    return list(temp) + list(first)


def two():
    last = playlist[4]
    temp = playlist[:4]
    return list(last) + list(temp)


def three():
    playlist_change = playlist
    temp = playlist_change[0]
    playlist_change[0] = playlist_change[1]
    playlist_change[1] = temp
    return playlist_change

switch = {
    1: one,
    2: two,
    3: three
}

while True:
    sys.stdout.write("Button number: ")
    b = input()

    sys.stdout.write("Number of presses: ")
    n = input()

    if b == 4 and n == 1:
        break
    else:
        for i in range(n):
            playlist = switch[b]()

for letter in playlist:
    sys.stdout.write(str(letter) + ' ')
