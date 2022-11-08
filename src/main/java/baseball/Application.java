package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int RANDOM_NUMBER_DIGIT_SIZE = 3;

    public static void main(String[] args) {
        startGame();
    }

    /**
     * 전체 프로그램을 실행하는 method
     */
    public static void startGame() {
        int condition = 1;
        while (condition == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            baseBallStart();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String input = getInput();
            validateProgramConditionInput(input);
            condition = Integer.parseInt(input);
        }
        System.out.println("게임 종료");
    }

    /**
     * 게임 종료 혹은 재시작에 필요한 input을 validate
     * @param input
     */
    public static void validateProgramConditionInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Baseball game에 사용되는 input을 validate
     * @param input
     */
    public static void validateBaseBallInput(String input) {
        if (input.length() != RANDOM_NUMBER_DIGIT_SIZE)
            throw new IllegalArgumentException();
        if (!isNumeric(input))
            throw new IllegalArgumentException();
        if (input.contains("0"))
            throw new IllegalArgumentException();
    }

    /**
     * String을 int로 변환할 수 있는지 검사
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    /**
     * 사용자의 input을 받음<br/>
     * camp.nextstep.edu.missionutils.Console의 readLine()을 wrapping한 method
     *
     * @return
     */
    private static String getInput() {
        return Console.readLine();
    }

    /**
     * String을 tokenize
     * @param input
     * @return
     */
    public static List<Character> tokenizeString(String input) {
        List<Character> tokenizedResult = new ArrayList<>();

        for (int i = 0; i < input.length(); i++)
            tokenizedResult.add(input.charAt(i));


        return tokenizedResult;
    }

    /**
     * Character list를 Integer list로 변환
     * @param charList
     * @return
     */
    public static List<Integer> convertCharListToIntList(List<Character> charList) {
        List<Integer> parseIntResultList = new ArrayList<>();

        for (Character ch : charList)
            parseIntResultList.add(Character.getNumericValue(ch));

        return parseIntResultList;
    }


    /**
     * 사용자의 baseball input을 calculateBaseBallResult()의 input 유형으로 변환
     * @param input
     * @return
     */
    public static List<Integer> convertInputToBaseBallInput(String input) {
        return (convertCharListToIntList(tokenizeString(input)));
    }

    /**
     * Baseball 게임에 사용되는 난수를 생성
     * @param digitSize 만들고 싶은 난수의 자리수
     * @return
     */
    public static List<Integer> generateRandomNumber(int digitSize) {
        List<Integer> generatedRandomNumber = new ArrayList<>();

        while (generatedRandomNumber.size() < digitSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!generatedRandomNumber.contains(randomNumber))
                generatedRandomNumber.add(randomNumber);
        }
        return generatedRandomNumber;
    }

    /**
     * 게임 초기에 생성된 random number와 사용자 input을 비교해 스트라이크와 볼을 계산
     * @param randomNumber
     * @param input
     * @return index 0 : strike count, index 1 : ball count>
     */
    public static List<Integer> calculateBaseBallResult(List<Integer> randomNumber, List<Integer> input) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < randomNumber.size(); i++) {
            int currentRandomNumberDigit = randomNumber.get(i);
            int currentInputNumberDigit = input.get(i);

            if (currentRandomNumberDigit == currentInputNumberDigit)
                strikeCount += 1;
            else if (randomNumber.contains(currentInputNumberDigit))
                ballCount += 1;
        }

        return List.of(strikeCount, ballCount);
    }

    /**
     * Strike count와 ball count를 통해 출력문을 만듬
     * @param baseballResult index 0 : strike count, index 1 : ball count
     * @return
     */
    public static String convertBaseBallResultToConsoleOutputString(List<Integer> baseballResult) {
        int strikeCount = baseballResult.get(0);
        int ballCount = baseballResult.get(1);

        if (strikeCount == 0 && ballCount == 0)
            return "낫싱";
        else if (strikeCount == 0)
            return ballCount + "볼";
        else if (ballCount == 0)
            return strikeCount + "스트라이크";
        else
            return ballCount + "볼" + " " + strikeCount + "스트라이크";
    }

    /**
     * Baseball game을 진행
     */
    public static void baseBallStart() {
        List<Integer> randomNumber = generateRandomNumber(RANDOM_NUMBER_DIGIT_SIZE);
        List<Integer> currentBaseBallResult;

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = getInput();

            validateBaseBallInput(input);

            List<Integer> baseBallInput = convertInputToBaseBallInput(input);

            currentBaseBallResult = calculateBaseBallResult(randomNumber, baseBallInput);

            System.out.println(convertBaseBallResultToConsoleOutputString(currentBaseBallResult));

            if (currentBaseBallResult.get(0) == RANDOM_NUMBER_DIGIT_SIZE)
                break;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
