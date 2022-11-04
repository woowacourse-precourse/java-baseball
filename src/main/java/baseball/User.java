package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;

public class User {
    private static String inputNumber;

    public void setNumber(){
        inputNumber = getNumberFromInput();
    }

    public String getNumberFromInput(){
        Message.showNumberRequestMessage();
        String inputNumber = Console.readLine();
        return inputNumber;
    }
}
