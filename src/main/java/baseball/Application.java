package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    // 게임 시작
    public static void gameStart() {
        int[] computerNumbers = getRandomNumbers();
        int[] userNumbers = getUserNumbers();
        compareNumbers(computerNumbers, userNumbers);
    }

    // 랜덤한 숫자 3개 고르기
    public static int[] getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computer.stream().mapToInt(i -> i).toArray();
    }

    // 숫자 3개 입력 받기
    public static int[] getUserNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = new java.util.Scanner(System.in).nextLine();

        // 숫자인지 확인
        if (userInput.matches("^[1-9]*$")) {
            System.out.println("숫자가 아닙니다.");
            return getUserNumbers();
        }

        // 숫자가 3개인지 확인
        if (userInput.length() != 3) {
            System.out.println("3자리 숫자가 아닙니다.");
            return getUserNumbers();
        }

        // 숫자 input 을 int[] 로 변환
        int[] userNumbers = new int[3];
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers[i] = userInput.charAt(i) - '0';
        }

        // 숫자가 중복된 건 없는지 확인
        if (userNumbers[0] == userNumbers[1] || userNumbers[0] == userNumbers[2] || userNumbers[1] == userNumbers[2]) {
            System.out.println("중복된 숫자가 있습니다.");
            return getUserNumbers();
        }

        return userNumbers;
    }
}
