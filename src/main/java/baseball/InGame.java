package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

public class InGame {
    private int ball=0;
    private int strike=0;

    public void afterGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다");
        gameLoop();
    }

    private void gameLoop(){
        Computer computer = new Computer();

        while (this.strike < 3) {
            refreshBallStrike();
            System.out.print("숫자를 입력해주세요: ");
            User user = new User();
            ifValidAddBallStrike(computer.getRandomizedList(), user.getUserNumbers());
            printCaseBeforeSuccess(this.ball, this.strike);
            printSuccess(this.strike);
        }
        afterGameEnded();
    }
    private void refreshBallStrike(){
        this.ball =0;
        this.strike = 0;
    }

    private void printSuccess(int strike){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void ifValidAddBallStrike(List<Integer> randomNumbers, List<Integer> inputNumber) {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(randomNumbers.get(i), inputNumber.get(i))) {
                this.strike++;
            }
            else if(randomNumbers.contains(inputNumber.get(i))){
                this.ball++;
            }
        }
    }

    private void printCaseBeforeSuccess(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        }
        if ((ball != 0) && (strike != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + "볼");
        }
        if ((ball == 0) && (strike != 0)) {
            System.out.println(strike + "스트라이크");
        }
    }

    private void afterGameEnded() {
        refreshBallStrike();
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(Validity.checkEndInput(input)){
            gameLoop();
        }
    }



}
