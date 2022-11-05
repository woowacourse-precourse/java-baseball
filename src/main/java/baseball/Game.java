package baseball;

import java.util.List;

public class Game {
    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerAnswer = Computer.generateNumber();
        boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            isCorrectAnswer = checkAnswer(computerAnswer, Computer.getPlayerAnswer());
        }
    }
    public static boolean checkAnswer(List<Integer> computerAnswer, List<Integer> playerAnswer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerAnswer.get(i).equals(playerAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(playerAnswer.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        if(strike == 3){
            return true;
        }else{
            return false;
        }
    }
    private static void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
