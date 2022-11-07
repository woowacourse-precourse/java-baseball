package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    /**
     * 컴퓨터가 생성한 수 반환
     *
     * @return 1부터 9까지 서로 다른 임의의 수 3개로 된 String
     */
    public static String generateRandomNumberString() {
        List<Integer> usedNumber = new ArrayList<>();
        StringBuilder generatedNumber = new StringBuilder();

        while (usedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!usedNumber.contains(randomNumber)) {
                usedNumber.add(randomNumber);
                generatedNumber.append(randomNumber);
            }
        }
        return generatedNumber.toString();
    }

    /**
     * 플레이어로부터 서로 다른 3개의 숫자를 입력받아 반환
     *
     * @return 플레이어가 입력한 3자리 숫자로 된 String
     * @throws IllegalArgumentException 3자리가 아닌 경우, 1~9까지의 숫자가 아닌 경우, 중복되는 숫자가 존재하는 경우
     */
    public static String getGuessNumberInput() throws IllegalArgumentException {
        String inputNumber;
        List<Character> usedNumber = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputNumber.length(); i++) {
            char ch = inputNumber.charAt(i);

            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException();
            }
            if (usedNumber.contains(ch)) {
                throw new IllegalArgumentException();
            }

            usedNumber.add(ch);
        }

        return inputNumber;
    }

    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = generateRandomNumberString();
        String guessNumberString = getGuessNumberInput();
    }
}
