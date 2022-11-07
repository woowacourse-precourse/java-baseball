package baseball;


import java.util.List;
import java.util.Objects;

public class InGame {
    private int ball=0;
    private int strike=0;

    public void afterGameStart() {
        gameLoop();
        afterGameEnded();
    }

    public void gameLoop(){
        Computer computer = new Computer();
        Validity valid = new Validity();
        Revert revert = new Revert();

        while (strike < 3) {
            refreshBallStrike();
            String InputString=computer.descriptionAndInput("숫자를 입력해주세요:");
            valid.isInputNumberValid(revert.revertStringToCharArray(InputString));
            ifValidAddBallStrike(computer.makeRandomizedArray(), revert.revertIntArrayToList(revert.revertCharArrToIntArr(revert.revertStringToCharArray(InputString))));

            printCaseBeforeSuccess(ball, strike);
            printSuccess();
        }
    }
    public void refreshBallStrike(){
        ball =0;
        strike = 0;
    }

    public void printSuccess(){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void ifValidAddBallStrike(List<Integer> randomNumbers, List<Integer> inputNumber) {

        for (int i = 0; i < randomNumbers.size(); i++) {
            if (Objects.equals(randomNumbers.get(i), inputNumber.get(i))) {
                strike++;
            }
            else if(randomNumbers.contains(inputNumber.get(i))){
                ball++;
            }
        }
    }

    public void printCaseBeforeSuccess(int ball, int strike) {
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

    public void afterGameEnded() {
        Computer computer = new Computer();
        Validity validity = new Validity();
        strike = 0;
        ball = 0;

        String input = computer.descriptionAndInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        validity.checkEndInput(input);
    }



}
