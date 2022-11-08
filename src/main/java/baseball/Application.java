package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
    }

    public static String getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            Integer tempNumber = pickNumberInRange(1, 9);
            if (!randomNumbers.contains(tempNumber)) {
                randomNumbers.add(tempNumber);
            }
        }
        return randomNumbers.toString().replaceAll("[^0-9]","");
    }

    public static String checkUserNumbersValidation(String userNumbers) {
        userNumbers = userNumbers.replaceAll("[^0-9]","");
        if (userNumbers.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        try {
            Integer.parseInt(userNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        HashSet<Character> checkDuplicate = new HashSet<>();
        userNumbers.chars().forEach(item -> checkDuplicate.add((char) item));
        if (checkDuplicate.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력해주세요.");
        }
        return userNumbers;
    }

    public static String getMatchOutputStatement(String computerNumbers, String userNumbers) {
        String strikeStatement = "";
        String ballStatement = "";
        String matchResult = countStrikeBall(computerNumbers, userNumbers);
        if (matchResult.charAt(0) == '0' && matchResult.charAt(1) == '0') {
            return "낫싱";
        }
        if (matchResult.charAt(1) != '0') {
            ballStatement += matchResult.charAt(1) + "볼";
        }
        if (matchResult.charAt(0) != '0') {
            strikeStatement += matchResult.charAt(0) + "스트라이크";
        }
        if (ballStatement.length() != 0 && strikeStatement.length() != 0) {
            return ballStatement + " " + strikeStatement;
        }
        return ballStatement + strikeStatement;
    }

    public static String countStrikeBall(String computerNumbers, String userNumbers) {
        List<Integer> matchedNumbers = new ArrayList<Integer>(Arrays.asList(0,0));

        for (int i = 0; i < computerNumbers.length(); i++) {
            if (computerNumbers.charAt(i) == userNumbers.charAt(i)) {
                matchedNumbers.set(0, matchedNumbers.get(0) + 1);
            } else if (computerNumbers.contains(String.valueOf(userNumbers.charAt(i)))) {
                matchedNumbers.set(1, matchedNumbers.get(1) + 1);
            }
        }
        return matchedNumbers.toString().replaceAll("[^0-9]","");
    }

    public static void runBaseball() {
        String computerNumbers = getRandomNumbers();
        String outputStatement = "";
        while (!outputStatement.equals("3스트라이크")) {
            System.out.println("숫자를 입력해주세요 : ");
            String userNumbers = readLine();
            userNumbers = checkUserNumbersValidation(userNumbers);
            outputStatement = getMatchOutputStatement(computerNumbers, userNumbers);
            System.out.println(outputStatement);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}


