package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.ComputerNumber.createComputerNumber;
import static baseball.UserNumber.checkInputUserNumber;

public class BaseballGame {

    private static List<Integer> computerNumbers;
    private static List<Integer> userNumbers;

    private static int strike;
    private static int ball;

    public static void playBaseballGame(){
        computerNumbers = createComputerNumber();
        while (true) {
            strike=0; ball=0;
            userNumbers = checkInputUserNumber();
            compareNumber();
        }
    }

    public static void compareNumber(){
        for(int i=0;i<3;i++){
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);
            if (!computerNumbers.contains(userNumber)) continue;
            if (userNumber == computerNumber) strike++;
            else if (userNumber != computerNumber) ball++;
        }
    }

    public static void restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();

        if (restartNumber == "1") {
            playBaseballGame();
        }
    }

}
