package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        Application main = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean again = true;
        boolean inGame = true;

        List<Integer> computerRanNumList = null;

        while (again) {
            if (inGame) {
                inGame = false;
                computerRanNumList = main.computerNumberList();
//                System.out.println("computer" + computerRanNumList);
            }
        }
    }
    public int randomPickNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
    public boolean uniqueNumber(int computerRanNum, List<Integer> computerRanNumList) {
        if (computerRanNumList.contains((computerRanNum))) {
            return false;
        }
        return true;
    }
    public List<Integer> computerNumberList() {
        List<Integer> computerRanNumList = new ArrayList<>();
        while (computerRanNumList.size() < 3) {
            checkToInput(randomPickNumber(), computerRanNumList);
        }
        return computerRanNumList;
    }
    private void checkToInput(int computerRanNum, List<Integer> computerRanNumList) {
        if (uniqueNumber(computerRanNum, computerRanNumList)) {
            computerRanNumList.add(computerRanNum);
        }
    }

}