package baseball;

import camp.nextstep.edu.missionutils.Console;

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
        System.out.println(computerNumber);
        do {
            strike=0;
            ball=0;
            userNumber = user.getUserNumber();
            calGame();

        } while (strike!=3);
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
        String strComputerNumber="";
        String strUserNumber="";
        for(int a:computerNumber){
            strComputerNumber+=Integer.toString(a);
        }
        for(int a:userNumber){
            strUserNumber+=Integer.toString(a);
        }

        for (int i = 0; i < 3; i++) {
            if(strUserNumber.charAt(i)==strComputerNumber.charAt(i)) strike++;
            else if(strUserNumber.contains(strComputerNumber.substring(i,i+1))) ball++;
        }

        if (ball > 0) {
            if (strike > 0) {
                System.out.print(ball + "볼");
                System.out.println(" " + strike + "스트라이크");
            } else {
                System.out.println(ball + "볼");
            }
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else{
            System.out.println("낫싱");
        }

        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean gameContinue() {
      return true;
    }
}
