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
        if (!validLength(arr)) {
            throw new IllegalArgumentException("중복되지 않은 1~9 사이의 숫자로 구성된 '세 자리 숫자'를 입력해야합니다.");
        }
        if (!validNumberRange(arr)) {
            throw new IllegalArgumentException("중복되지 않은 '1~9 사이의' 숫자로 구성된 세 자리 숫자를 입력해야합니다.");
        }
        if (!validDuplicate(arr)) {
            throw new IllegalArgumentException("'중복되지 않은' 1~9 사이의 숫자로 구성된 세 자리 숫자를 입력해야합니다.");
        }
        if (!validOnlyNumber(arr)) {
            throw new IllegalArgumentException("중복되지 않은 1~9 사이의 '숫자로 구성된' 세 자리 숫자를 입력해야합니다.");
        }
        return true;
    }

    private boolean validOnlyNumber(String[] arr) {
        String pattern = "^[0-9]*$";
        StringBuilder validateIndex = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            validateIndex.append(arr[i]);
        }
        return Pattern.matches(pattern, validateIndex.toString());
    }

    private boolean validDuplicate(String[] arr) {
        int validateIndex = 0;
        if (arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[0].equals(arr[2])) {
            validateIndex = 1;
        }
        return validateIndex == 0;
    }

    private boolean validNumberRange(String[] arr) {
        int validateIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                validateIndex = 1;
                break;
            }
        }
        return validateIndex == 0;
    }

    private boolean validLength(String[] arr) {
        return arr.length == 3;
    }

    public int size() {
        return ball.size();
    }

    public boolean contains(int index){
        return ball.contains(index);
    }

    public int get(int index){
        return ball.get(index);
    }

    public int indexOf(int index) {
        return ball.indexOf(index);
    }
}
