package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static List<Integer> generateRandomNumber() {
        List<Integer> generatedNumber = new ArrayList<>();
        // 0~9 사이의 숫자를 이용하여 3자리의 랜덤숫자 생성
        while (generatedNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumber.contains(randomNumber)) {
                generatedNumber.add(randomNumber);
            }
        }
        return generatedNumber;
    }

    public static List<Integer> checkStrike(List<Integer> generatedNumber, List<Integer> userNumber) {
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>();
        // 스트라이크의 index를 구하여 리스트로 반환
        for (int listIndex = 0; listIndex < 3; listIndex++) {
            if (standardNumber.get(listIndex).equals(inputNumber.get(listIndex))) {
                strikeIndex.add(listIndex);
            }
        }
        return strikeIndex;
    }

    public static int checkBall(List<Integer> generatedNumber, List<Integer> userNumber, List<Integer> indexOfStrike) {
        List<Integer> standardNumber = new ArrayList<>(generatedNumber);
        List<Integer> inputNumber = new ArrayList<>(userNumber);
        List<Integer> strikeIndex = new ArrayList<>(indexOfStrike);
        int count = 0;
        // 사용자가 입력한 각 자리수가 랜덤숫자에 포함되어 있는지 확인하여 볼의 개수를 int로 반환
        for (int listIndex = 0; listIndex < 3; listIndex++) {
            // 단순히 랜덤숫자 내에 포함되어 있는지 확인하여 count 값에 추가 (볼 + 스트라이크)
            if (standardNumber.contains(inputNumber.get(listIndex))) {
                count += 1;
            }
            // 스트라이크인 경우, count 값에서 제거 ((볼 + 스트라이크) - 스트라이크)
            if (strikeIndex.contains(listIndex)) {
                count -= 1;
            }
        }
        return count;
    }

    public static List<Integer> stringToList(String input) {
        int integerInput = Integer.parseInt(input);
        List<Integer> listInput = new ArrayList<>();
        while (integerInput > 0) {
            listInput.add(integerInput % 10);
            integerInput /= 10;
        }
        Collections.reverse(listInput);

        return listInput;
    }

    public static void runBaseballGame() throws IllegalArgumentException {
        List<Integer> standardNumber = new ArrayList<>(generateRandomNumber());
        int strikeCount = 0;
        int ballCount;

        while (strikeCount != 3) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userString = Console.readLine();

            // 사용자가 입력한 숫자가 3자리가 아닌 경우 Exception 발생
            if (userString.length() != 3) {
                throw new IllegalArgumentException("3자리 숫자 입력이 필요합니다");
            }

            List<Integer> userNumber = stringToList(userString);
            Set<Integer> checkDuplication = new HashSet<>(userNumber);

            // 사용자가 입력한 숫자 중 중복되는 숫자가 있는 경우 Exception 발생
            if (userNumber.size() != checkDuplication.size()) {
                throw new IllegalArgumentException("중복되지 않는 3자리 숫자 입력이 필요합니다");
            }

            // 사용자가 입력한 숫자 중 0이 포함되는 경우 Exception 발생
            if (userNumber.contains(0)) {
                throw new IllegalArgumentException("0을 포함하지 않는 숫자 입력이 필요합니다");
            }

            List<Integer> strikeIndex = checkStrike(standardNumber, userNumber);
            strikeCount = strikeIndex.size();
            ballCount = checkBall(standardNumber, userNumber, strikeIndex);

            // 0스트라이크 0볼인 경우 낫싱 출력
            if ((strikeCount == 0) && (ballCount == 0)) {
                System.out.println("낫싱");
                continue;
            }

            // 3스트라이크인 경우 게임 종료
            if (strikeCount == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하시려면 2를 입력하세요.");
                break;
            }

            // 출력할 문구 생성 : #볼 #스트라이크
            String ballCountString = "";
            if (ballCount > 0) {
                ballCountString = ballCount + "볼 ";
            }

            String strikeCountString = "";
            if (strikeCount > 0) {
                strikeCountString = strikeCount + "스트라이크";
            }

            System.out.println(ballCountString + strikeCountString);
        }
    }

    public static void main(String[] args) {
        int gameStatus = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameStatus == 1) {
            runBaseballGame();
            String userStatus = Console.readLine();
            // 게임 종료 후 사용자의 입력값을 받아 새로 시작 혹은 게임 종료
            gameStatus = Integer.parseInt(userStatus);

            // 게임이 종료되었을 때, 입력값이 1 또는 2가 아닌 경우 Exception 발생
            if ((gameStatus != 1) && (gameStatus != 2)) {
                throw new IllegalArgumentException("1또는 2를 입력하여야 합니다");
            }
        }
    }
}
