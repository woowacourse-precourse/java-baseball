package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;

public class GameSystem {
    public void gameStart(){
        String computerNumber = RandomUtil.giveComputerNumber();
        System.out.println(computerNumber);
        String userNumber;
        boolean exit=false;

        do{
            //숫자 입력 메시지 출력 및 숫자 입력 받기
            System.out.print(inputNumberMessage+" ");
            userNumber = InputUtil.inputUserNumber();
            Hint.hintCalculator(computerNumber,userNumber);
            if(Hint.threeStrike) {
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
