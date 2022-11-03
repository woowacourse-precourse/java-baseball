package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Game {
    protected static final int answerLength = 3;
    private static final int newGame = 1;
    private static final int endGame = 2;

    public static List<Integer> correctAnswer = new ArrayList<>();
    private int newOrEnd = 0;

    AnswerSheet answerSheet = new AnswerSheet();
    Hint hint = new Hint();

    public void start() {
        guideToStart();
        setComputerAnswer();

        while (true) {
            answerSheet.getUserAnswer();
            if (answerSheet.isCorrectAnswer(hint.getHint())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        askContinue();
    }

    private void guideToStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void setComputerAnswer() {
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
        newOrEnd = Integer.parseInt(Console.readLine());

        if (newOrEnd == newGame) {
            this.start();
        } else if (newOrEnd == endGame) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
