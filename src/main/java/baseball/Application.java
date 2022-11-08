package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;


public class Application {
    static int[] input = new int[3];
    static int[] answer = new int[3];
    static int ball = 0;
    static int strike = 0;
    static boolean gameProceed = true;
    static boolean b = true;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자야구게임을 시작합니다.");
        while(gameProceed){
            makeAnswer();
            while(b){
                System.out.print("숫자를 입력해주세요 : ");
                String number = Console.readLine();
                int num = inputException(number);
                input[0] = num/100;
                input[0] = (num - input[0]*100)/10;
                input[0] = (num - input[0]*100 - input[1]*10);

                ball = 0;
                strike = 0;

                checkBallStrike();
                checkEndGame();
            }

            if(newGame())
                b = true;
            else gameProceed = false;
        }

    }

    private static boolean newGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String s = Console.readLine();
        newGameException(s);
        return Integer.parseInt(s) == 1;
    }

    private static void newGameException(String s) {
        if(s != null && !s.matches("-?\\d+"))
            throw new IllegalArgumentException("숫자 입력 오류");
        int n = Integer.parseInt(s);
        if(n < 1 && n > 2)
            throw new IllegalArgumentException("숫자 입력 오류");
    }

    private static void checkEndGame() {
        if(strike == 3){
            System.out.println(strike + "3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            b = false;
        }
        else {
            if(ball > 0)
                System.out.print(ball + "볼 ");
            if(strike > 0)
                System.out.print(strike + "스트라이크");
            if(strike == 0 && ball == 0)
                System.out.print("낫싱");

            System.out.println();
        }
    }


    private static void checkBallStrike() {
        if(answer[0] == input[0])
            strike++;
        else if (answer[0] == input[1] || answer[0] == input[2])
            ball++;
        if(answer[1] == input[1])
            strike++;
        else if (answer[1] == input[0] || answer[1] == input[2])
            ball++;
        if(answer[2] == input[2])
            strike++;
        else if (answer[2] == input[0] || answer[2] == input[1])
            ball++;
    }

    private static int inputException(String number) {
        if(number != null && !number.matches("-?\\d+"))
            throw new IllegalArgumentException("숫자 입력 오류");
        if(number.length() != 3)
            throw new IllegalArgumentException("숫자 입력 오류");
        return Integer.parseInt(number);
    }
    private static void makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
    }
}
