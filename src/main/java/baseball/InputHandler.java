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

        List<Integer> myNumList = new ArrayList<>();
        for(int i=0; i< myNum.length(); i++){
            myNumList.add(Integer.parseInt(myNum.substring(i,i+1)));
        }
        if(!errorHandler.isLengthSizeis3(myNumList)){
            throw new IllegalArgumentException("숫자는 세자리 수여야 합니다.");
        }
        if(!errorHandler.isNotDuplicated(myNumList)){
            throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
        }
        return myNum;
    }
    public int getRestartNum() throws IOException {
        try {
            int restartNum = Integer.parseInt(br.readLine());
            System.out.println("입력 수 : " + restartNum);
            return restartNum;
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }
}
