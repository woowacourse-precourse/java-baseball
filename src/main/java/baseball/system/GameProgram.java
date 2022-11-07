package baseball.system;

import baseball.datamodel.ComputerNumber;
import baseball.datamodel.UserNumber;
import baseball.util.CalculateScore;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameProgram {
    private static final int TOTAL_NUMBER = 3;
    private List<Integer> computerNumList;
    private List<Integer> userNumList;

    private boolean endGame = false;
    private boolean endError = false;
    private String input;
    private int ball;
    private int strike;

    private final UserNumber user = new UserNumber();
    private final CalculateScore calculator = new CalculateScore();
    private final ComputerNumber computer = new ComputerNumber();

    public void start(){
        computer.makeNumber();
        computerNumList = computer.getNumbers();

        calculator.setComputerNumber(computerNumList);

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!endGame) {
            ball = 0;
            strike = 0;

            System.out.print("숫자를 입력해주세요 : ");

            input = Console.readLine();
            user.checkNumber(input);
            userNumList = user.getNumbers();

            for(int i = 0; i <TOTAL_NUMBER; i++) {
                int result = calculator.compareNumber(userNumList.get(i), i);
                scoreCounter(result);
            }

            if (strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {
                gameContinue();
            }
        }
    }

    public void scoreCounter (int result) {
        if (result == 1){
            strike++;
        } else if (result == 2) {
            ball++;
        }
    }

    public void gameContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        endError = false;

        while (!endError) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();

            if (input.equals("2")) {
                endError = true;
                endGame = true;
            } else if (input.equals("1")) {
                computer.makeNumber();
                computerNumList = computer.getNumbers();

                calculator.setComputerNumber(computerNumList);
                endError = true;
            }
        }
    }
}
