package baseball;

import baseball.utils.validation;
import camp.nextstep.edu.missionutils.Console;
public class Continue {
    public boolean decideContinue(){
        System.out.println("다시 하시겠습니까? 재시작 : 1 , 종료 :2");
        String input = Console.readLine();
        validation.startOrEndValidation(input);
        char inputChar = input.charAt(0);
        if(inputChar == '1'){
            return true;
        }
        else{
            return false;
        }
    }

}
