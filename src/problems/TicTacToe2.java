package problems;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class TicTacToe2 {
    private static final Scanner SCANNER = new Scanner(System.in);
    int[][] board;
    int[] input;
    int size = 3;
    private static final String PLAYERS[] = {"Player1", "Player2"};

    TicTacToe2(Optional<Integer> size) {
        this.size = size.isPresent() ? size.get() : 3;
        board = new int[this.size][this.size];
        Arrays.fill(board, -3);
    }

    public void startGame(){
        int moveCount = 0;
        boolean isGameOver = false;
        int turn = 0;
        while (!isGameOver && moveCount<9){
            System.out.println(PLAYERS[turn] + ", Please enter the position in which you want to mark");
            isGameOver = markUserInput(turn);
        }
    }

    private boolean markUserInput(int turn){
        input = getUserInput();
        if (isValidMove()){
            board[input[0]][input[1]] = turn;
        }
        else {
            System.out.println("Invalid Move!");
        }
        return isGameOver(turn);
    }

    private boolean isGameOver(int turn){
        return isHorizontalWin(turn) || isVerticalWin(turn) || isDiagonalWin(turn) || isCrossDiagonalWin(turn);
    }

    private boolean isHorizontalWin(int turn){
        for (int entry : board[input[0]]){
            if (entry != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isVerticalWin(int turn){
        for (int i=0; i<size; i++){
            if (board[input[0]][i] != turn){
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(int turn){
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

    private boolean isCrossDiagonalWin(int turn){
        for (int i=0, j=size; i<size; i++, j--){
            if (board[input[i]][j] != turn){
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
}
