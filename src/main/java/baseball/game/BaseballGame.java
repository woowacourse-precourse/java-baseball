package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

public class BaseballGame {

    private String receiveInput(){
        String inputNum;
        inputNum = Console.readLine();
        return inputNum;
    }

    private List<String> makeInputNumList(String inputNum){
        String[] inputNumArray = inputNum.split("");
        List<String> inputNumList = new ArrayList<>(Arrays.asList(inputNumArray));
        return inputNumList;
    }

    private void makeErrorCheckingInputSize(int[] inputNumArray){
        try{
            if(inputNumArray.length > 3)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            System.out.println("세 자리 이상의 수를 입력하였습니다");
            System.exit(1);
        }
    }
}
