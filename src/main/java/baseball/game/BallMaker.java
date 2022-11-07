package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    public BallMaker(int ballSize, int minNum) {
        this.allowDuplicate = false;
        this.maximum = 9;
        this.ballSize = ballSize;
        this.minimum = minNum;
    }

    public Ball getRandomBall() {
        if (!allowDuplicate) {
            return getUniqueRandomBall();
        }
        return new Ball();
    }

    public Ball getUserBall() {
        printInformation();
        String userOpinion = Console.readLine();
        if (!checkValidation(userOpinion)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        return makeUserBall(userOpinion);
    }

    private Ball getUniqueRandomBall() {
        List<Integer> result = new ArrayList<>();
        while (result.size() != ballSize) {
            int randomNumber = Randoms.pickNumberInRange(minimum, maximum);
            if (result.contains(randomNumber)) {
                continue;
            }
            result.add(randomNumber);
        }
        return new Ball(result);
    }

    private void printInformation() {
        System.out.printf(informationMessage);
    }

    private Ball makeUserBall(String userOpinion) {
        final int differenceBetweenCharAndInteger = 48;
        List<Integer> ballData = userOpinion.chars()
                .boxed()
                .map(ch -> ch -= differenceBetweenCharAndInteger)
                .collect(Collectors.toList());
        return new Ball(ballData);
    }

    private boolean checkValidation(String userInput) {
        if (lengthValidation(userInput) && dataValidation(userInput) && reduplicationValidation(userInput)) {
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

    private boolean reduplicationValidation(String userInput) {
        Set<Integer> dataSet = userInput.chars().boxed().collect(Collectors.toSet());
        return dataSet.size() == userInput.length();
    }

}
