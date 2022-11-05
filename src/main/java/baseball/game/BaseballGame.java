package baseball.game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BaseballGame {

    private int receiveInput(){
        int inputNum;
        Scanner sc = new Scanner(System.in);
        inputNum = sc.nextInt();
        return inputNum;
    }

    private int[] makeInputNumArray(int inputNum){
        int[] inputNumArray = Stream.of(String.valueOf(inputNum).split("")).mapToInt(Integer::parseInt).toArray();
        return inputNumArray;
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
