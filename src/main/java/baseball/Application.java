package baseball;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

public class Application {
    static List<Character> computerNumber;
    static Map<String, String> commonMessageMap;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            startGame();
        } catch (IllegalStateException e) {
            System.out.println("게임을 종료합니다.");
        }
    }

    public static void startGame() {
        initCommonMessageMap();
        initComputerNumber();
        System.out.println(computerNumber);

        System.out.println(commonMessageMap.get("startMessage"));

        while(true) {
            System.out.print(commonMessageMap.get("inputMessage"));
            String userInput = readeUserInput();

            validateUserInput(userInput);

            if(checkUserInputIsThreeStrike(userInput)) {
                decideExitOrProceed();
            }

            String hintMessage = giveHint(userInput);
            System.out.println(hintMessage);
        }
    }

    public static void decideExitOrProceed() {
        System.out.println(commonMessageMap.get("exitOrProceedMessage"));
        String userInput = readeUserInput();

        if (userInput.equals("1")) {
            startGame();
        } else {
            throw new IllegalStateException();
        }
    }

    public static boolean checkUserInputIsThreeStrike(String userInput) {
        int strikeCount = checkStrike(userInput);

        if(strikeCount == 3) {
            System.out.println(commonMessageMap.get("threeStrikeMessage"));
            return true;
        }
        return false;
    }

    public static void initComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            Character randomNumber = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static void initCommonMessageMap() {
        commonMessageMap = new HashMap<>();
        commonMessageMap.put("startMessage", "숫자 야구 게임을 시작합니다.");
        commonMessageMap.put("inputMessage", "숫자를 입력해주세요 : ");
        commonMessageMap.put("threeStrikeMessage", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        commonMessageMap.put("exitOrProceedMessage", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        commonMessageMap.put("errorMessage", "잘못된 형식을 입력했습니다, 프로그램을 종료합니다.");
    }

    public static int checkStrike(String userInput) {
        int strikeCount = 0;

        for (int place = 0; place < userInput.length(); place++) {
            Character computerNum = computerNumber.get(place);
            Character userNum = userInput.charAt(place);

            if(computerNum.equals(userNum)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int checkBall(String userInput) {
        int ballCount = 0;

        for (int place = 0; place < userInput.length(); place++) {
            Character computerNum = computerNumber.get(place);
            Character userNum = userInput.charAt(place);

            if(!computerNum.equals(userNum) && computerNumber.contains(userNum)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public static boolean checkNothing(String userInput) {
        for (Character userNumber : userInput.toCharArray()) {
            if (computerNumber.contains(userNumber)) {
                return false;
            }
        }

        return true;
    }

    public static void validateUserInput(String userInput) {
        try {
            validateUserInputSize(userInput);
            validateUserInputForm(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(commonMessageMap.get("errorMessage"));
            throw e;
        }
    }

    public static void validateUserInputSize(String userInput) {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static Exception validateUserInputForm(String userInput) {
        for(Character userNumber : userInput.toCharArray()) {
            if(!('1' <= userNumber && userNumber <='9')) {
                throw new IllegalArgumentException();
            }
        }
        return null;
    }

    public static String giveHint(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;
        String hintMessage = "";

        validateUserInput(userInput);
        checkUserInputIsThreeStrike(userInput);

        if(!checkNothing(userInput)) {
            ballCount = checkBall(userInput);
            strikeCount = checkStrike(userInput);

        }
        hintMessage = createHintMessage(ballCount, strikeCount);

        return hintMessage;
    }

    public static String createHintMessage(int ballCount, int strikeCount) {
        StringBuilder hintMessageBuilder = new StringBuilder();
        String hintMessage;

        if(ballCount > 0) {
            hintMessageBuilder.append(ballCount).append("볼").append(" ");
        }

        if (strikeCount > 0 && strikeCount < 3) {
            hintMessageBuilder.append(strikeCount).append("스트라이크");
        }

        if(ballCount == 0 && strikeCount == 0) {
            hintMessageBuilder.append("낫싱");
        }

        hintMessage = hintMessageBuilder.toString();
        return hintMessage;
    }

    public static String readeUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }




}
