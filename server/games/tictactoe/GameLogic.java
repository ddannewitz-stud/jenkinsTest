package de.omi.pfw.gruppe5.server.games.tictactoe;

/**
 * Holds game logic.
 *
 * @author Daniel Dannewitz
 * @version 12 Dec 2015
 */
class GameLogic implements IGameLogic {

    /**
     * Game field.
     *
     * Possible values:
     * 0 = free
     * 1 = X
     * 2 = 0
     */
    int[][] field;

    /**
     * Player turn.
     */
    int turn;

    /**
     * Winner value.
     *
     * Possible values:
     * 0 = no winner
     * 1 = Player 1 wins
     * 2 = Player 2 wins
     */
    int winner;

    public GameLogic() {
        field = new int[3][3];
        turn = 1;
        winner = 0;
        initialize();
    }

    /**
     * Makes a move.
     *
     * @param row row of field.
     * @param col column of field.
     * @return true if move was valid, false otherwise.
     */
    @Override
    public boolean makeMove(int row, int col) {
        boolean valid = validateMove(row, col);
        if(valid) {
            field[row][col] = turn;
        }
        return valid;
    }

    /**
     * Returns which players turn it is.
     * 1 = Player 1
     * 2 = Player 2
     *
     * @return Player number.
     */
    @Override
    public int getPlayerTurn() {
        return turn;
    }

    /**
     * Switches turn.
     * Shouldn't be called before winner check.
     */
    @Override
    public void switchTurn() {
        turn = turn == 1 ? 2 : 1;
    }

    /**
     * Checks if win condition occurred.
     *
     * @return true if win condition occurred, false otherwise.
     */
    @Override
    public boolean checkWin() {
        boolean rows = checkRows();
        if(rows) {
            setWinner();
            return rows;
        }

        boolean cols = checkCols();
        if(cols) {
            setWinner();
            return cols;
        }

        boolean diags = checkDiags();
        if(diags) {
            setWinner();
            return diags;
        }

        return false;
    }

    /**
     * Returns winner, if there is one.
     * 0 = N/A -- checkWin() = false
     * 1 = Player 1
     * 2 = Player 2
     *
     * @return Player number of winner or 0 if there is no winner yet.
     */
    @Override
    public int getWinner() {
        return winner;
    }

    /**
     * Validates a move.
     *
     * @param row row of field.
     * @param col column of field.
     *
     * @return true if move is valid, false otherwise.
     */
    private boolean validateMove(int row, int col) {
        if (row < field.length && col < field[0].length) {
            return field[row][col] == 0;
        }
        return false;
    }

    /**
     * Initializes field array.
     */
    private void initialize() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
    }

    /**
     * Sets winner.
     */
    private void setWinner() {
        winner = turn;
    }

    /**
     * Checks rows on win condition occurrence.
     *
     * @return true if win conditions occurred, false otherwise.
     */
    private boolean checkRows() {
        boolean row1 = field[0][0] == field[0][1] && field[0][1] == field[0][2] && (field[0][0] == 1 || field[0][0] == 2);
        boolean row2 = field[1][0] == field[1][1] && field[1][1] == field[1][2] && (field[1][0] == 1 || field[1][0] == 2);
        boolean row3 = field[2][0] == field[2][1] && field[2][1] == field[2][2] && (field[2][0] == 1 || field[2][0] == 2);

        return row1 || row2 || row3;
    }

    /**
     * Checks columns on win condition occurrence.
     *
     * @return true if win conditions occurred, false otherwise.
     */
    private boolean checkCols() {
        boolean col1 = field[0][0] == field[1][0] && field[1][0] == field[2][0] && (field[0][0] == 1 || field[0][0] == 2);
        boolean col2 = field[0][1] == field[1][1] && field[1][1] == field[2][1] && (field[0][1] == 1 || field[0][1] == 2);
        boolean col3 = field[0][2] == field[1][2] && field[1][2] == field[2][2] && (field[0][2] == 1 || field[0][2] == 2);

        return col1 || col2 || col3;
    }

    /**
     * Checks diagonals on win condition occurrence.
     *
     * @return true if win conditions occurred, false otherwise.
     */
    private boolean checkDiags() {
        boolean diag1 = field[0][0] == field[1][1] && field[1][1] == field[2][2] && (field[0][0] == 1 || field[0][0] == 2);
        boolean diag2 = field[2][0] == field[1][1] && field[1][1] == field[0][2] && (field[0][0] == 1 || field[0][0] == 2);

        return diag1 || diag2;
    }
}
