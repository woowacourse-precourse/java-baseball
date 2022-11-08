package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // generateNum
    public static final int SIZE = 3;
    public static final int MIN_NUM = 3;
    public static final int MAX_NUM = 3;

    List<Integer> computerNumber;

    public int getComputerNumberSize(){
        return computerNumber.size();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumber = Game.generateNumber();
    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void playGame() {
        while(true) {
            List<Integer> numberInput = makeStringInputToNumberList(getInput());
            boolean correctNumber = checkStrikeBallCount(computerNumber, numberInput);
            if(correctNumber) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String stringInput = Console.readLine().trim();
        return stringInput;
    }

    public static List<Integer> makeStringInputToNumberList(String stringInput){

        List<Integer> numberInput = new ArrayList<>();
        if(stringInput.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리 숫자여야 합니다.");
        }

        for (int i = 0; i < stringInput.length(); i++) {
            int number = stringInput.charAt(i) - '0';
            if(number == 0) {
                throw new IllegalArgumentException("숫자의 범위는 1-9 입니다.");
            }
            numberInput.add(number);
        }
        return numberInput;
    }

    public static boolean checkStrikeBallCount(List<Integer> numberInput, List<Integer> computerNumber) {
        int strike = countStrike(numberInput, computerNumber);
        int ball = countBall(numberInput, computerNumber);
        printResult(strike, ball);
        return isCorrect(strike);
    }

    public static boolean isCorrect(int strike) {
        if(strike == 3) {
            return true;
        }
        return false;
    }

    public static int countStrike(List<Integer> numberInput, List<Integer> computerNumber) {
        int countStrike = 0;
        for(int i=0; i<3; i++) {
            if(numberInput.get(i) == computerNumber.get(i)) {
                countStrike++;
            }
        }
        return countStrike;
    }

    public static int countBall(List<Integer> numberInput, List<Integer> computerNumber) {
        int countBall = 0;
        for(int i =0; i<3; i++){
            int curNumber = computerNumber.get(i);
            if(numberInput.contains(curNumber) && computerNumber.get(i) != numberInput.get(i)){
                countBall++;
            }
        }
        return countBall;
    }

    public static void printResult(int strike, int ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if(strike == 0){
            System.out.println(ball + "볼");
        } else if(ball == 0){
            System.out.println(strike + "스트라이크");
        }
        if (strike != 0 && ball != 0){
            System.out.println(ball + "볼 " + strike + "스트라이크 ");
        }
    }

    public boolean checkFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString= Console.readLine();
        checkFinishIfNumber(inputString);
        if(inputString.equals("1")) {
            System.out.println("게임을 새로 시작하겠습니다.");
            return false;
        }
        return true;
    }

    private void checkFinishIfNumber(String inputString) {
        if(!inputString.equals("1") && !inputString.equals("2")){
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
