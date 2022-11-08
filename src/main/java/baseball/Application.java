package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application startBaseball = new Application();
        startBaseball.printStart();

        Computer computer = new Computer();
        List<Integer> computerInput;
        computerInput = computer.setComputer();

        boolean resetComputer = false;
        int userNumToEndGame = 0;
        while(userNumToEndGame != 2) {
            if(resetComputer) {
                computerInput = computer.setComputer();
                resetComputer = false;
            }

            UserAnswer userAnswer = new UserAnswer();
            userAnswer.printEnterNum();
            List<Integer> userInput = userAnswer.setUserAnswer();

            BallOrStrike ballOrStrike = new BallOrStrike();
            boolean isEndOfGame = ballOrStrike.countStrikeBall(userInput, computerInput);
            if(isEndOfGame) {
                userNumToEndGame = userAnswer.setUserEndGame();
            }
            if(userNumToEndGame == 1) {
                resetComputer = true;
                userNumToEndGame = 0;
            }
        }
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }



}
