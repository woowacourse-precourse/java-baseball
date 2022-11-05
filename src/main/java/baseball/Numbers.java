package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers inputUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput = Console.readLine();
        validateNumbers(userInput);
        for (char element : userInput.toCharArray()) {
            userNumbers.add(element - '0');
        }
        return new Numbers(userNumbers);
    }

    public static Numbers generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new Numbers(computerNumbers);
    }

    public static void validateNumbers(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("자릿수가 올바르지 않습니다.");
        }
        if (!hasValidFormat(userInput)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (!hasSameCharactors(userInput)) {
            throw new IllegalArgumentException("중복된 수가 존재합니다.");
        }
    }

    public static boolean hasValidFormat(String userInput) {
        return userInput.matches("^[1-9]{3}$");
    }

    public static boolean hasSameCharactors(String userInput) {
        Set<Character> uniqueNumbers = new HashSet<>();
        for (char element : userInput.toCharArray()) {
            uniqueNumbers.add(element);
        }
        return uniqueNumbers.size() == 3;
    }

    public static Guess guessResult(Numbers answer, Numbers guess) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int index = 0; index < guess.numbers.size(); index++) {
            if (answer.numbers.contains(guess.numbers.get(index)) && !guess.numbers.get(index).equals(answer.numbers.get(index))) {
                ballCount++;
            }
            if (guess.numbers.get(index).equals(answer.numbers.get(index))) {
                strikeCount++;
            }
        }
        return new Guess(ballCount, strikeCount);
    }
}
