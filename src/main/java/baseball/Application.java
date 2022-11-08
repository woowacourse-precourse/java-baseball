package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            startGame();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 컴퓨터가 생성하는 1-9 사이의 서로 다른 임의의 숫자로 이루어진 3개의 수로 이루어진 리스트를 생성
     */
    private static List<Integer> getThreeRandomNumbersList() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        // System.out.println(computerNumberList);
        return computerNumberList;
    }

    /**
     * String 형의 유저 입력을 List<Integer>형으로 변환
     */
    private static List<Integer> getStringInputToList(String userInput) {
        String[] splitUserInput = userInput.split("");
        List<String> userInputList = new ArrayList<>(List.of(splitUserInput));
        List<Integer> userInputIntegerList = new ArrayList<>();

        for (String oneInputNumber : userInputList) {
            userInputIntegerList.add(Integer.valueOf(oneInputNumber));
        }

        return userInputIntegerList;
    }

    /**
     * 유저로부터 입력받은 값이 컴퓨터가 생성한 값과 일치하는지 판별
     */
    private static boolean isUserComputerNumberCorrespond(List<Integer> userInputNumber, List<Integer> computerNumber) {
        return userInputNumber.equals(computerNumber);
    }

    /**
     * 스트라이크 수를 계산
     */
    private static int getStrikes(List<Integer> userInputNumber, List<Integer> computerNumber) {
        int strikes = 0;

        /* 스트라이크 수 계산 */
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (Objects.equals(userInputNumber.get(i), computerNumber.get(i))) {
                strikes += 1;
            }
        }

        return strikes;
    }

    /**
     * 볼 수를 계산
     */
    private static int getBalls(List<Integer> userInputNumber, List<Integer> computerNumber) {
        int strikes = getStrikes(userInputNumber, computerNumber);
        int balls = 0;

        /* 볼 수 계산 */
        for (Integer oneOfUserNum : userInputNumber) {
            if (computerNumber.contains(oneOfUserNum)) {
                balls += 1;
            }
        }
        balls -= strikes; // ball 계산하며 strike 중복 계산 제거

        return balls;
    }

    /**
     * 유저의 입력에 대한 상태 계산 결과 출력(컴퓨터 생성 수와 일치하는지, 스트라이크/볼 수는 몇인지, 낫싱인지)
     *
     * @return 게임이 종료되는 경우 true, 그렇지 않은 경우 false를 반환
     */
    private static boolean printGameResult(List<Integer> userInputNumber, List<Integer> computerNumber) {
        int strikes = getStrikes(userInputNumber, computerNumber);
        int balls = getBalls(userInputNumber, computerNumber);

        if (isUserComputerNumberCorrespond(userInputNumber, computerNumber)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } else if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return false;
        } else {
            if (strikes == 0) {
                System.out.printf("%d볼\n", balls);
            } else if (balls == 0) {
                System.out.printf("%d스트라이크\n", strikes);
            } else {
                System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            }
            return false;
        }
    }

    /**
     * 유저의 입력이 유효한지 검사
     * 유효하지 않은 경우: 세 자리가 아닌 경우, 1~9 사이의 정수가 아닌 수가 있는 경우, 숫자 이외의 문자가 있는 경우, 숫자들 중 중복되는 수가 있는 경우
     */
    private static void validateUserInput(String userInput) throws IllegalArgumentException {
        /* 세 자리가 아닌 경우 검사 */
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }

        /* 숫자 이외의 문자가 있는 경우, 1~9 사이의 정수가 아닌 수가 있는 경우 검사 */
        for (char oneDigit : userInput.toCharArray()) {
            if (!Character.isDigit(oneDigit)) {
                throw new IllegalArgumentException();
            } else if (!(49 <= oneDigit && oneDigit <= 57)) {
                throw new IllegalArgumentException();
            }
        }

        /* 숫자들 중 중복되는 경우가 있는 경우 검사 */
        HashSet<Character> userInputSet = new HashSet<>();
        for (char oneDigit : userInput.toCharArray()) {
            userInputSet.add(oneDigit);
        }
        if (userInputSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 게임을 시작 / 진행
     */
    private static void startGame() throws IllegalArgumentException {
        String userInput;
        List<Integer> userInputList;
        List<Integer> computerNumberList;
        boolean canStartNewGame;
        boolean isNewGame = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        computerNumberList = getThreeRandomNumbersList();
        while (isNewGame) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();
            try {
                validateUserInput(userInput);
                userInputList = getStringInputToList(userInput);

                canStartNewGame = printGameResult(userInputList, computerNumberList);
                if (canStartNewGame) {
                    computerNumberList = getThreeRandomNumbersList();
                    isNewGame = getUserGoStop();
                }
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    /**
     * 게임이 끝난 경우 새로 시작할지 말지에 대한 유저 입력 받음
     *
     * @return 계속 게임을 지속하는 경우 true, 그렇지 않은 경우 false 반환
     */
    private static boolean getUserGoStop() throws IllegalArgumentException {
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
