package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean regameFlag;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do { // depth = 1 -> 이제 do 내부에서 for, while, if 등은 1개까지 더 구현가능
            List<Integer> computerNumberList = computerChoiceNumbers();
            playGame(computerNumberList);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int regameNumber = getRegameNum();
            regameFlag = regameOrNot(regameNumber);
        } while (regameFlag);
    }

    public static List<Integer> computerChoiceNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int order =0;
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(order++,randomNumber);
            }
        }
        return computer;
    }
}
