package baseball.view;

import baseball.model.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class PlayerView {
    private UserNumber userNumber = new UserNumber();

    public String playerInput(){
        System.out.println("숫자를 입력해 주세요 : ");
        String input = Console.readLine();

        if(!userNumber.isInputDigit(input)
                || !userNumber.isInputUnderMaxLength(input)
                || !userNumber.isBetween1to9(input)
                || !userNumber.isInputNotDuplicate(input)){
            throw new IllegalArgumentException();
        }
        else{
            return input;
        }
    }
    public boolean isGameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if(!userNumber.isInputDigit(input)
                || !userNumber.is1or2(input)){
            throw new IllegalArgumentException();
        }
        if(input.equals("1")){
            return true;
        }
        return false;
    }
}
