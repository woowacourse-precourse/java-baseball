package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * 게임을 시작 할 때 생성하는 랜덤 넘버 3개 (이때 각 숫자는 중복이 없다)
     *
     * @return 랜덤으로 생성된 숫자를 가지는 List
     */
    public static List<Integer> generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);

            if (randomNumbers.contains(randomValue)) continue;

            randomNumbers.add(randomValue);
        }

        return randomNumbers;
    }


    /**
     * "숫자를 입력해주세요"를 출력하고 사용자의 입력을 받는 함수
     *
     * @return 사용자의 입력 문자열
     */
    public static String receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 사용자가 입력한 문자열을 Integer List로 변환하는 함수
     *
     * @param userInput 사용자의 입력 문자열
     * @return 변환된 IntegerList
     */
    public static List<Integer> userInputStrToIntegerList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char singleCh = userInput.charAt(i);

            int numericValue = Character.getNumericValue(singleCh);
            userInputList.add(numericValue);
        }

        return userInputList;
    }

    /**
     * 사용자가 입력한 문자열이 오직 숫자 3개인지 확인하는 함수
     *
     * @param userInput 사용자가 입력한 문자열
     * @return 숫자 3개인지 여부
     */
    public static boolean checkUserInput(String userInput) {
        return userInput.matches("\\d\\d\\d");
    }

    public static void game() {
        List<Integer> randomNumbers = generateRandomNumber();

        while(true) {
            String userInput = receiveUserInput();

            boolean validation = checkUserInput(userInput);

            if(!validation) throw new IllegalArgumentException("3자리의 숫자만 입력해야합니다.");


            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        game();
    }
}
