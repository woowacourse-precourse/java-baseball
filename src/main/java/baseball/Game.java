package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String WIN_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL_TEXT = "볼 ";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTHING_TEXT = "낫싱";

    private List<Integer> userNumber = new ArrayList<>();
    private List<Integer> computerNumber = new ArrayList<>();
    private Score score;

    public Game() {
        this.computerNumber = Generate.randomNumber();
    }

    public void start() {
        System.out.println(START_SENTENCE);

        while (true) {
            System.out.print(INPUT_SENTENCE);

            this.score = new Score();
            String userInput = Console.readLine();
            InputException.occur(userInput);

            this.userNumber = Change.numberToList(userInput);
            play();

            System.out.println(getGameResult());
            if (!isWin()) {
                continue;
            }

            System.out.println(WIN_SENTENCE);
            System.out.println(RESTART_SENTENCE);
            if (!restart()) {
                break;
            }
            this.computerNumber = Generate.randomNumber();
        }
    }

    public void play() {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            if (this.userNumber.get(i).equals(this.computerNumber.get(i))) {
                this.score.setStrike(score.getStrike() + 1);
                continue;
            }

            if (this.computerNumber.contains(this.userNumber.get(i))) {
                this.score.setBall(score.getBall() + 1);
            }
        }
    }

    public boolean isWin() {
        return this.score.getStrike() == Constant.GOAL;
    }

    public String getGameResult() {
        if (this.score.getBall() + this.score.getStrike() == 0) {
            return NOTHING_TEXT;
        }

        StringBuilder gameResult = new StringBuilder();
        if (this.score.getBall() > 0) {
            gameResult.append(this.score.getBall()).append(BALL_TEXT);
        }

        if (this.score.getStrike() > 0) {
            gameResult.append(this.score.getStrike()).append(STRIKE_TEXT);
        }
        return gameResult.toString();
    }

    public boolean restart() {
        String userSelect = Console.readLine();
        if (!(userSelect.equals("1") || userSelect.equals("2"))) {
            throw new IllegalArgumentException();
        }

        return userSelect.equals("1");
    }
}
