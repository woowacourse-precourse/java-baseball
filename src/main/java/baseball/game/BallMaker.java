package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BallMaker {
    private String informationMessage = "숫자를 입력해 주세요 : ";
    private int ballSize;
    private boolean allowDuplicate;

    private int minimum;
    private int maximum;


    public BallMaker() {
        this.ballSize = 3;
        this.allowDuplicate = false;
        this.maximum = 9;
        this.minimum = 1;
    }

    public List<Integer> getRandomBall() {
        if (!allowDuplicate) {
            return getUniqueRandomBall();
        }
        return new ArrayList<>();
    }

    public List<Integer> getUserBall() {
        printInformation();
        String userOpinion = Console.readLine();
        if (!checkValidation(userOpinion)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        return makeUserBall(userOpinion);
    }

    private List<Integer> getUniqueRandomBall() {
        Set<Integer> result = new HashSet<>();
        while (result.size() != ballSize) {
            result.add(Randoms.pickNumberInRange(minimum, maximum));
        }
        return Randoms.shuffle(new ArrayList<>(result));
    }

    private void printInformation() {
        System.out.printf(informationMessage);
    }

    private List<Integer> makeUserBall(String userOpinion) {
        final int differenceBetweenCharAndInteger = 48;
        return userOpinion.chars().boxed().map(ch -> ch -= differenceBetweenCharAndInteger).collect(Collectors.toList());
    }

    private boolean checkValidation(String userInput) {
        if (lengthValidation(userInput) && dataValidation(userInput)) {
            return true;
        }
        return false;
    }

    private boolean lengthValidation(String userInput) {
        if (userInput.length() == ballSize) {
            return true;
        }
        return false;
    }

    private boolean dataValidation(String userInput) {
        String dataRegex = String.format("^[%d-9]*$", minimum);
        return Pattern.matches(dataRegex, userInput);
    }

}
