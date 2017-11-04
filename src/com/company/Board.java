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

    private boolean isHorizontalWin(int position, char player){
        int col_indicator = position/row_size;

        int prev = col_indicator * this.row_size;
        if(preliminaryCheck(prev, player)){
            return false;
        }

        for(int i = col_indicator * this.row_size + 1; i < this.row_size*(col_indicator + 1);  i++){
            if(linearPositionCheck(prev, i)) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    private boolean isVerticalWin(int position, char player){
        int row_indicator = position % row_size;

        int prev = row_indicator;
        if(preliminaryCheck(prev, player)){
            return false;
        }
        for(int i = row_indicator + this.row_size; i < this.ceiling; i+= this.row_size){
            if(linearPositionCheck(prev, i)) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    private boolean fwdDiagonalWin(char player){
        int prev = 0;
        if(preliminaryCheck(prev, player)){
            return false;
        }
        for(int i = this.row_size + 1; i < this.ceiling; i = i + this.row_size + 1){
            if(linearPositionCheck(prev, i)) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    private boolean bcwdDiagonalWin(char player){
        int prev = this.ceiling - row_size;
        if(preliminaryCheck(prev, player)){
            return false;
        }
        for(int i=this.ceiling - (row_size*2) + 1; i > 0; i = i - row_size + 1){
            if(linearPositionCheck(prev, i)) {
                return false;
            }
            prev = i;
        }
        return true;
    }

    private boolean preliminaryCheck(int prev, char player){
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
