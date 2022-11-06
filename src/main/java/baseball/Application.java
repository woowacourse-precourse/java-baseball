package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void numBaseball(List<Integer> computerNum) {

    }

    public static int comparator(List<Integer> computerNum, List<Integer> userNum) {
        return 0;
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