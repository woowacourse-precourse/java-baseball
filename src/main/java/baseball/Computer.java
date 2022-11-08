package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> resultNumber;


    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        resultNumber = makeRandomNumber();
    }

    private static List<Integer> makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public void startGame() {
        while (true) {
            List<Integer> inputNumber = makeStringNumberToList(getInputNumber());
            boolean findNumber = calculationNumber(resultNumber, inputNumber);
            if (findNumber) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private String getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputStringNumber = Console.readLine();
        return inputStringNumber;
    }

    public static boolean calculationNumber(List<Integer> resultNumber ,List<Integer> inputNumber) {
        int strike = countStrike(resultNumber, inputNumber);
        int ball = countBall(resultNumber, inputNumber);
        printResult(strike, ball);
        return isAnswer(strike);
    }

    private static boolean isAnswer(int strike) {
        if(strike == 3){
            return true;
        }
        return false;
    }

    private static List<Integer> makeStringNumberToList(String inputStringNumber) throws IllegalArgumentException {

        List<Integer> inputNumber = new ArrayList<>();
        if(inputStringNumber.length() != 3) throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");

        for (int i = 0; i < inputStringNumber.length(); i++) {
            int number = inputStringNumber.charAt(i) - '0';
            if(number == 0) throw new IllegalArgumentException("숫자의 범위는 1-9 입니다.");
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


    public boolean checkFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString= Console.readLine();
        if(inputString.equals("1")) {
            System.out.println("게임을 새로 시작하겠습니다.");
            return false;
        }
        return true;
    }
}
