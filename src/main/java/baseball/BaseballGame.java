package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    int[] computerNumber;
    int[] userNumber;
    Hint hint;
    Scanner continueScanner = new Scanner(System.in);
    Scanner userScanner = new Scanner(System.in);
    BaseballGame(){
        this.hint = new Hint();
        this.computerNumber = new int[3];
        this.userNumber = new int[3];
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
        String userInput;
        do {
            System.out.print("숫자를 입력해주세요 : ");

            userInput = userScanner.nextLine();
            if (invalidUserNumber(userInput)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            } else {
                for (int i = 0; i < 3; i++) {
                    this.userNumber[i] = Character.getNumericValue(userInput.charAt(i));
                }
            }

            hint.getHint(userNumber, computerNumber);
        } while (hint.strike != 3);
    }
    public boolean restartGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return isContinue();
    }

    private boolean isContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = continueScanner.nextInt();
        if (input == 1){
            return true;
        }
        return false;
    }

    public boolean invalidUserNumber(String userInput){
        // 3자리인지, 중복이 없는지, 1-9 사이의 값이 맞는지
        if (userInput.length() != 3){
            return true;
        }
        for (int i = 0; i < 3; i++){
            if (!Character.isDigit(userInput.charAt(i))){
                return true;
            }
        }
        if (userInput.charAt(0) == userInput.charAt(1) || userInput.charAt(1) == userInput.charAt(2) || userInput.charAt(0) == userInput.charAt(2)){
            return true;
        }
        return false;
    }
}
