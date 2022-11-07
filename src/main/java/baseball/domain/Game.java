package baseball.domain;

public class Game {
    private final Computer computer;
    private final Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void start() {
        System.out.println(Constants.GAME_START_MESSAGE);
        do {
            computer.generateNumber();
            guessAndCheck();
            System.out.println(Constants.SUCCESS_MESSAGE);
            System.out.println(Constants.GAME_FINISH_MESSAGE);
            System.out.println(Constants.RESTART_OR_QUIT_MESSAGE);
        } while(player.getChoice() == Constants.RESTART_CHOICE);
    }

    public void guessAndCheck() {
        Result result;
        do{
            System.out.print(Constants.INPUT_MESSAGE);
            String guessNumber = player.getInput();
            result = computer.compareNumber(guessNumber);
            showResult(result);
        } while(isNotFinished(result));
    }

    public void showResult(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if(ballCount != 0){
            System.out.print(ballCount+Constants.BALL);
        }
        if(strikeCount != 0){
            System.out.print(strikeCount+Constants.STRIKE);
        }
        if(ballCount == 0 && strikeCount == 0) {
            System.out.print(Constants.NOTHING);
        }
        System.out.println();
    }

    public boolean isNotFinished(Result result) {
        return result.getStrikeCount() != Constants.MAX_STRIKE;
    }
}
