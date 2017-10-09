package com.company;

/**
 * Created by LDot on 10/7/17.
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer(char piece, Board board) {
        super(piece, board);
    }

    @Override
    public void makeMove() {
        boolean res = false;
        Integer position;

        while(!res){
            position = calculate_position();
            res = this.board.addToBoard(this.piece, position);
            this.last_position_played = position;
        }

        System.out.println("Computer played: " + (this.last_position_played + 1));
    }

    private int calculate_position(){
        if(this.last_position_played == null){
            return 0;
        }

        if(this.last_position_played >= 8){
            return 1;
        }

        return this.last_position_played + 2;

    }
}
