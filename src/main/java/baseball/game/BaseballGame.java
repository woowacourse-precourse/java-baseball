package baseball.game;

import java.util.Scanner;

public class BaseballGame {

    private int receiveInput(){
        int inputValue;
        Scanner sc = new Scanner(System.in);
        inputValue = sc.nextInt();
        return inputValue;
    }

}
