package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

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
    // for testing purposes
    List<Integer> getRandomNum() {
        return randomNum;
    }

    /**
     * Set user's input of 3-digit number for game class instance
     * @see InputValidation#isValidInput(String) input 의 유효성 검사
     */
    static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        // TODO: Warning 의 정체는 무엇? Troubleshooting
        String userInput = Console.readLine().trim();
//        Scanner keyboard = new Scanner(System.in);
//        String userInput = keyboard.nextLine();
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
     * Start game
     * Loop until 3 strike
     * Restart depending on user input
     * @see Game#restart()
     */
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isThreeStrike = false;
        List<Integer> userInput;
        List<Integer> resultList;

        while (!isThreeStrike) {
            userInput = getUserInput();
            resultList = Hint.result(userInput, this);
            Hint.printResult(resultList);
            if (resultList.equals(new ArrayList<>(Arrays.asList(0, 3)))) {
                isThreeStrike = true;
                System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                endGame();
                restart();
            }
        }

    }
}
