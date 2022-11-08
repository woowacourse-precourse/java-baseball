package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            List<Integer> resultNumber = makeRandomNumber();
            while (true) {
                String inputStringNumber = Console.readLine();
                List<Integer> inputNumber = makeStringNumberToList(inputStringNumber);
                boolean findNumber = calculationNumber(resultNumber, inputNumber);
                if (findNumber) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            boolean isFinish = checkUserFinishGame();
            if (isFinish) break;
        }
    }

    private static boolean checkUserFinishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString= Console.readLine();
        if(inputString.equals("1")) {
            System.out.println("게임을 새로 시작하겠습니다.");
            return false;
        }
        return true;
    }

    public static boolean calculationNumber(List<Integer> resultNumber ,List<Integer> inputNumber) {
        int strike = countStrike(resultNumber, inputNumber);
        int ball = countBall(resultNumber, inputNumber);
        printResult(strike, ball);
        if(strike == 3){
            return true;
        }
        return false;
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
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
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
