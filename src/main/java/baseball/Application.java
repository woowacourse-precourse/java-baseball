package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        List<Integer> randomNumberByComputer;
        List<Integer> randomNumberByUser;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            randomNumberByComputer = generateRandomNumber();
            System.out.print("숫자를 입력해주세요 : ");
            randomNumberByUser = inputNumberByUser();

            if (checkException(randomNumberByUser)) {
                exitGame();
            }

            Boolean isSameNumber = compareComputerAndUserNums(randomNumberByUser, randomNumberByComputer);
            if(!isSameNumber){
                continue;
            }
        }

    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> inputNumberByUser() {
        List<Integer> inputNumber = new ArrayList<>();
        String num = Console.readLine();

        for (int i = 0; i < num.length(); i++) {
            inputNumber.add((int) num.charAt(i));
        }
        return inputNumber;
    }

    private static Boolean checkException(List<Integer> inputNum) {
        if (inputNum.size() != 3) {
            return true;
        }
        Set<Integer> numSet = new HashSet<>(inputNum);
        if (inputNum.size() != numSet.size()) {
            return true;
        }
        for (int n : inputNum) {
            if (n < 1 || n > 9) {
                return true;
            }
        }
        return false;
    }

    private static void exitGame() {
        throw new IllegalArgumentException();
    }

    private static Boolean compareComputerAndUserNums(List<Integer> randomNumberByUser,
        List<Integer> randomNumberByComputer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumberByComputer.get(i) == randomNumberByUser.get(i)) {
                strike += 1;
            } else if(randomNumberByComputer.contains(randomNumberByUser.get(i))){
                ball += 1;
            }

        }
        if (strike == 0 && ball ==0){
            System.out.println("낫싱");
        } else if(ball == 0){
            System.out.println(strike + "스트라이크");
        } else if(strike == 0){
            System.out.println(ball + "스트라이크");
        } else{
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if(strike == 3){
            return true;
        }
        return false;
    }

}
