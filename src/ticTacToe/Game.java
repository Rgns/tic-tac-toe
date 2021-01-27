package ticTacToe;


public class Game {

    private final Board board;
    private final Player[] players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private final int cellCount = 3;
    private final int noOfPlayers = 2;
    private final int[] arrRow = new int[cellCount];
    private final int[] arrCol = new int[cellCount];
    private int drl = 0;
    private int dlr = 0;

    public Game(Player p1, Player p2) {
        players = new Player[noOfPlayers];
        players[0] = p1;
        players[1] = p2;
        board = new Board(cellCount);
        currentPlayer = players[0];
        gameStatus = GameStatus.PLAYING;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public boolean play(int row, int col) {
        if (GameStatus.PLAYING == gameStatus) {
            if (isValidMove(row, col)) {
                board.boxes[row][col].setPiece(currentPlayer.getPiece());
                if (checkIfWon(row, col)) {
                    board.printBoardStatus();
                    return false;
                } else if (checkIfDraw(row, col)) {
                    board.printBoardStatus();
                    return false;
                }
                gameStatus = GameStatus.PLAYING;
                changeTurn();
                board.printBoardStatus();
                return true;
            }
            System.out.println(currentPlayer.getUserName() + " Please put valid move!");
            board.printBoardStatus();
            return false;
        } else {
            System.out.println(currentPlayer.getUserName() + " has already won the game! GAME IS OVER");
            board.printBoardStatus();
            return false;
        }
    }

    private boolean checkIfDraw(int row, int col) {
        if (drl > cellCount || dlr > cellCount || arrCol[col] > cellCount || arrRow[row] > cellCount
                || -cellCount > arrRow[row] || drl < -cellCount || dlr < -cellCount || arrCol[col] < -cellCount) {

            gameStatus = GameStatus.DRAW;
            System.out.println("Game has been finished with status DRAW!!");
            return true;
        }
        return false;
    }

    private void changeTurn() {
        if (currentPlayer.getUserId().equals(players[0].getUserId())) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
    }


    private boolean checkIfWon(int row, int col) {

        if (currentPlayer.getUserId().equals(players[0].getUserId())) {
            if (row == col) {
                dlr++;
            } else if (row + col == cellCount - 1) {
                drl++;
            }
            arrRow[row] = arrRow[row] + 1;
            arrCol[col] = arrCol[col] + 1;
            if (arrRow[row] == cellCount || arrCol[col] == cellCount || drl == cellCount || dlr == cellCount) {
                gameStatus = GameStatus.WON;
                System.out.println(currentPlayer.getUserName() + " has won the Game!!");
                return true;
            }
        } else {
            if (row == col) {
                dlr--;
            } else if (row + col == -(cellCount - 1)) {
                drl--;
            }
            arrRow[row] = arrRow[row] - 1;
            arrCol[col] = arrCol[col] - 1;
            if (arrRow[row] == -cellCount || arrCol[col] == -cellCount || drl == -cellCount || dlr == -cellCount) {
                gameStatus = GameStatus.WON;
                System.out.println(currentPlayer.getUserName() + " has won the Game!!");
                return true;
            }

        }

        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row < cellCount && col < cellCount && board.boxes[row][col] != null;
    }


}
