package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;


public class Application {

    private static List<Integer> computer = new ArrayList<>();
    private static Integer inputNumber;
    private static List<Integer> inputNumberList = new ArrayList<>();
    private static int ball=0;
    private static int strike=0;
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

    private static void input() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Integer.valueOf(Console.readLine());

        countBall();
    }

    private static void countBall() {
        String inputNumberString = Integer.toString(inputNumber);
        inputNumberList.clear();

       for (int i=0;i<inputNumberString.length();i++){
           inputNumberList.add(Integer.valueOf(inputNumberString.charAt(i)-'0'));
       }

       ball = 0;
       for (Integer element:inputNumberList){
           if (computer.contains(element) && computer.indexOf(element)!=inputNumberList.indexOf(element)){
               ball++;
           }
       }


       if (ball!=0) System.out.print(ball+"볼");

       countStrike();
    }

    private static void countStrike() {

        strike = 0;
        for (Integer element:inputNumberList){
            if (computer.contains(element) && computer.indexOf(element)==inputNumberList.indexOf(element)){
                strike++;
            }
        }

        if (strike!=0) System.out.println(" "+strike+"스트라이크");
        if (ball==0 && strike==0) System.out.println("낫싱");
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
        pickRandomNumber();
        do {

            input();

            if (strike==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int userInput = Integer.valueOf(Console.readLine());
                if (userInput==1) {
                    pickRandomNumber();
                    strike = 0;
                }
            }
        } while (strike!=3);


    }
}
