package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    public static int strike;
    public static int ball;
    public static List<Integer> comNum;
    public static List<Integer> userNumers;

    public void playGame(){
        System.out.println("숫자를 입력해주세요 : ");
        Computer.createGameNumber();
        User.inputGameNumber();
        User.validateUserNum();
        ballCount();
        hintPrint();
    }

    public static void ballCount(){
        strike = 0;
        ball = 0;
        for(int i = 0; i < userNumers.size(); i++) {
            //스트라이크 카운트
            if (comNum.indexOf(userNumers.get(i)) == i) {
                strike++;
                continue;
            }
            //볼 카운트
            if (comNum.contains(userNumers.get(i))) {
                ball++;
            }
        }
    }

    public static String hintPrint(){
        if(ball != 0 && strike != 0){
            return (ball + "볼 " + strike + "스트라이크");
        }
        if(ball ==0 && strike != 0){
            return(strike + "스트라이크");
        }
        if(ball != 0 && strike ==0){
            return (ball + "볼");
        }
        return ("낫싱");
    }

    public static boolean gameEnd() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            if (response.equals("1")) {
                Computer.createGameNumber();
                return true;
            }
            if (response.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
        return true;
    }
}
