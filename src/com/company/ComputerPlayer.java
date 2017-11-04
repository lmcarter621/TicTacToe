package com.company;

import java.util.Random;
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
        Random rand = new Random();

        return rand.nextInt(9) ;
    }
}
