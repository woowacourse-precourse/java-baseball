package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Application {

    private static List<Integer> computer = new ArrayList<>();
    private static String inputNumber;
    private static List<Integer> inputNumberList = new ArrayList<>();
    private static int ball=0;
    private static int strike=0;
    private static int exceptionIsThrown=0;
    private static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void pickRandomNumber() {
        computer.clear();
        while (computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    private static void input() {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = String.valueOf(Console.readLine());
        inputNumberList.clear();

        for (int i=0;i<inputNumber.length();i++){
            inputNumberList.add(Integer.valueOf(inputNumber.charAt(i)-'0'));
        }

        Set<Integer> set = new HashSet<>(inputNumberList);
        if (inputNumberList.size()!=3 || inputNumberList.contains(0) || inputNumberList.size()!=set.size()) {
            exceptionIsThrown = 1;
            throw new IllegalArgumentException();
        }



        countBall();
    }

    private static void countBall() {

       ball = 0;
       for (Integer element:inputNumberList){
           if (computer.contains(element) && computer.indexOf(element)!=inputNumberList.indexOf(element)){
               ball++;
           }
       }

       if (ball!=0) System.out.print(ball+"볼 ");

       countStrike();
    }

    private static void countStrike() {

        strike = 0;
        for (Integer element:inputNumberList){
            if (computer.contains(element) && computer.indexOf(element)==inputNumberList.indexOf(element)){
                strike++;
            }
        }

        if (strike!=0) System.out.println(strike+"스트라이크");
        if (ball==0 && strike==0) System.out.println("낫싱");
    }



    public static void main(String[] args) {

        start();
        pickRandomNumber();

        do {
            input();

            if (strike==3 && exceptionIsThrown == 0) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                checkRestart();
            }
            if (strike!=3 && exceptionIsThrown == 1) {
                System.out.println("게임 종료");
                checkRestart();
            }

        } while (strike!=3);


    }

    private static void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userinput = Integer.valueOf(Console.readLine());
        if (userinput==1) {
            pickRandomNumber();
            strike = 0;
            exceptionIsThrown = 0;
        }

        if (userinput<=0 || userinput>=3){
            exceptionIsThrown = 1;
            throw new IllegalArgumentException();
        }
    }
}
