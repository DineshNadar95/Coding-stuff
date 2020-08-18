from collections import deque
def restore_array(pairs):
    queue = deque([])
    queue.append(pairs[0][0])
    queue.append(pairs[0][1])

    record = [True] * len(pairs)
    remaining = len(pairs) - 1

    while remaining > 0:
        for i in range(1, len(pairs)):
            if record[i]:
                first = queue[0]
                last = queue[-1]

                if first == pairs[i][0]:
                    queue.appendleft(pairs[i][1])
                    record[i] = False
                    remaining -= 1
                elif first == pairs[i][1]:
                    queue.appendleft(pairs[i][0])
                    record[i] = False
                    remaining -= 1
                elif last == pairs[i][0]:
                    queue.append(pairs[i][1])
                    record[i] = False
                    remaining -= 1
                elif last == pairs[i][1]:
                    queue.append(pairs[i][0])
                    record[i] = False
                    remaining -= 1

    return list(queue)



test_inputs = []
test_inputs.append([[3, 5], [1, 4], [2, 4], [1, 5]])
test_inputs.append([[1, 2], [2, 3], [3, 4], [4, 5]])
test_inputs.append([[1, 2]])
test_inputs.append([[5, 6], [5, 7]])

for test in test_inputs:
    print(restore_array(test))