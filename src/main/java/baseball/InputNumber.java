package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    private List<String> userNumber;

    public InputNumber(){
        userNumber = new ArrayList<>() ;
    }

    public List<String> userInputNumber(){
        System.out.println("숫자를 입력해주세요.");
        String userInput = Console.readLine();
        userNumber.add(userInput);
        return userNumber;
    }

    public void userInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = Console.readLine();
    }

    public String inputNumberCheck(){
        if(InputNumberValidator.inputNumberTotalCheck(userNumber)){
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public String restartOrEndNumberCheck(){
        if(!InputNumberValidator.restartOrEndNumberCheck(userNumber)){
            throw new IllegalArgumentException();
        }
        return userNumber;
    }


}
