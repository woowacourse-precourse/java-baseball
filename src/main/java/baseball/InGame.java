package baseball;

import java.util.Arrays;

public class InGame {
    public static int strike=0;
    public static int ball=0;

    public void afterGameStart() {
        gameLoop();
        afterGameEnded();
    }

    public void gameLoop(){
        Computer computer = new Computer();
        Validity valid = new Validity();

        int[] RandomizedArray = computer.makeRandomizedArray();
        System.out.println(Arrays.toString(RandomizedArray));

        while (strike < 3) {
            strike = 0;
            ball = 0;
            int[] input = valid.InputCheckValidAndReturn();
            ifNumberAndLocationEqualsAddStrike(RandomizedArray, input);
            ifNumberEqualsAddBall(RandomizedArray, input);
            ball = ball - strike;

            printCaseBeforeSuccess();
            printSuccess();
        }
    }
    public void printSuccess(){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void ifNumberAndLocationEqualsAddStrike(int[] RandomNumber, int[] inputNumber) {

        for (int i = 0; i < RandomNumber.length; i++) {
            if (RandomNumber[i] == inputNumber[i]) {
                strike++;
            }
        }
    }

    public void ifNumberEqualsAddBall(int[] RandomNumber, int[] inputNumber) {

        for (int i = 0; i < RandomNumber.length; i++) {
            for (int j = 0; j < RandomNumber.length; j++) {
                AddBallIfEquals(RandomNumber[i], inputNumber[j]);
            }
        }

    }
    public void AddBallIfEquals(int RandomNumber, int InputNumber) {
        if (RandomNumber == InputNumber) {
            ball++;
        }
    }

    public void printCaseBeforeSuccess() {
        if ((ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        }
        if ((ball != 0) && (strike != 0)) {
            System.out.println(ball + " 볼 " + strike + " 스트라이크");
        }
        if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + " 볼");
        }
        if ((ball == 0) && (strike != 0)) {
            System.out.println(strike + " 스트라이크");
        }
    }

    public void afterGameEnded() {
        Computer computer = new Computer();
        Validity validity = new Validity();
        strike = 0;
        ball = 0;

        String input = computer.descriptionAndInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        validity.checkEndInput(input);
    }



}
