package baseball.domain;

public class Game {
    public static final int MAX_STRIKE = 3;
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final int RESTART = 1;

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맟히셨습니다! ";
    public static final String GAME_FINISH_MESSAGE = "게임 종료";
    public static final String RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Computer computer;
    private final Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        do {
            computer.generateNumber();
            guessAndCheck();
            System.out.println(SUCCESS_MESSAGE);
            System.out.println(GAME_FINISH_MESSAGE);
            System.out.println(RESTART_OR_QUIT_MESSAGE);
        } while(player.getChoice() == RESTART);
    }

    public void guessAndCheck() {
        Result result;
        do{
            System.out.print(INPUT_MESSAGE);
            String guessNumber = player.getInput();
            result = computer.compareNumber(guessNumber);
            showResult(result);
        } while(isNotFinished(result));
    }

    public void showResult(Result result) {
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if(ballCount != 0){
            System.out.print(ballCount+BALL);
        }
        if(strikeCount != 0){
            System.out.print(strikeCount+STRIKE);
        }
        if(ballCount == 0 && strikeCount == 0) {
            System.out.print(NOTHING);
        }
        System.out.println();
    }

    public boolean isNotFinished(Result result) {
        return result.getStrikeCount() != MAX_STRIKE;
    }
}
