package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUM_START_RANGE = 1;
    private static final int NUM_END_RANGE = 9;
    private List<Integer> randomNum;

    public Game() {
        randomNum = generateRandomNumber(NUM_START_RANGE, NUM_END_RANGE);
    }

    /**
     * Generates 3-digit random number with no duplicate digit
     * @param start 랜덤 숫자 생성 범위 시작점
     * @param end 랜덤 숫자 생성 범위 끝점
     * @return numbers 랜덤하게 생성한 3자리 수가 들어있는 ArrayList
     */
    static List<Integer> generateRandomNumber(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(start, end);
            if (!numbers.contains(randomNum))
                numbers.add(randomNum);
        }
        return numbers;
    }

    /**
     * Set user's input of 3-digit number for game class instance
     * @see InputValidation#isValidInput(String) input 의 유효성 검사
     */
    static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine().trim();
        try {
            InputValidation.isValidInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            endGame();
        }

        ArrayList<Integer> inputList = new ArrayList<>();
        char[] characterArray = userInput.toCharArray();
        for(char c : characterArray)
            inputList.add(Character.getNumericValue(c));

        return inputList;
    }

    static void endGame() {
        System.out.println("게임 종료");
    }

}
