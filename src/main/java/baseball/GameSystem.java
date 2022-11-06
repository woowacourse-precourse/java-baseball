package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.*;

public class GameSystem {
    public void gameStart(){
        HashSet<String> computerNumber = RandomUtil.giveComputerNumber();
        Hint hint = new Hint();
        List<String> userNumber;
        boolean exit=false;

        do{
            //숫자 입력 메시지 출력 및 숫자 입력 받기
            System.out.print(inputNumberMessage+" ");
            userNumber = InputUtil.inputUserNumber();
            hint.hintCalculator(computerNumber,userNumber);
            if(hint.threeStrike) {
                System.out.println(gameEndingMessage);
                exit=true;
            }
        }while(!exit);
    }

    public boolean gameReStart(){
        System.out.println(gameRestartMessage);
        int inputExitNumber = Integer.parseInt(Console.readLine());
        if(inputExitNumber == 2) return true;
        return false;
    }
}
