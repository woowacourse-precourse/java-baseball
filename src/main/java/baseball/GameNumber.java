package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {

    private char[] userNumber;

    public GameNumber() {
    }

    // 사용자 숫자 입력받는 메소드
    public List<Integer> getUserNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
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
            addRandomNumber(computer, Randoms.pickNumberInRange(1, 9));
        }
        return computer;
    }

    // 컴퓨터의 숫자를 랜덤으로 추가하는 메소드
    private void addRandomNumber(List<Integer> computer, int randomNumber) {
        if (isContains(computer, randomNumber)) {
            computer.add(randomNumber);
        }
    }

    // 결과를 프린트하는 메소드
    public String printResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        // result[0] = strike, result[1] = ball
        if (isSame(0, result[0]) && isSame(0, result[1])) { // strike ball 둘다 0인 경우
            sb.append("낫싱");
            return sb.toString();
        }
        if (isSame(0, result[1])) { // ball 이 0인 경우
            sb.append(result[0] + "스트라이크");
            return sb.toString();
        }
        if (isSame(0, result[0])) { // strike 가 0인 경우
            sb.append(result[1] + "볼");
            return sb.toString();
        }
        sb.append(result[0] + "볼 " + result[1] + "스트라이크"); // 둘다 0 보다 클 경우
        return sb.toString();
    }

    // strike 와 ball 의 결과를 리턴받는 메소드
    public int[] getResult(List<Integer> computer, List<Integer> user) {
        int[] result = new int[2];
        for (int idx = 0; idx < computer.size(); idx++) {
            addStrikeAndBall(result, idx, computer.indexOf(user.get(idx)));
        }
        return result;
    }

    // strike 와 ball 의 값을 증가시켜주는 메소드
    private void addStrikeAndBall(int[] result, int idx, int idxOf) {
        if (isSame(idx, idxOf)) {
            result[0]++; // strike
            return;
        }
        if (isPositive(idxOf)) {
            result[1]++; // ball
            return;
        }
    }

    // 3스트라이크 시 프로그램 진행/종료 결정하는 메소드
    public boolean executeApplication(int[] result) {
        if (isSame(3, result[0])) { // strike == 3
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
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

        if ((userNumber[0] - '0' <= 0 || userNumber[0] - '0' > 9)
                || (userNumber[1] - '0' <= 0 || userNumber[1] - '0' > 9)
                || (userNumber[2] - '0' <= 0 || userNumber[2] - '0' > 9)) {
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
