package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    static ErrorHandler errorHandler;
    static OutputHandler outputHandler;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput_returnMyNum() throws IOException {
        outputHandler = new OutputHandler();
        errorHandler = new ErrorHandler();
        outputHandler.printGetUserNumber();

        String myNum = br.readLine();
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
        if(!errorHandler.isNotDuplicated(myNumList)){
            throw new IllegalArgumentException();
        }
        return myNum;
    }
    public int getRestartNum() throws IOException {
        try {
            int restartNum = Integer.parseInt(br.readLine());
            return restartNum;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
