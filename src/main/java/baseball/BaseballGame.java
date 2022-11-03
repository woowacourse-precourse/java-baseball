package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다";
    private static final String GET_NUMBER = "숫자를 입력해주세요 : ";

    private List<Integer> computer;
    private List<Integer> user;

    public BaseballGame() {
    }

    public void run() {
        System.out.println(GAME_START);
        makeRandomNumber();

        System.out.print(GET_NUMBER);
        getUserNumber();
    }

    private void makeRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void getUserNumber() {
        String input = Console.readLine();
        user = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (i == 3) {
                throw new IllegalArgumentException();
            }

            char c = input.charAt(i);
            int number = Character.getNumericValue(c);
            if (!isValidateNumber(number)) {
                throw new IllegalArgumentException();
            }
            user.add(number);
        }
    }

    private boolean isValidateNumber(int number) {
        return number != 0 & !user.contains(number);
    }


}
