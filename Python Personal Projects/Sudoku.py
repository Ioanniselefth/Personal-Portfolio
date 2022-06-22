def FindNextEmpty(Scheme):
    #find the next row,col on the Scheme that is empty
    #Return Row, Col tuple 
    for i in range(9):
        for j in range(9):
            if Scheme[i][j] == -1:
                return i,j
    
    return None,None #If no spaces are empty

def IsValid(Scheme, guess, row, col):
    #Figure out if the guess at the row/col is correct
    #Returns True if is valid, False otherwise

    RowValue = Scheme[row]
    if guess in RowValue :
        return False
    
    #Now the column
    ColValue = []
    for i in range(9):
        ColValue.append(Scheme[i][col])

    RowStart = (row//3)*3
    ColStart = (col//3)*3

    for j in range(RowStart, RowStart+3):
        for y in range(ColStart, ColStart+3):
            if Scheme[j][y] == guess:
                return False
    
    return True
    


def Solve(Scheme):
    #Solve Sudoku using backtracking!
    #our puzzle is a list of lists where each inner list is a row in our sudoku puzzle
    #Return if there is a solution
    #Mutates the scheme to be the solution

    #Step 1: Make the guess somewhere
    row,col = FindNextEmpty(Scheme)

    #Step 1.1: If there are none left then we are done because we only allow valid inputs
    if row is None:
        return True
    
    #Step 2: If there are is a place to put a number, then make a guess between 1 and 9
    for guess in range(1,10):
        #Step 3: Check if this is a valid guess
        if IsValid(Scheme, guess, row, col):
            #Step 3.1: If this is valid then place that guess on the puzzle
            Scheme[row][col]=guess
            #Recurse use this puzzle
            #Step 4: Recursively call our function  
            if Solve(Scheme):
                return True
        #Step 5: If not valid OR if our guess does not solve the puzzle then we need 
        # to backtrack and try a new number
        Scheme[row][col] = -1
    #Step 6: If none of the numbers that we try to work then this puzzle is unsolvable
    return False


example_board = [
    [3, 9, -1,   -1, 5, -1,   -1, -1, -1],
    [-1, -1, -1,   2, -1, -1,   -1, -1, 5],
    [-1, -1, -1,   7, 1, 9,   -1, 8, -1],

    [-1, 5, -1,   -1, 6, 8,   -1, -1, -1],
    [2, -1, 6,   -1, -1, 3,   -1, -1, -1],
    [-1, -1, -1,   -1, -1, -1,   -1, -1, 4],

    [5, -1, -1,   -1, -1, -1,   -1, -1, -1],
    [6, 7, -1,   1, -1, 5,   -1, 4, -1],
    [1, -1, 9,   -1, -1, -1,   2, -1, -1]
]

print(Solve(example_board))
print(example_board)
