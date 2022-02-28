public class Sudoku implements ISudoku
{
    //INSTANCE VARIABLES
    SudokuPiece player;
    SudokuPiece[][] board;
    //CONSTRUCTORS
    public TicTacToe() 
    {
        //Initialize instance variables here
        player = TicTacToePiece.X;
        board = new TicTacToePiece[3][3];
    }
    
    //METHODS
    /*
     *  Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return player;
    }
    
    /*
     *  Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        if(player.equals(TicTacToePiece.O)) {
            player = TicTacToePiece.X;
        }
        else {
            player = TicTacToePiece.O;
        }
    }
    
    /*
     *  Add the specified piece to the board at the specified row,col and return true
     *  If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = player;
        return true;
    }
    
    /*
     *  Return the piece that is located at the specified row, col
     *  If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        if(board[row][col] != null) {
            return board[row][col];
        }
        return null;
    }
    
    /*
     *  Return true if there is at least 1 empty space left on the board
     *  Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*  Return null if there is no winner
     *  Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *  Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
        TicTacToePiece win = checkRowsForWinner();
        TicTacToePiece winn = checkColsForWinner();
        TicTacToePiece winne = checkDiagsForWinner();
        
        if(win != null) {
            return win;
        }
        if(winn != null) {
            return winn;
        }
        if(winne != null) {
            return winne;
        }
        
        return null;
    }
    
    /*
     *  Return true if there is a winner or if there are no empty spaces left on the board
     *  Otherwise, return false
     */
    public boolean isGameOver()
    {
        if(hasEmptySpace() == false || getWinner() != null) {
            return true;
        }
        return false;
    }
    
    //HELPER METHODS
    /*
     *  If a, b, and c are all the same TicTacToe piece, then return that piece
     *  Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        if (a == b && b==c) {
            return a;
        }
        
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *  Return the first non-null winner that is found (starting from row 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        for (int i = 0; i < 3; i++) {
            if(checkForWinner(board[i][0], board[i][1], board[i][2]) != null) {
                return board[i][0];
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *  Return the first non-null winner that is found (starting from column 0)
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        for (int i = 0; i < 3; i++) {
            if(checkForWinner(board[0][i], board[1][i], board[2][i]) != null) {
                return board[0][i];
            }
        }
        return null;
    }
    
    /*
     *  Use the checkForWinner() helper method to check both of the diagonals for a winner
     *  Check the top left -> bottom right diagonal first
     *  Check the top right -> bottom left diagonal second
     *  Return the first non-null winner that is found
     *  If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
    	TicTacToePiece x = board[0][0];
    	TicTacToePiece y = board[1][1];
    	TicTacToePiece z = board[2][2];
    	
    	if(checkForWinner(x, y, z) != null) {
    	    return x;
    	   }
    	   
    	else {
    	    x = board[0][2];
    	    y = board[1][1];
    	    z = board[2][0];
    	    
    	    if(checkForWinner(x,y,z) != null) {
    	        return x;
    	       }
    	   }
    	   
    	return null;
    }
    
    
}
