package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;
import java.util.regex.Pattern;


public class Application {
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";
    public static final String RE_START = "1";
    public static final String END = "2";

    public static void main(String[] args) {
        BaseballGame();
    }
    public static void BaseballGame() {
        introMessage();
        do {
            playingGame(createBaseballNumberList());
        } while(continueGame());
    }
    public static void playingGame(List<Integer> baseballNumberList) {
        String input;
        Integer strikeCount;
        Integer ballCount;
        do {
            mainMessage();
            input = Console.readLine();
            Map<String, Integer> count = createRefereeCount(baseballNumberList, createInputNumberList(input));
            ballCount = count.get(BALL);
            strikeCount = count.get(STRIKE);

            resultMessage(refereeAnswer(ballCount, strikeCount));
        } while (isClearGame(strikeCount));
    }
    public static boolean isClearGame(Integer strikeCount) {
        return strikeCount != 3;
    }
    public static boolean continueGame() {
        endMessage();
        String flag = Console.readLine();
        validateFlag(flag);
        return flag.equals(RE_START);
    }
    public static void validateFlag(String flag) {
        if(!flag.equals(END) && !flag.equals(RE_START)){
            throw new IllegalArgumentException("1 or 2만 입력할 수 있습니다.");
        }
    }
    public static List<Integer> createBaseballNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public static List<Integer> createInputNumberList(String input) {
        validateAnswer(input);

        List<Integer> inputList = new ArrayList<>();
        for (String number : input.split("")){
            inputList.add(Integer.parseInt(number));
        }
        return inputList;
    }
    public static void validateAnswer(String answer) {
        String regexNumber = "^[1-9]*$";
        if(!Pattern.matches(regexNumber, answer)){
            throw new IllegalArgumentException("1~9까지의 숫자만 입력할 수 있습니다.");
        }
        if(answer.length() != 3){
            throw new IllegalArgumentException("3자리 숫자만 입력하여 주십시오.");
        }
        if(!isDuplication(answer)){
            throw new IllegalArgumentException("각 자리 수는 중복이 될 수 없습니다.");
        }
    }
    public static boolean isDuplication(String input) {
        List<String> duplicationCheckList = Arrays.asList(input.split(""));
        return duplicationCheckList.size() == duplicationCheckList.stream().distinct().count();
    }

    public static Map<String, Integer> createRefereeCount(List<Integer> baseballNumberList, List<Integer> inputNumberList) {
        Map<String, Integer> count = new HashMap<>(){{
            put(STRIKE,0);
            put(BALL,0);
        }};

        for (int i = 0; i < baseballNumberList.size(); i++) {
            int baseballNumber = baseballNumberList.get(i);
            int inputNumber = inputNumberList.get(i);
            if(baseballNumber == inputNumber){
                count.put(STRIKE, count.get(STRIKE) + 1);
            }
            if(baseballNumber != inputNumber && baseballNumberList.contains(inputNumber)){
                count.put(BALL, count.get(BALL) + 1);
            }
        }
        return count;
    }
    public static String refereeAnswer(Integer ballCount, Integer strikeCount) {
        if(ballCount > 0 && strikeCount > 0){
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
        if(ballCount > 0){
            return ballCount + "볼";
        }
        if(strikeCount > 0){
            return strikeCount + "스트라이크";
        }
        return "낫싱";
    }
    public static void introMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void mainMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void resultMessage(String refereeAnswer) {
        System.out.println(refereeAnswer);
    }
    public static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
