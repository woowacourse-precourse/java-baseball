package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    private List<Integer> generateRandomNumber(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(start, end);
            if (!numbers.contains(randomNum))
                numbers.add(randomNum);
        }
        return numbers;
    }

    // for testing purposes
    void setRandomNum(List<Integer> randomNum) {
        this.randomNum = randomNum;
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

    void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String restart = Console.readLine();
        try {
            InputValidation.isValidRestartInput(restart);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            endGame();
            return;
        }

        if (restart.equals("1")) {
            this.randomNum = generateRandomNumber(NUM_START_RANGE, NUM_END_RANGE);
            start();
        }
        else
            endGame();
    }

    /**
     * Compare user input with game instance's randomNum and calculate result
     * @param userInput 사용자가 입력한 값
     * @return resultList 볼과 스트라이크의 개수가 차례대로 담긴 리스트
     */
    List<Integer> result(List<Integer> userInput) {
        List<Integer> resultList = new ArrayList<>(Arrays.asList(0, 0));
        int ballCount = 0;
        for (int i = 0; i < this.randomNum.size(); i++) {
            if (Objects.equals(this.randomNum.get(i), userInput.get(i)))
                resultList.set(1, resultList.get(1) + 1);
            else {
                ballCount += checkBall(userInput.get(i), this.randomNum);
            }
        }
        resultList.set(0, ballCount);
        return resultList;
    }

    /**
     * Check whether certain digit exists in game instance's randomNum
     * @param digit 사용자가 입력한 값 중 하나
     * @param answer game 인스턴스의 randomNum
     * @return 포함하고 있으면 1, 아니면 0
     */
    int checkBall(Integer digit, List<Integer> answer) {
        if(answer.contains(digit))
            return 1;
        return 0;
    }

    void printResult(List<Integer> resultList) {
        int ball = resultList.get(0);
        int strike = resultList.get(1);
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if (ball == 0 || strike == 0) {
            if (resultList.indexOf(Integer.max(ball, strike)) == 0)
                System.out.println(ball + "볼");
            else
                System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void start() {}


}
