# + 2 - 2 1
# + 2 (2 - 1)
# (2 + (2 - 1))


def pre_to_regular(pre):
    characters = list(reversed(pre.split(" ")))
    current_del = 0

    size = len(characters)

    for i in range(len(characters)):
        symbol = characters[i - current_del]
        if symbol == '+' or symbol == '-':
            numbers = []
            for j in range(len(list(reversed(characters[:i])))):
                number = list(reversed(characters[:i]))[j]
                if number != '+' and number != '-' and len(numbers) < 2:
                    numbers.append([number, j])

            characters[i - 1 - current_del] = "(" + numbers[0][0] + " " + symbol + " " + numbers[1][0] + ")"

            for n in numbers:
                del characters[n[1] - current_del]
                current_del += 1
        print characters
    return

while True:
    expression = raw_input()
    if expression != '0':
        print(pre_to_regular(expression))
    else:
        break
