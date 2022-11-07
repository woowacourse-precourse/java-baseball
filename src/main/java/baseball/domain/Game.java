package baseball.domain;

public class Game {
    public static final int MAX_STRIKE = 3;

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private Computer computer;
    private Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        do {
            computer.generateNumber();
            guessAndCheck();

        } while(restart);
    }

    public void guessAndCheck() {
        Result result;
        do{
            System.out.print(INPUT_MESSAGE);
            String guessNumber = player.getInput();
            result = computer.compareNumber(guessNumber);
        } while(isNotFinished(result));
    }

    public boolean isNotFinished(Result result) {
        return result.getStrikeCount() != MAX_STRIKE;
    }
}
