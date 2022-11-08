package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumber = makeRandomNum();

        boolean gameContinue = true;

        while (gameContinue) {

            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            checkUserInput(userInput);
            List<Integer> userNumber = convertInput(userInput);
        }

    }

    // 랜덤 숫자 만들기
    public List<Integer> makeRandomNum() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public void checkUserInput(String user) {

        if (user.length() != 3) throw new IllegalArgumentException("3자리 이상을 입력하였습니다.");

        if (isNotNumber(user)) throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력하였습니다.");

        if (isDuplicateNum(user)) throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");

    }

    public boolean isNotNumber(String input) {

        String numberString = "123456789";

        for (int i = 0; i < 3; i++) {

            if (numberString.contains(input.substring(i,i+1))) continue;

            return true;
        }

        return false;
    }

    public boolean isDuplicateNum(String input) {

        char[] numberArray = {'1','2','3','4','5','6','7','8','9'};

        for (char num : numberArray) {

            if (countNum(input, num) > 1) return true;
        }

        return false;
    }

    public int countNum(String input, char num) {

        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == num) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> convertInput(String userInput) {

        List<Integer> newInput = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            newInput.add(userInput.charAt(i) - '0');
        }

        return newInput;
    }

}
