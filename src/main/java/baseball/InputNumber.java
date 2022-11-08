package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    private List<String> userNumber;

    public InputNumber(){
        userNumber = new ArrayList<>() ;
    }

    public String getUserNumber(){
        return userNumber;
    }

    public void userInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = Console.readLine();
    }

    public void userInputBallNumber(){
        userInputNumber();
        if(!InputNumberValidator.inputNumberCorrection(userNumber)){
            userNumber = userNumber.replaceAll(",","");
            userNumber = userNumber.replaceAll(" ","");
        }
        userNumber = inputNumberCheck();
    }

    public void userChoiceRestartOrEnd(){
        userInputNumber();
        userNumber = restartOrEndNumberCheck();
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
