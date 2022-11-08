package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> resultNumber = makeRandomNumber();
        String inputStringNumber = Console.readLine();
        calculationNumber(resultNumber, inputStringNumber);


    }

    public static boolean calculationNumber(List<Integer> resultNumber ,String inputStringNumber){
        List<Integer> inputNumber = makeStringNumberToList(inputStringNumber);
        int strike = countStrike(resultNumber, inputNumber);
        int ball = countBall(resultNumber, inputNumber);
        printResult(strike, ball);
        if(strike == 3){
            return false;
        }
        return true;
    }

    private static int countBall(List<Integer> resultNumber, List<Integer> inputNumber) {
        int ball = 0;
        for(int i =0; i<3; i++){
            int curNumber = resultNumber.get(i);
            if(inputNumber.contains(curNumber) && resultNumber.get(i) != inputNumber.get(i)){
                ball++;
            }
        }
        return ball;
    }

    private static List<Integer> makeStringNumberToList(String inputStringNumber) {
        List<Integer> inputNumber = new ArrayList<>();
        for(int i=0; i<inputStringNumber.length(); i++){
            int number = inputStringNumber.charAt(i) - '0';
            inputNumber.add(number);
        }
        return inputNumber;
    }

    private static void printResult(int strike, int ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }else if(strike == 0){
            System.out.println(ball + "볼");
        }else if(ball == 0){
            System.out.println(strike + "스트라이크");
        }else{
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }

    private static int countStrike(List<Integer> resultNumber, List<Integer> inputNumber) {
        int countStrike = 0;
        for (int i = 0; i < 3; i++) {
            if(resultNumber.get(i) == inputNumber.get(i)){
                countStrike++;
            }
        }
        return countStrike;
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
