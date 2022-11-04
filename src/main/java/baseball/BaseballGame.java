package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    int[] computerNumber;
    int[] userNumber;
    BaseballGame(){
    }

    public void makeRandomNumber() {
        computerNumber = new int[3];
        boolean[] alreadyUsed = new boolean[10];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(9) + 1;

            if (!alreadyUsed[number]) {
                alreadyUsed[number] = true;
                computerNumber[i] = number;
            } else {
                i--;
            }
        }
    }

    public void startGame(){
        String userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        if (invalidUserNumber(userInput)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public boolean restartGame(){
        return true;
    }

    public boolean invalidUserNumber(String userInput){

    }
}
