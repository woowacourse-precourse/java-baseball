package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void numBaseball(List<Integer> computerNum) {
        List<Integer> userNum = new ArrayList<>();
        System.out.print("숫자를 입력하세요 : ");
        char[] nums = Console.readLine().toCharArray();

        for (int num : nums) {
            userNum.add(Character.getNumericValue(num));
        }

        if (comparator(computerNum, userNum)) { return; }
        numBaseball(computerNum);
    }

    public static boolean comparator(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;
        for (int idx = 0; idx < 3; idx++){
            if (computerNum.get(idx) == userNum.get(idx))       { strike += 1; }
            else if (userNum.contains(computerNum.get(idx)))    { ball += 1;   }
        }

        if (strike == 3)  { System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료"); return true; }
        else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 && strike != 0) {
            System.out.println((char)ball + "볼 "+ (char)strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println((char)ball + "볼");
        } else if (ball == 0 && strike != 0) {
            System.out.println((char)strike + "스트리이크");
        }
        return false;
    }


    public static List<Integer> opponentNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }


    public static void main(String[] args) {
        int choice = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(choice == 1) {
            numBaseball(opponentNum());
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = Integer.parseInt(Console.readLine());
        }
    }
}