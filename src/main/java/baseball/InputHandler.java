package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    static ErrorHandler errorHandler;
    static OutputHandler outputHandler;


    public static String getInput_returnMyNum() {
        outputHandler = new OutputHandler();
        errorHandler = new ErrorHandler();
        outputHandler.printGetUserNumber();

        String myNum = Console.readLine();
        if(!errorHandler.isAllDigit(myNum)){
            throw new IllegalArgumentException();
        }
        List<Integer> myNumList = new ArrayList<>();
        for(int i=0; i< myNum.length(); i++){
            myNumList.add(Integer.parseInt(myNum.substring(i,i+1)));
        }
        if(!errorHandler.isLengthSizeis3(myNumList)){
            throw new IllegalArgumentException();
        }
        if(!errorHandler.isRange(myNumList)){
            throw new IllegalArgumentException();
        }
        if(!errorHandler.isNotDuplicated(myNumList)){
            throw new IllegalArgumentException();
        }
        return myNum;
    }
    public String getRestartNum() {
        String restartNum = Console.readLine();

        return restartNum;
    }
}
