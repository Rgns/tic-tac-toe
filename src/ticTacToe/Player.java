package ticTacToe;

public class Player extends User {

    private final Piece piece;

    public Player(String userName, String userId, Piece piece) {
        super(userName, userId);
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

}
