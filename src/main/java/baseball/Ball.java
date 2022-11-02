package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Ball {

    private List<Integer> ball;

    public Ball() {

    }

    public void makeComputerBalls() {
        List<Integer> comBall = new ArrayList<>();
        while (comBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comBall.contains(randomNumber)) {
                comBall.add(randomNumber);
            }
        }
        this.ball = comBall;
    }

    public void makeHumanBalls() {
        List<Integer> humanBall = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String[] humanInput = Console.readLine().split("");
        if (validate(humanInput)) {
            arrayToList(humanBall, humanInput);
        }
        this.ball = humanBall;
    }

    private void arrayToList(List<Integer> humanBall, String[] humanInput) {
        for (int i = 0; i < humanInput.length; i++) {
            humanBall.add(Integer.parseInt(humanInput[i]));
        }
    }

    private boolean validate(String[] arr) {
        return true;
    }

    private boolean validOnlyNumber(String[] arr) {
        String pattern = "^[0-9]*$";
        StringBuilder validateIndex = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            validateIndex.append(arr[i]);
        }
        return !Pattern.matches(pattern, validateIndex.toString());
    }

    private boolean validDuplicate(String[] arr) {
        int validateIndex = 0;
        if (arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[0].equals(arr[2])) {
            validateIndex = 1;
        }
        return validateIndex == 1;
    }

    private boolean validNonZeroValue(String[] arr) {
        int validateIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                validateIndex = 1;
                break;
            }
        }
        return validateIndex == 1;
    }

    private boolean validLength(String[] arr) {
        return arr.length != 3;
    }
}
