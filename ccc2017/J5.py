n = int(input())
wood = [int(i) for i in raw_input().split()]

combinations = []
total = []
total_count = [0] * 4001

iterator = range(len(wood)).__iter__()

for i in iterator:
    temp_combinations = []
    for j in range(i + 1, len(wood)):
        if (len(temp_combinations) + 2) % 4 != 0 and [wood[i], wood[j]] not in temp_combinations:
                combinations.append([wood[i], wood[j]])
                if len(temp_combinations) > 0:
                    if temp_combinations[len(temp_combinations) - 1] == [wood[i], wood[j]]:
                        temp_combinations.append([wood[i], wood[j]])
                else:
                    temp_combinations.append([wood[i], wood[j]])
                total.append(wood[i] + wood[j])
                total_count[wood[i] + wood[j] - 1] += 1
        else:
            for q in range(1):
                iterator.next()
            break


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

