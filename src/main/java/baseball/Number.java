package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final int RESULT_SIZE = 2;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String pattern = "^[1-9]{3}$";

    public Number() {
    }

    // 사용자 숫자 입력받는 메소드
    public List<Integer> getUserNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print(INPUT_SENTENCE);
        getUserNumber(user);
        return user;
    }

    // 사용자의 숫자 입력받는 메소드
    private void getUserNumber(List<Integer> user) {
        String split = Console.readLine();
        /**
         * 예외사항
         * 1. 길이가 3이 아닐 때
         * 2. 숫자가 1~9가 아닌 것이 들어갔을 때
         */
        if (!(Pattern.matches(pattern, split))) {
            throw new IllegalArgumentException();
        }

        // 사용자 숫자 List 에 추가하는 메소드
        for (int idx = 0; idx < 3; idx++) {
            addNumber(user, split, idx);
        }
    }

    // 사용자 숫자를 List 에 추가하는 메소드
    private void addNumber(List<Integer> user, String split, int idx) {
        // 3. 중복된 숫자인가 판별하는 예외처리 메서드
        isDuplicationNumber(user, split, idx);

        user.add(toInt(split.charAt(idx)));
    }

    // 중복된 숫자인가 판별하는 메서드
    private void isDuplicationNumber(List<Integer> user, String split, int idx) {
        if (isContains(user, toInt(split.charAt(idx)))) {
            throw new IllegalArgumentException();
        }
    }

    // 분리하여 배열에 저장된 문자들을 숫자로 변환하는 메소드
    private int toInt(char c) {
        return c - '0';
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
        if (!(isContains(computer, randomNumber))) {
            computer.add(randomNumber);
        }
    }

    /**
     * strike 와 ball 의 결과를 리턴받는 메소드
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

    // 중복된 숫자가 있는지 확인하는 메소드
    private boolean isContains(List<Integer> list, int number) {
        return list.contains(number);
    }

    // 파라미터 두개를 비교하는 메소드
    private boolean isSame(int num, int compareNum) {
        return num == compareNum;
    }

    // 양수인지 아닌지 확인하는 메소드
    private boolean isPositive(int idxOf) {
        return idxOf >= 0;
    }

    // 컴퓨터 리스트의 사이즈가 3 미만인지 확인하는 메소드
    private boolean isSize(List<Integer> computer) {
        return computer.size() < 3;
    }
}
