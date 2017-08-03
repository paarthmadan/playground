from itertools import product

n = int(input())
wood = [int(i) for i in raw_input().split()]

combinations = []
total = []
total_count = [0] * 4000

for i in range(len(wood)):
    for j in range(i + 1, len(wood)):
        combinations.append([wood[i], wood[j]])
        total.append(wood[i] + wood[j])
        total_count[wood[i] + wood[j] - 1] += 1

max_value = 0
max_index = -1

max_indexes = []

is_tie = False

for i in range(len(total_count)):
    if total_count[i] > max_value:
        max_value = total_count[i]
        max_index = i
        max_indexes = list()
        max_indexes.append(max_index)
    elif total_count[i] == max_value:
        max_indexes.append(i)

print str(max_value) + " " + str(len(max_indexes))


