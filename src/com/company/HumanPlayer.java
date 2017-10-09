package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by LDot on 10/7/17.
 */
public class HumanPlayer extends Player {
    private BufferedReader position_reader;

    public HumanPlayer(char piece, Board board) {
        super(piece, board);
        this.position_reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void makeMove() {
        boolean res = false;
        Integer actual_position;
        String user_entered_position;

        while(!res){
            System.out.print("Enter position: ");
            try{
                user_entered_position = this.position_reader.readLine();
                actual_position = Integer.parseInt(user_entered_position) - 1;
                res = this.board.addToBoard(this.piece, actual_position);
                this.last_position_played = actual_position;
            }catch (Exception e){
                System.out.println("There was a problem with your input.  Please try again.");
            }
        }


    }
}
