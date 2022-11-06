package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Game {
    public static void playGame() {
        System.out.println(START_MESSAGE);
        List<Integer> computerAnswer = Computer.generateNumber();
        boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            isCorrectAnswer = checkAnswer(computerAnswer, Computer.getPlayerAnswer());
        }
    }
    public static boolean checkAnswer(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerAnswer.get(i).equals(playerAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(playerAnswer.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        if(strike == NUMBER_SIZE){
            return true;
        }else{
            return false;
        }
    }
    private static void printResult(int strike, int ball) {
        if (strike == NUMBER_SIZE) {
            System.out.println("3스트라이크");
            System.out.println(SUCCESS_MESSAGE);
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
        } else {
            System.out.println(ball + BALL_MESSAGE + strike + STRIKE_MESSAGE);
        }
    }
}
