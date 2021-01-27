package ticTacToe;

public class TicTacToe {

    public static void main(String[] args) {

        Player p1 = new Player("Ritu","Rg",Piece.X);
        Player p2 = new Player("Akash","Aks",Piece.O);

        System.out.println("Game 1");
        Game ticTac = new Game(p1,p2);
        ticTac.play(0,0);
        ticTac.play(0,1);
        ticTac.play(0,2);
        ticTac.play(1,1);
        ticTac.play(1,0);
        ticTac.play(2,1);
        ticTac.play(2,2);

        System.out.println("Game 2");
        ticTac = new Game(p1,p2);
        ticTac.play(0,0);
        ticTac.play(0,1);
        ticTac.play(1,1);
        ticTac.play(1,0);
        ticTac.play(2,2);

    }

}
