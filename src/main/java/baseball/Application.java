package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isLength() {

    }

    public static boolean isDiff() {

    }

    public static boolean isRange() {

    }

    public static boolean isValid() {

    }

    public static List<Integer> computerPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userPick() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
    }

    public static void compare(List<Integer> computerNum, List<Integer> userNum) {

    }

    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
        List<Integer> computerNum = computerPick();
        List<Integer> userNum = userPick();
        compare(computerNum, userNum);
    }

    public static void main(String[] args) {
        playGame();
    }
}
