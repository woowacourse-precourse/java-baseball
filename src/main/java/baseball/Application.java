package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> computerRandomNumber = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            if (computerRandomNumber.size() == 0) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                computerRandomNumber = makeRandomNumber();
            }
            System.out.print("숫자를 입력해주세요 : ");
            readLine();
        }
    }

    static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
