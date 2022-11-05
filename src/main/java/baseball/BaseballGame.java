package baseball;

import Util.RamdomNumber;
import java.util.Scanner;

public class BaseballGame {
    int[] answer;
    Hint hint;
    User user;
    RamdomNumber randomNumber;
    Scanner scanner = new Scanner(System.in);
    BaseballGame(){
        this.hint = new Hint();
        this.answer = new int[3];
        this.user = new User();
        this.randomNumber = new RamdomNumber(3);
    }

    public void startGame(){
        answer = randomNumber.makeRandomNumber(3);
        do {
            user.UserInput();
            hint.getHint(user.getUserNumber(), answer);
        } while (hint.strike != 3);
    }
    public boolean restartGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return continueGame();
    }

    private boolean continueGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = scanner.nextInt();
        if (input == 1){
            return true;
        }
        return false;
    }
}
