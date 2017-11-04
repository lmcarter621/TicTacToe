package com.company;

/**
 * Created by LDot on 10/7/17.
 */
public class Board {
    private char[] positions;
    private int ceiling;
    private int row_size;

    public Board(){
        this(3);
    }

    public Board(int rows){
        this.row_size = rows;
        this.ceiling = rows * rows;
        this.positions = new char[ceiling];
    }

    public boolean addToBoard(char elem, int position){
        if(!isValidPosition(position) || isPositionTaken(position)){
            return false;
        }

        this.positions[position] = elem;
        return true;
    }

    private boolean isValidPosition(int position){
        if(position < 0 || position > this.ceiling - 1){
            System.out.println("Sorry but positions can only be numbers 1-9");
            return false;
        }

        return true;
    }

    private boolean isPositionTaken(int position){
        if(this.positions[position] != 0){
            System.out.println("Sorry that position is already taken.");
            return true;
        }

        return false;
    }

    public boolean isWinner(char player, int position){
        if(this.isHorizontalWin(position, player) ||
                this.isVerticalWin(position, player) || this.fwdDiagonalWin(player) || this.bcwdDiagonalWin(player)){
            return true;
        }

        return false;
    }

    private boolean isWin(int max, int min, int increment, char player){
        if(firstPositionCheck(min, player)){
            return false;
        }

        for(int i = min + increment; i < max; i += increment){
            if(linearPositionCheck(min, i)) {
                return false;
            }
            min = i;
        }
        return true;
    }

    private boolean isHorizontalWin(int position, char player){
        int col_indicator = position/row_size;

        return isWin(this.row_size*(col_indicator + 1), col_indicator * this.row_size, 1, player);
    }

    private boolean isVerticalWin(int position, char player){
        int row_indicator = position % row_size;

        return isWin(this.ceiling, row_indicator, this.row_size, player);
    }

    private boolean fwdDiagonalWin(char player){
        return isWin(this.ceiling, 0, this.row_size + 1, player);
    }

    private boolean bcwdDiagonalWin(char player){
        int start = this.ceiling - row_size;

        return isWin(0, start,(row_size - 1) * -1, player);
    }

    private boolean firstPositionCheck(int prev, char player){
        return this.positions[prev] == 0 || this.positions[prev] != player;
    }

    private boolean linearPositionCheck(int prev, int current){
        return this.positions[current] == 0 || this.positions[prev] != this.positions[current];
    }

    public boolean isBoardFull(){
        for(char position : this.positions) {
            if (position == 0) {
                return false;
            }
        }
        System.out.println("It's a tie!");
        return true;
    }

    public void print_board(){
        StringBuilder pretty_board = new StringBuilder();
        for (int i=0; i< this.positions.length; i++){
            if(this.positions[i] == 0) {
                pretty_board.append(" ");
            }else{
                pretty_board.append(this.positions[i]);
            }

            if(i%row_size == row_size - 1){
                pretty_board.append('\n');
            }else{
                pretty_board.append("|");
            }
        }

        System.out.print(pretty_board.toString());
    }
}
