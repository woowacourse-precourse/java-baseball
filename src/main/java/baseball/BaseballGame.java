package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    int[] computerNumber;
    Hint hint;
    User user;
    Scanner continueScanner = new Scanner(System.in);
    BaseballGame(){
        this.hint = new Hint();
        this.computerNumber = new int[3];
        this.user = new User();
    }

    public void makeRandomNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");

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
        makeRandomNumber();
        do {
            user.UserInput();
            hint.getHint(user.getUserNumber(), computerNumber);
        } while (hint.strike != 3);
    }
    public boolean restartGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return continueGame();
    }

    private boolean continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = continueScanner.nextInt();
        if (input == 1){
            return true;
        }
        return false;
    }
}
