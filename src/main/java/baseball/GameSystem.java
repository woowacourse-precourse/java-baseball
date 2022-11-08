package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class GameSystem {
    static final int WIN_STRIKE_COUNT = 3;
    private Player player;
    private Computer computer;
    private ScoreBoard scoreBoard;


    public GameSystem() {}


    public void initiate() {
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


    public boolean checkWin() {
        if (scoreBoard.getStrikeCount() == WIN_STRIKE_COUNT) {
            return true;
        }

        return false;
    }


    public void run() {
        this.initiate();
        computer.generateNumber();

        do {
            GameMessagePrinter.printInput();
            String input = readLine();

            player.setNumber(input);

            scoreBoard.initiate();
            this.calculateScore();
            GameMessagePrinter.printScore(this.scoreBoard);
        } while (!this.checkWin());
    }
}
