package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> createComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber))
                computerNum.add(randomNumber);
        }
        return computerNum;
    }

    public void startGame() {
        List<Integer> computerNum = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = createComputerNum();
    }

    public static void main(String[] args) {
    }
}
