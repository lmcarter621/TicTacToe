package com.company;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe!");

        Board board = new Board();
        HumanPlayer human = new HumanPlayer('x', board);
        ComputerPlayer computer = new ComputerPlayer('o', board);
        int round = 0;

        do{
            if(round % 2 == 0){
                play_round(human, board);
            }else{
                play_round(computer, board);
            }
            round++;
        }while(!board.isBoardFull());
    }

    private static void play_round(Player player, Board board){
        player.makeMove();
        board.print_board();

        if(player.isWinner()) {
            System.out.print(player.getClass().getSimpleName() + " wins!");
            System.exit(0);
        }
    }
}
