import itertools

fav_team = int(input())
total_count = 0

scores = [0] * 4
queue = [
    [1, 2],
    [1, 3],
    [1, 4],
    [2, 3],
    [2, 4],
    [3, 4]
]

for game in range(int(input())):
    stat = [int(i) for i in raw_input().split()]

    if stat[2] > stat[3]:
        scores[stat[0] - 1] += 3
    elif stat[3] > stat[2]:
        scores[stat[1] - 1] += 3
    else:
        scores[stat[0] - 1] += 1
        scores[stat[1] - 1] += 1

    queue.remove([stat[0], stat[1]])

combinations = [["", "", ""]] * len(queue)

for game_left in queue:
        combinations[queue.index(game_left)] = [str(game_left[0]), str(game_left[1]), str(game_left[0]) + str(game_left[1])]

combinations_left = list(itertools.product(*combinations))
calc_scores = [[0] * 4] * len(combinations_left)

for i in range(len(combinations_left)):
    current_calc_score = list(calc_scores[i])
    current_stat = combinations_left[i]
    for game_status in current_stat:
        if len(game_status) < 2:
            current_calc_score[int(game_status) - 1] += 3
        elif len(game_status) > 1:
            tied_teams = [int(n) for n in str(game_status)]
            current_calc_score[tied_teams[0] - 1] += 1
            current_calc_score[tied_teams[1] - 1] += 1
    for x in range(len(scores)):
        current_calc_score[x] += scores[x]
    calc_scores[i] = current_calc_score


for final_comb in calc_scores:

    max_value = -1
    max_index = -1
    is_tie = False

    for i in range(len(final_comb)):
        if final_comb[i] > max_value:
            max_value = final_comb[i]
            max_index = i
            is_tie = False
        elif final_comb[i] == max_value:
            is_tie = True
    if is_tie is False and max_index == fav_team - 1:
        total_count += 1

print total_count





