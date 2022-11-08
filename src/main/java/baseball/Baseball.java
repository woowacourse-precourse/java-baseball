package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Baseball {

    private List<Integer> computer;
    private List<Integer> user;
    private String input;
    private GameInfo gameInfo;

    public Baseball() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
        input = "";
        gameInfo = new GameInfo();
    }

    private void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void getRandomNumbers() {
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    private boolean isValidNumber() {
        if (input.length() != 3) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
    }

    public void gameStart() throws Exception {
        printInit();
        getRandomNumbers();
        readNumbers();
        if (!isValidNumber()) {
            throw new IllegalArgumentException("");
        }
    }


}
