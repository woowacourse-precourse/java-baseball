package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<Character> computerNumber;
    static Map<String, String> commonMessageMap;
    static Scanner scanner;

    public static void main(String[] args) {
        initScanner();

        try {
            startGame();
        } catch (EndGameException e) {
            System.out.println(commonMessageMap.get("exitGame"));
        } catch (IllegalArgumentException e) {
            System.out.println("inputErrorMessage");
            throw e;
        }
    }

    public static void initScanner() {
        scanner = new Scanner(System.in);
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
        commonMessageMap.put("inputErrorMessage", "잘못된 형식을 입력했습니다, 프로그램을 종료합니다.");
        commonMessageMap.put("exitGame", "게임을 종료합니다");
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

            String hintMessage = giveHint(userInput);
            System.out.println(hintMessage);

            if(checkUserInputIsThreeStrike(userInput)) {
                decideExitOrProceed();
            }

        }
    }

    // 1,2 아닌경우 대해서 수정 필요
    public static void decideExitOrProceed() throws EndGameException {
        System.out.println(commonMessageMap.get("exitOrProceedMessage"));
        String userInput = readeUserInput();

        if (userInput.equals("1")) {
            startGame();
        }
        else {
            throw new EndGameException();
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
        validateUserInputSize(userInput);
        validateUserInputForm(userInput);
    }

    public static void validateUserInputSize(String userInput) {
        if(userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateUserInputForm(String userInput) {
        for(Character userNumber : userInput.toCharArray()) {
            if(!('1' <= userNumber && userNumber <='9')) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static String giveHint(String userInput) {
        int ballCount = 0;
        int strikeCount = 0;
        String hintMessage = "";

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

        if (strikeCount > 0) {
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
