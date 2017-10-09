package com.company;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe!");

        Board board = new Board();
        HumanPlayer human = new HumanPlayer('x', board);
        ComputerPlayer computer = new ComputerPlayer('o', board);

        do{
            if(play_round(human, board)){
                break;
            }

            if(play_round(computer, board)){
                break;
            }
        }while(!board.isBoardFull() );
    }

    private static boolean play_round(Player player, Board board){
        player.makeMove();
        board.print_board();

        if(player.isWinner()){
            System.out.print(player.getClass().getSimpleName() + " wins!");
            return true;
        }

        return false;
    }
}
