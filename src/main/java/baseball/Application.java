package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;



public class Application {
   static int strike = 0;
   static int ball = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameProceed = true;
        boolean b = true;
        System.out.println("숫자야구게임을 시작합니다.");
        while(gameProceed){
            int[] answer = makeAnswer();
            while(b){
                System.out.print("숫자를 입력해주세요 : ");
                String number = Console.readLine();
                inputException(number);
                int num = Integer.parseInt(number);
                int[] input = new int[3];
                input[0] = num/100;
                input[1] = (num - input[0]*100)/10;
                input[2] = (num - input[0]*100 - input[1]*10);

                int[] score = new int[2];   // 첫번째 방에 strike, 두번째방에 ball

                score = checkBallStrike(answer, input);
                b = checkEndGame(score[1], score[0]);
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

    private static  boolean checkEndGame(int ball, int strike) {
        if(strike == 3){
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        else {
            if(ball > 0)
                System.out.print(ball + "볼 ");
            if(strike > 0)
                System.out.print(strike + "스트라이크");
            if(strike == 0 && ball == 0)
                System.out.print("낫싱");

            System.out.println();
            return true;
        }
    }


    private static int[] checkBallStrike(int[] answer, int input[]) {
        int[] score = new int[2];
        if(answer[0] == input[0])
            score[0]++;
        else if (answer[0] == input[1] || answer[0] == input[2])
            score[1]++;
        if(answer[1] == input[1])
            score[0]++;
        else if (answer[1] == input[0] || answer[1] == input[2])
            score[1]++;
        if(answer[2] == input[2])
            score[0]++;
        else if (answer[2] == input[0] || answer[2] == input[1])
            score[1]++;

        return score;
    }

   private static void inputException(String number) {
        if(number != null && !number.matches("-?\\d+"))
            throw new IllegalArgumentException("숫자 입력 오류");
        else if(number.length() != 3)
            throw new IllegalArgumentException("숫자 입력 오류");
    }
    private static int[] makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        int[] answer = new int[computer.size()];
        for(int i = 0 ; i < computer.size(); i++) {
            answer[i] = computer.get(i);
        }
        return answer;
    }
}
