def move_diagonally(cols, rows, home_location, mall_location):
    x, y = home_location
    end_x, end_y = mall_location

    grid = [[set() for _ in range(cols)] for _ in range(rows)]
    dx, dy = 1, 1
    direction_mapping = {
        (1, 1): 0,
        (-1, 1): 1, 
        (1, -1): 2,
        (-1, -1): 3
    }
    
    count = 0
    while True:
        grid[x][y].add(direction_mapping[(dx, dy)])
        
        print("Adding new dir ",grid[x][y])
        if x == end_x and y == end_y:
            return count
        # print("old:", x, y)
        # print("delta:", dx, dy)
        new_x, new_y = x + dx, y + dy
        # print("updated:", new_x, new_y)
        count += 1
        if (new_x > rows - 1 or new_x < 0) and (new_y > cols - 1 or new_y < 0):
            # print("-- corner")
            dx *= -1
            dy *= -1
        elif new_x > rows - 1 or new_x < 0:
            # print("--x breach")
            dx *= -1
        elif new_y > cols - 1 or new_y < 0:
            # print("--y breach")
            dy *= -1
        else:
            x, y = new_x, new_y
        if direction_mapping[(dx, dy)] in grid[x][y]:
            return -1



# test_inputs = []
# test_inputs.append((5, 5, 2, 1, 1, 2))
# test_inputs.append((5, 3, (2, 0), (3, 2)))

print(move_diagonally(5, 5, (2, 1), (1, 2)))
print(move_diagonally(5, 3, (2, 0), (3, 2)))
print(move_diagonally(5, 2, (0, 0), (0, 1)))
print(move_diagonally(5, 2, (0, 0), (0, 4)))
print(move_diagonally(5, 2, (1, 0), (1, 4)))
#print(move_diagonally(2, 5, (0, 0), (4, 1)))
#print(move_diagonally(2, 5, (0, 0), (4, 0)))

