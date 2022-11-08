package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playNumBaseball(getComputerNum());
    }

    public static List<Integer> getComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    public static List<Integer> getUserNum() throws IllegalArgumentException {
        List<Integer> userNum = new ArrayList<>();
        System.out.print("숫자를 입력하세요 : ");
        char[] nums = Console.readLine().toCharArray();

        if (nums.length > 3 || nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
            throw new IllegalArgumentException("예외 발생. 게임을 종료합니다.");
        }

        for (int num : nums) {
            userNum.add(Character.getNumericValue(num));
        }
        return userNum;
    }


    public static void playNumBaseball(List<Integer> computerNum){
        List<Integer> userNum = getUserNum();
        if (compareNums(computerNum, userNum)) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (Integer.parseInt(Console.readLine()) == 1) {
                playNumBaseball(getComputerNum());
            }
            return;
        }
        playNumBaseball(computerNum);
    }

    public static boolean compareNums(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < 3; idx++) {
            if (userNum.get(idx) == computerNum.get(idx)) {
                strike += 1;
            }
            else if (userNum.contains(computerNum.get(idx))) {
                ball += 1;
            }
        }

        if (strike == 3) {
            printResult(ball, strike);
            return true;
        }
        printResult(ball, strike);
        return false;
    }

    static void printResult(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        else if (ball != 0 && strike != 0) {
            System.out.println(String.valueOf(ball) + "볼 " + String.valueOf(strike) + "스트라이크");
        }
        else if (ball != 0 && strike == 0) {
            System.out.println(String.valueOf(ball) + "볼");
        }
        else if (ball == 0 && strike != 0) {
            System.out.println(String.valueOf(strike) + "스트라이크");
        }
    }
}