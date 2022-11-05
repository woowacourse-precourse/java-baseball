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

    private int[] createInputNumArray(int inputNum){
        int[] inputNumArray = Stream.of(String.valueOf(inputNum).split("")).mapToInt(Integer::parseInt).toArray();
        return inputNumArray;
    }


}
