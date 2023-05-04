package problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TicTacToe2 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private int[][] board;
    private int[] input;
    private final int size;
    private int turn;
    private static final String[] PLAYERS = {"Player1", "Player2"};
    private final int maxMoves;

    TicTacToe2() {
        this.size = 3;
        maxMoves = size*size;
        initBoard();
    }

    TicTacToe2(int size) {
        this.size = size;
        maxMoves = size*size;
        initBoard();
    }

    private void initBoard(){
        turn = 0;
        board = new int[this.size][this.size];
        for (int[] rows : board){
            Arrays.fill(rows, -3);
        }
    }

    public void startGame(){
        int moveCount = 0;
        int isGameOver = 0;
        while (isGameOver<=0 && moveCount<maxMoves){
            System.out.println(PLAYERS[turn] + ", Please enter the position in which you want to mark");
            isGameOver = markUserInput();
            if (isGameOver == 0){
                moveCount ++;
                switchPlayer();
            }
            else if (isGameOver == 1){
                System.out.println(PLAYERS[turn] + " WINS!!!");
            }
        }
        if (isGameOver == 0){
            System.out.println("It's a Draw!!!");
        }
    }

    private void switchPlayer(){
        turn = turn == 0 ? 1 : 0;
    }

    private int markUserInput(){
        input = getUserInput();
        if (isValidMove()){
            board[input[0]][input[1]] = turn;
        }
        else {
            System.out.println("Invalid Move!");
            return -1;
        }
        return isGameOver()? 1 : 0;
    }

    private boolean isGameOver(){
        return isHorizontalWin() || isVerticalWin() || isDiagonalWin() || isCrossDiagonalWin();
    }

    private boolean isHorizontalWin(){
        for (int entry : board[input[0]]){
            if (entry != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isVerticalWin(){
        for (int i=0; i<size; i++){
            if (board[i][input[1]] != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(){
        if(input[0]!=input[1]){
            return false;
        }

        for (int i=0; i<size; i++){
            if (board[i][i] != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isCrossDiagonalWin(){
        for (int i=0, j=size-1; i<size; i++, j--){
            if (board[i][j] != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isValidMove(){
        return isWithinBounds() && isCellUnoccupied();
    }

    private boolean isWithinBounds(){
        return input[0]>=0 && input[0] < size && input[1]>=0 && input[1] < size;
    }

    private boolean isCellUnoccupied(){
        return board[input[0]][input[1]] == -3;
    }

    private int[] getUserInput(){
        String input = SCANNER.nextLine();
        return Stream.of(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        TicTacToe2 ticTacToe = new TicTacToe2();
        ticTacToe.startGame();
    }
}
