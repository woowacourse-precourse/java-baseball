package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private User user;
    private Computer computer;

    private int strike;
    private int ball;
    private List<Integer> computerNumber;
    private List<Integer> userNumber;

    public void gameStart() {
        initGame();
        computerNumber = computer.getComputerNumber();

        do {
            userNumber = user.getUserNumber();
            calGame();

        } while (true);
    }

    public void initGame() {
        user = new User();
        computer = new Computer();

        strike = 0;
        ball = 0;
        computerNumber = new ArrayList<>();
        userNumber = new ArrayList<>();
    }

    public void calGame() {
        for (int i = 0; i < 3; i++) {
            int index = computerNumber.indexOf(i);
            if (index == userNumber.indexOf(i)) strike++;
            else if (userNumber.contains(index)) ball++;
        }

        if (ball > 0) {
            System.out.print(ball + "볼");
            if (strike > 0) {
                System.out.println(" " + strike + "스트라이크");
            }
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else{
            System.out.println("낫싱");
        }

        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameContinue();
        }
    }

    public boolean gameContinue() {
        return true;
    }
}
