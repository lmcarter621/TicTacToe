package com.company;

/**
 * Created by LDot on 10/7/17.
 */
public class Board {
    private char[] positions;

    public Board(){
        this.positions = new char[9];
    }

    public boolean addToBoard(char elem, int position){
        if(!isValidPosition(position) || isPositionTaken(position)){
            return false;
        }

        this.positions[position] = elem;
        return true;
    }

    private boolean isValidPosition(int position){
        if(position < 0 || position > 8){
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
        int row_indicator = position/3;

        if(row_indicator == 0) {
            return this.isAllEqual(0, 1, 2, player);
        }else if(row_indicator == 1){
            return this.isAllEqual(3, 4, 5, player);
        }else{
            return this.isAllEqual(6, 7, 8, player);
        }
    }

    private boolean isVerticalWin(int position, char player){
        int col_indicator = position % 3;

        if(col_indicator == 0){
            return this.isAllEqual(0, 3, 6, player);
        }else if(col_indicator == 1 ){
            return this.isAllEqual(1, 4, 7, player);
        }else{
            return this.isAllEqual(2, 5, 8, player);
        }
    }

    private boolean fwdDiagonalWin(char player){
        return this.isAllEqual(0, 4, 8, player);
    }

    private boolean bcwdDiagonalWin(char player){
        return this.isAllEqual(2, 4, 6, player);
    }

    private boolean isAllEqual(int first, int second, int third, char player){
        if(this.positions[first] == 0 || this.positions[second] == 0 || this.positions[third] == 0){
            return false;
        }

        if(this.positions[first] == this.positions[second] && this.positions[second] == this.positions[third] &&
                this.positions[first] == player){
            return true;
        }

        return false;
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

            if(i%3 == 2){
                pretty_board.append('\n');
            }else{
                pretty_board.append("|");
            }
        }

        System.out.print(pretty_board.toString());
    }
}
