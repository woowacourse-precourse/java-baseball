package baseball.view;

import baseball.model.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class PlayerView {
    private UserNumber userNumber = new UserNumber();

    public String playerInput(){
        System.out.println("숫자를 입력해 주세요 : ");
        String input = Console.readLine();

        if(!userNumber.isInputDigit(input)
                || !userNumber.isInputLengthUnder3(input)
                || !userNumber.isBetween1to9(input)
                || !userNumber.isInputNotDuplicate(input)){
            throw new IllegalArgumentException();
        }
        else{
            return input;
        }
    }
}
