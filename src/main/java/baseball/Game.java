package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    int MAX_SCORE = 3;

    public void start() {
        Score score = new Score(MAX_SCORE);
        List<Integer> user;
        List<Integer> computer = getRandomNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            user = getInputNumbers();

            score.updateTotalScore(computer, user);
            score.print();

        } while (!score.isAllStrike());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isDigit(Character CharNumber) {
        return Character.isDigit(CharNumber);
    }


    private int toDigit(Character input) {
        validateDigit(input);

        return input - '0';
    }

    private void validateDigit(Character charNumber) {
        if (!isDigit(charNumber)) {
            throw new IllegalArgumentException("not digit");
        }
    }


    public boolean wantRestart() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = readLine();

        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("invalid input");
        }

    }


    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != MAX_SCORE || new HashSet<>(numbers).size() != MAX_SCORE) {
            throw new IllegalArgumentException("invalid input");
        }
    }


    private List<Integer> toIntList(String numberString) {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < numberString.length(); i++) {
            numberList.add(toDigit(numberString.charAt(i)));
        }
        return numberList;
    }

    public List<Integer> getInputNumbers() {
        System.out.printf("숫자를 입력해주세요 : ");
        String input = readLine();
        List<Integer> userNumbers = toIntList(input);
        validateNumbers(userNumbers);

        return userNumbers;
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_SCORE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
