package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> randomNum;

    public void gameStart() {
        System.out.println("숫자를 입력해 주세요 : ");
        String input = readLine();

        validateInGame(input);
        newRandomNumber();
    }

    public void validateInGame(String input) {

    }

    public void newRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        randomNum = computer;
    }

}
