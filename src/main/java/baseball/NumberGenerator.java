package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    static final int NUMBER_LENGTH = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NumberGenerator.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + NumberGenerator.NEW_GAME + ", 종료하려면 " + NumberGenerator.QUIT_GAME + "를 입력하세요.";

    int[] number = new int[NUMBER_LENGTH];

    Game() {
        int nowRandomNum;
        int nowNumberIndex = 0;
        while (nowNumberIndex < NEW_GAME) {
            nowRandomNum = this.getRandomNumber();
            if (!Array.checkArrayContains(number, nowRandomNum)) {
                number[nowNumberIndex++] = nowRandomNum;
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < NumberGenerator.NUMBER_LENGTH; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }
    private int getRandomNumber() {
        return pickNumberInRange(NumberGenerator.START_RANGE, NumberGenerator.END_RANGE);
    }
    public static void init(NumberGenerator rightAnswer) {
        NumberGenerator answer = NumberGenerator.getAnswer();
        Hint hint = new Hint();
        hint.compareAnswer(answer, rightAnswer);
        hint.showResult();
        if (hint.strike != NumberGenerator.NUMBER_LENGTH) {
            NumberGenerator.init(rightAnswer);
            return;
        }

        int newGameAnswer = NumberGenerator.checkNewGameStart();

        if (newGameAnswer == NumberGenerator.NEW_GAME) {
            rightAnswer = new NumberGenerator();
            NumberGenerator.init(rightAnswer);
        }
    }




}
