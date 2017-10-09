package com.company;


/**
 * Created by LDot on 10/7/17.
 */
public abstract class Player {
    protected char piece;
    protected Board board;
    protected Integer last_position_played;

    public Player(char piece, Board board){
        this.piece = piece;
        this.board = board;
    }

    public abstract void makeMove();

    public boolean isWinner() {
        return board.isWinner(this.piece, this.last_position_played);
    }
}
