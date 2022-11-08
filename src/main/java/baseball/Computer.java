package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> computerNumber = new ArrayList<>();
    private String restartNumber = "1";

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public String getRestartNumber() {
        return restartNumber;
    }

    public void requestInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    protected void restarter() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    protected void restartOrNot() {
        restartNumber = Console.readLine();
    }

    protected void createAnswerNumber() {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addRandomNumber(randomNumber);
        }
    }

    private void addRandomNumber(int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }
}
