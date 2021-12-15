package problems;

//improvement - if both players have made entry in a row,no need to check a third time
//improvement - undo functionality
//improvement - Web game, with APIs

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    int[][] board;
    String[] players;
    int boardSize;
    int maxMoves;
    int moves = 0;
    int currentPlayer;

    public static final int UNOCCUPIED = 3;

    Scanner sc= new Scanner(System.in);

    public TicTacToe(int boardSize, String player1, String player2){
        board = new int[boardSize][boardSize];
        players = new String[]{player1, player2};
        this.boardSize = boardSize;
        for (int i=0; i<boardSize; i++){
            Arrays.fill(board[i], UNOCCUPIED);
        }
        maxMoves = boardSize*boardSize;
    }

    private boolean makeMove(int playerNumber){
        System.out.println(players[playerNumber] + " make your move");
        int[] cell = getPlayerInput();
        int row = cell[0];
        int column = cell[1];

        if (row >= boardSize || column >= boardSize || (board[cell[0]][cell[1]] !=  UNOCCUPIED)){
            System.out.println("Illegal move. Retry");
            togglePlayer();
            return false;
        }
        board[cell[0]][cell[1]] = playerNumber;

        if (isColumFilled(column, playerNumber) || isRowFilled(row, playerNumber) ||
                isDiagonalFilled(row, column, playerNumber) || isReverseDiagonalFilled(row, column, playerNumber)){
            System.out.println(players[playerNumber] + " wins");
            return true;
        }

        if (++moves == maxMoves){
            System.out.println("DRAW!!");
            return true;
        }

        return false;
    }

    private int[] getPlayerInput(){
        String input = sc.nextLine();

        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private boolean isRowFilled(int row, int playerNumber){
        for (int i=0; i<boardSize; i++){
            if (board[row][i] != playerNumber){
                return false;
            }
        }
        return true;
    }

    private boolean isColumFilled(int row, int playerNumber){
        for (int i=0; i<boardSize; i++){
            if (board[i][row] != playerNumber){
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalFilled(int row, int column, int playerNumber){
        if (!isDiagonalCell(row, column)){
            return false;
        }
        for (int i=0; i<boardSize; i++){
            int cellContent = board[i][i];
            if (board[i][i] != playerNumber){
                return false;
            }
        }

        return true;
    }

    private boolean isDiagonalCell(int row, int column){
        return row == column;
    }

    private boolean isReverseDiagonalFilled(int row, int column, int playerNumber){
        if (!isReverseDiagonalCell(row, column)){
            return false;
        }

        int maxIndex = boardSize-1;
        for (int i=0, j=maxIndex; i<boardSize; i++, j--){
            if (board[i][j] != playerNumber){
                return false;
            }
        }

        return true;
    }

    private boolean isReverseDiagonalCell(int row, int column){
        return row + column == boardSize - 1;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3, "Johny", "Thomas");

        game.currentPlayer=0;
        while(!game.makeMove(game.currentPlayer)){
            game.togglePlayer();
        }
    }

    private void togglePlayer(){
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }
}
