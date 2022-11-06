package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(createAnswer());
        userInput();
    }

    // 정답을 생성하는 함수: 정답은 1~9까지 서로 다른 수로 이루어진 3자리의 수이다.
    public static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    // 사용자가 입력한 정답을 반환하는 함수, 입력은 서로 다른 3자리 수여야 한다.
    public static List<Integer> userInput() throws IllegalArgumentException {
        List<Integer> answer = new ArrayList<>();
        String consoleInput = Console.readLine();
        if (consoleInput.length() != 3){
            throw new IllegalArgumentException("입력이 3자리 수가 아닙니다.");
        }
        for(int i = 0; i < consoleInput.length(); i++) {
            int charInt = Character.getNumericValue(consoleInput.charAt(i));
            if (!answer.contains(charInt)){
                answer.add(charInt);
            } else {
                throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
            }
        }

        return answer;
    }
}
