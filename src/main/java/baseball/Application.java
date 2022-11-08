package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int RANDOM_NUMBER_DIGIT_SIZE = 3;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        int condition = 1;
        while(condition == 1){
            System.out.println("숫자 야구 게임을 시작합니다.");
            baseBallStart();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String input = Console.readLine();
            validateProgramConditionInput(input);
            condition = Integer.parseInt(input);
        }
    }

    public static void validateProgramConditionInput(String input) {
        if(input != "1" || input != "2")
            throw new IllegalArgumentException();
    }

    public static void validateInput(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException();
        if (!isNumeric(input))
            throw new IllegalArgumentException();
        if (input.contains("0"))
            throw new IllegalArgumentException();
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    private static String getInput() {
        return Console.readLine();
    }

    public static List<Character> tokenizeString(String input) {
        List<Character> tokenizedResult = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            tokenizedResult.add(input.charAt(i));
        }
        return tokenizedResult;
    }

    public static List<Integer> convertCharListToIntList(List<Character> charList) {
        List<Integer> parseIntResultList = new ArrayList<>();
        for(Character ch : charList){
            parseIntResultList.add(Character.getNumericValue(ch));
        }

        return parseIntResultList;
    }

    public static List<Integer> convertInputToBaseBallInput(String input){
        return(convertCharListToIntList(tokenizeString(input)));
    }

    public static List<Integer> generateRandomNumber(int digitSize) {
        List<Integer> generatedRandomNumber = new ArrayList<>();
        while (generatedRandomNumber.size() < digitSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedRandomNumber.contains(randomNumber)) {
                generatedRandomNumber.add(randomNumber);
            }
        }
        return generatedRandomNumber;
    }

    public static List<Integer> calculateBaseBallResult(List<Integer> randomNumber, List<Integer> input) {
        int strikeCount = 0;
        int ballCount = 0;

        for(int i = 0; i < randomNumber.size(); i++){
            int currentRandomNumberDigit = randomNumber.get(i);
            int currentInputNumberDigit = input.get(i);

            if(currentRandomNumberDigit == currentInputNumberDigit)
                strikeCount+=1;
            else if(randomNumber.contains(currentInputNumberDigit))
                ballCount+=1;
        }

        return List.of(strikeCount, ballCount);
    }

    public static String convertBaseBallResultToConsoleOutputString(List<Integer> baseballResult) {
        int strikeCount = baseballResult.get(0);
        int ballCount = baseballResult.get(1);

        if(strikeCount == 0 && ballCount == 0)
            return "낫싱";
        else if(strikeCount == 0){
            return ballCount + "볼";
        } else if(ballCount == 0)
            return strikeCount+"스트라이크";
        else
            return ballCount+"볼"+" "+strikeCount+"스트라이크";
    }

    public static void baseBallStart() {
        List<Integer> randomNumber = generateRandomNumber(RANDOM_NUMBER_DIGIT_SIZE);
        List<Integer> currentBaseBallResult;

        while(true){
            String input = getInput();

            validateInput(input);
            List<Integer> baseBallInput = convertInputToBaseBallInput(input);

            currentBaseBallResult = calculateBaseBallResult(randomNumber, baseBallInput);

            System.out.println(convertBaseBallResultToConsoleOutputString(currentBaseBallResult));

            if(currentBaseBallResult.get(0) == RANDOM_NUMBER_DIGIT_SIZE)
                break;
        }
    }
}
