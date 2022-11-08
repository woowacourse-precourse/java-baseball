package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers = getRandomNumbers();
        List<Integer> userNumbers;
        HashMap<String, Integer> gameResult;
        String userNumber;
        String commandNumber;
        int command;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");

            userNumber = Console.readLine();

            if (!isValidUserNumber(userNumber)) {
                continue;
            }
            userNumbers = getNumbersToUserNumber(userNumber);
            gameResult = getGameResult(computerNumbers, userNumbers);

            printGameResult(gameResult);

            if (!isThreeStrike(gameResult.get("스트라이크"))) {
                continue;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            commandNumber = Console.readLine();

            if (!isValidCommandNumber(commandNumber)) {
                continue;
            }
            command = getNumber(commandNumber);

            if (isReStartGame(command)) {
                computerNumbers = getRandomNumbers();
            } else {
                break;
            }
        }
    }

    static boolean isThreeStrike(int strikeCount) {
        return strikeCount == 3;
    }

    static boolean isReStartGame(int startGame) {
        return startGame == 1;
    }

    static void printGameResult(HashMap<String, Integer> gameResult) {
        if (gameResult.get("볼") > 0 && gameResult.get("스트라이크") > 0) {
            System.out.println(gameResult.get("볼") + "볼 " + gameResult.get("스트라이크") + "스트라이크");

        } else if (gameResult.get("볼") > 0) {
            System.out.println(gameResult.get("볼") + "볼");

        } else if (gameResult.get("스트라이크") > 0) {
            System.out.println(gameResult.get("스트라이크") + "스트라이크");

        } else {
            System.out.println("낫싱");
        }
    }

    static List<Integer> getNumbersToUserNumber(String userNumber) {
        try {
            return Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static int getNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidUserNumber(String userNumber) {
        if (userNumber.length() != 3 || userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (isDistinct(userNumber)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isValidCommandNumber(String commandNumber) {
        if (commandNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (!(commandNumber.contains("1") || commandNumber.contains("2"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isDistinct(String number) {
        return number.length() != Stream.of(number.split("")).distinct().count();
    }

    static List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    static HashMap<String, Integer> getGameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        HashMap<String, Integer> gameResult = new HashMap<>() {{
            put("볼", 0);
            put("스트라이크", 0);
        }};

        for (int index = 0; index < 3; index++) {
            if (computerNumbers.get(index).equals(userNumbers.get(index))) {
                gameResult.put("스트라이크", gameResult.get("스트라이크") + 1);

            } else if (computerNumbers.contains(userNumbers.get(index))) {
                gameResult.put("볼", gameResult.get("볼") + 1);
            }
        }
        return gameResult;
    }
}
