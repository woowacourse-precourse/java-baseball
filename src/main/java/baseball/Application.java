package baseball;

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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = generateRandomNumberString();
    }
}
