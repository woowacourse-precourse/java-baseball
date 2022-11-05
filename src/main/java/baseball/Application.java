package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Application {

    private static List<Integer> computer = new ArrayList<>();
    private static Integer inputNumber;
    private static int ball;
    private static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void pickRandomNumber() {
        while (computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    private static void input() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Integer.valueOf(Console.readLine());
        countBall();
    }

    private static void countBall() {
        String inputNumberString = Integer.toString(inputNumber);
        List<Integer> inputNumberList = new ArrayList<>();
        // 입력 숫자 배열 변환
       for (int i=0;i<inputNumberString.length();i++){
           inputNumberList.add(Integer.valueOf(inputNumberString.charAt(i)-'0'));
       }

       ball = 0;
       for (Integer element:inputNumberList){
           if (computer.contains(element) && computer.indexOf(element)!=inputNumberList.indexOf(element)){
               ball++;
           }
       }


       if (ball!=0) System.out.println(ball+"볼");
       if (ball==3) return;

    }





    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
        pickRandomNumber();
        input();
    }
}
