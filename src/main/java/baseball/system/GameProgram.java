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
    private String input;
    private int ball;
    private int strike;

    public void start(){
        UserNumber user = new UserNumber();
        CalculateScore calculator = new CalculateScore();
        ComputerNumber computer = new ComputerNumber();

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
                System.out.println(strike + "스크라이크");
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {

            }
        }
    }

    
}
