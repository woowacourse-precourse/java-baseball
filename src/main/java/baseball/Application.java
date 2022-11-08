package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * 숫자 야구 게임을 진행한다.
 */
public final class Application {

    public static void main(String[] args) {
        new Application().startGameUntilTheEnd();
    }

    private static final int LOWEST_ANSWER = 123;
    private static final int HIGHEST_ANSWER = 987;

    /**
     * 게임의 계속 진행 여부
     */
    private boolean playing;

    /**
     * 숫자 야구 게임의 답
     */
    private String answer;

    /**
     * 사람이 상대할 컴퓨터 플레이어
     */
    private AIPlayer player;

    /**
     * Guess에 대한 검증을 수행
     */
    private final GuessValidator validator;

    /**
     * 숫자 야구 게임을 초기화한다.
     */
    public Application() {
        this.playing = true;
        this.validator = new GuessValidator();
        this.answer = this.newAnswer();
        this.player = new AIPlayer(this.answer);
    }

    /**
     * 게임을 시작한다.
     * 사용자의 종료 선택 시까지 종료되지 않는다.
     */
    public void startGameUntilTheEnd() {
        while (this.playing) {
            this.playGame();

            var command = Console.readLine();
            this.restartOrEnd(command);
        }
    }

    private void playGame() {
        this.hello();
        this.repeatScoringForGuesses();
        this.congratulate();
    }

    /**
     * 시작 메시지를 표시한다.
     */
    private void hello() {
        var helloMessage = this.player.helloMessage();
        this.promptln(helloMessage);
    }

    /**
     * 사용자의 추측에 대해 답변하는 일을 반복한다.
     */
    private void repeatScoringForGuesses() {
        while (!this.player.defeated()) {
            var askMessage = this.player.askMessage();
            this.prompt(askMessage);

            var guess = Console.readLine();

            this.validator.validateGuess(guess);

            var score = this.player.scoreOf(guess);
            this.promptln(score);
        }
    }

    /**
     * 성공 메시지를 표시한다.
     */
    private void congratulate() {
        var successMessage = this.player.successMessage();
        this.promptln(successMessage);
    }

    private void updateAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    private String newAnswer() {
        return String.valueOf(Randoms.pickNumberInRange(LOWEST_ANSWER, HIGHEST_ANSWER));
    }

    private void prompt(String message) {
        System.out.print(message);
    }

    private void promptln(String message) {
        System.out.println(message);
    }

    /**
     * 새로운 게임을 질의하고 그에 따라 재시작, 종료를 수행한다.
     *
     * 입력값이 1, 2가 아니면 예외를 던진다.
     */
    private void restartOrEnd(String command) {
        if (command.equals("1")) {
            this.resetGame();
        } else if (command.equals("2")) {
            this.playing = false;
        } else {
            throw new IllegalArgumentException("알 수 없는 명령입니다.");
        }
    }

    /**
     * 새로운 게임을 시작하기 위해 새로운 답을 설정한다.
     */
    private void resetGame() {
        var newAnswer = this.newAnswer();
        this.updateAnswer(newAnswer);
        this.player = new AIPlayer(newAnswer);
    }
}
