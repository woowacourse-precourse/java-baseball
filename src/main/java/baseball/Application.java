package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        String computerNumbers = getRandomNumbers();
        String userNumbers = readLine();
        userNumbers = checkUserNumbersValidation(userNumbers);
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

    public static String getMatchResult(String computerNumbers, String userNumbers) {

        return "";
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

}


