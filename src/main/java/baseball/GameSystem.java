package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class GameSystem {
    static final int WIN_STRIKE_COUNT = 3;
    private Player player;
    private Computer computer;
    private ScoreBoard scoreBoard;


    public GameSystem() {}


    public void initGame() {
        this.player = new Player();
        this.computer = new Computer();
        this.scoreBoard = new ScoreBoard();
    }

    public void calculateScore() {
        String playerNumber = player.getNumber();
        String computerNumber = computer.getNumber();
        final int INVALID_INDEX = -1;

        for (char playerNumberChar : playerNumber.toCharArray()) {
            if (playerNumber.indexOf(playerNumberChar) == computerNumber.indexOf(playerNumberChar)) {
                scoreBoard.upStrikeCount();
            } else if (computerNumber.indexOf(playerNumberChar) != INVALID_INDEX) {
                scoreBoard.upBallCount();
            }
        }
    }


    public boolean checkWinGame() {
        if (scoreBoard.getStrikeCount() == WIN_STRIKE_COUNT) {
            return true;
        }

        return false;
    }


    public void run() {
        this.initGame();

        try {
            computer.generateNumber();
        } catch (IllegalArgumentException Exception) {
            throw Exception;
        }

        do {
            GameMessagePrinter.printInput();
            String inputNumber = readLine();

            try {
                player.setNumber(inputNumber);
            } catch (IllegalArgumentException Exception) {
                throw Exception;
            }

            this.scoreBoard.initScore();
            this.calculateScore();
            GameMessagePrinter.printScore(this.scoreBoard);
        } while (!this.checkWinGame());

    }
}
