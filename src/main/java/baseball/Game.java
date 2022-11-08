package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Game {
    public static final int answerLength = 3;
    public static final List<Integer> numberForAnswer = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    public static final int intentionLength = 1;
    public static final List<Integer> numberForIntention = List.of(1, 2);

    protected static final String newGame = "1";
    protected static final String endGame = "2";

    public static List<Integer> correctAnswer = new ArrayList<>();
    private boolean isCorrect;
    private String[] userInputForProgress;
    protected String userIntention;

    Pitch pitch = new Pitch();
    Hint hint = new Hint();
    IllegalArgument illegalArgument = new IllegalArgument();

    public void start() {
        guideToStart();
        setComputerAnswer();

        while (true) {
            pitch.guideToEnterNumber();
            pitch.getUserAnswer();

            isCorrect = pitch.checkCorrect(hint.get());
            hint.show();
            if (isCorrect) {
                pitch.guideAnswerIsCorrect();
                break;
            }
        }

        askContinue();
        getUserIntention();
        if (userIntention.equals(newGame)) {
            this.start();
        }
        if (userIntention.equals(endGame)) {
            return;
        }
    }

    private void guideToStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void setComputerAnswer() {
        correctAnswer.clear();

        while (correctAnswer.size() < answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(randomNumber)) {
                correctAnswer.add(randomNumber);
            }
        }
    }

    private void askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    protected void getUserIntention() {
        userInputForProgress = Console.readLine().split("");
        illegalArgument.check(userInputForProgress, intentionLength, numberForIntention);

        userIntention = userInputForProgress[0];
    }
}
