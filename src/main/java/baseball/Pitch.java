package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Pitch {

    public static List<Integer> userAnswer = new ArrayList<>();
    protected String[] userInputToGuess;
    public boolean isCorrectAnswer;

    IllegalArgument illegalArgument = new IllegalArgument();

    public void getUserAnswer() {
        userAnswer.clear();
        setUserAnswer();
    }

    public void guideToEnterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    protected void setUserAnswer() {
        illegalArgument.check(getUserInputToGuess(), Game.answerLength, Game.numberForAnswer);
        for (String input : userInputToGuess) {
            userAnswer.add(Integer.parseInt(input));
        }
    }

    protected String[] getUserInputToGuess() {
        userInputToGuess = Console.readLine().split("");
        return userInputToGuess;
    }

    public boolean checkCorrect(String hint) {
        this.isCorrectAnswer = false;
        if (hint.equals("3스트라이크")) {
            this.isCorrectAnswer = true;
        }
        return this.isCorrectAnswer;
    }

    public void guideAnswerIsCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}