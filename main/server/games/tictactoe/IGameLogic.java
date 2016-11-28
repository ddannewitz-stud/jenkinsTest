package server.games.tictactoe;

/**
 * Game logic interface.
 * @author Daniel Dannewitz
 * @version 11 Dec 2015
 */
interface IGameLogic {

    /**
     * Makes a move.
     *
     * @param row row of field.
     * @param col column of field.
     *
     * @return true if move was valid, false otherwise.
     */
    boolean makeMove(int row, int col);

    /**
     * Returns which players turn it is.
     * 1 = Player 1
     * 2 = Player 2
     *
     * @return Player number.
     */
    int getPlayerTurn();

    /**
     * Switches turn.
     */
    void switchTurn();

    /**
     * Checks if win condition occurred.
     *
     * @return true if win condition occurred, false otherwise.
     */
    boolean checkWin();

    /**
     * Returns winner, if there is one.
     * 0 = N/A -- checkWin() = false
     * 1 = Player 1
     * 2 = Player 2
     *
     * @return Player number of winner or 0 if there is no winner yet.
     */
    int getWinner();
}
