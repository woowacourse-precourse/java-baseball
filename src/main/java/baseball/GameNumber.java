package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final int RESULT_SIZE = 2;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private char[] userNumber;

    public GameNumber() {
    }

    // 사용자 숫자 입력받는 메소드
    public List<Integer> getUserNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print(INPUT_SENTENCE);
        getSplit();
        addInputNumber(user);
        return user;
    }

    // 입력받은 숫자를 분리하여 배열에 저장하는 메소드
    private void getSplit() {
        String split = Console.readLine();

        userNumber = new char[split.length()];

        for (int i = 0; i < split.length(); i++) {
            userNumber[i] = split.charAt(i);
        }
        // 예외 발생 체크
        exception();
    }

    // 사용자의 숫자를 추가하는 메소드
    private void addInputNumber(List<Integer> user) {
        for (Integer num : toInts()) {
            user.add(num);
        }
    }

    // 분리하여 배열에 저장된 문자들을 숫자로 변환하는 메소드
    private int[] toInts() {
        int[] numbers = new int[userNumber.length];
        for (int i = 0; i < userNumber.length; i++) {
            numbers[i] = userNumber[i] - '0';
        }
        return numbers;
    }

    // 컴퓨터 숫자 부여받는 메소드
    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (isSize(computer)) {
            addRandomNumber(computer, Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return computer;
    }

    // 컴퓨터의 숫자를 랜덤으로 추가하는 메소드
    private void addRandomNumber(List<Integer> computer, int randomNumber) {
        if (isContains(computer, randomNumber)) {
            computer.add(randomNumber);
        }
    }


    /**
     * // strike 와 ball 의 결과를 리턴받는 메소드
     * ArrayList 의 메소드인 IndexOf 를 사용하여 판단했습니다.
     * <p>
     * ArrayList 의 index 와 같은 값이라면 strike, index 와 다르지만 0보다 크면 존재한다는 뜻이므로 ball 을 카운트해주었습니다.
     * index 가 0보다 작으면 존재하지 않는다는 뜻이므로 아무런 조치를 취하지 않습니다.
     * <p>
     * strike 와 ball 은 크기가 2인 배열을 선언하여 표현하였습니다.
     */
    public int[] getResult(List<Integer> computer, List<Integer> user) {
        int[] result = new int[RESULT_SIZE];
        for (int idx = 0; idx < computer.size(); idx++) {
            addStrikeAndBall(result, idx, computer.indexOf(user.get(idx)));
        }
        return result;
    }


    // strike 와 ball 의 값을 증가시켜주는 메소드
    private void addStrikeAndBall(int[] result, int idx, int idxOf) {
        if (isSame(idx, idxOf)) {
            result[0]++; // strike ++
            return;
        }
        if (isPositive(idxOf)) {
            result[1]++; // ball ++
            return;
        }
    }

    /**
     * 예외사항
     * 1. 길이가 3이 아닐 때
     * 2. 숫자가 1~9가 아닌 것이 들어갔을 때
     * 3. 중복되는 값이 들어가 있을 때
     */
    public void exception() {
        if (!(isSame(userNumber.length, 3))) {
            throw new IllegalArgumentException();
        }

        if ((userNumber[0] - '0' < MIN_NUMBER || userNumber[0] - '0' > MAX_NUMBER)
                || (userNumber[1] - '0' < MIN_NUMBER || userNumber[1] - '0' > MAX_NUMBER)
                || (userNumber[2] - '0' < MIN_NUMBER || userNumber[2] - '0' > MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }

        if ((isSame(userNumber[0], userNumber[1]))
                || (isSame(userNumber[1], userNumber[2]))
                || (isSame(userNumber[0], userNumber[2]))) {
            throw new IllegalArgumentException();
        }
    }

    // 중복된 숫자가 있는지 확인하는 메소드
    private boolean isContains(List<Integer> computer, int randomNumber) {
        return !computer.contains(randomNumber);
    }

    // 파라미터 두개를 비교하는 메소드
    private boolean isSame(int num, int compareNum) {
        return num == compareNum;
    }

    // 양수인지 아닌지 확인하는 메소드
    private boolean isPositive(int idxOf) {
        return idxOf > 0;
    }

    // 컴퓨터 리스트의 사이즈가 3 미만인지 확인하는 메소드
    private boolean isSize(List<Integer> computer) {
        return computer.size() < 3;
    }
}
