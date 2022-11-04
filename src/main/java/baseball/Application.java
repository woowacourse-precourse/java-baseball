package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            baseballGame();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int num = Integer.parseInt(Console.readLine());
            if (isSame(2, num)) {
                break;
            }
        }
    }

    private static void baseballGame() {
        List<Integer> computer = getComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        for (int i = 0; i < 3; i++) {
            System.out.print(computer.get(i) + " ");
        }
        System.out.println();

        while (true) {
            List<Integer> user = getUserNumber();
            // 값을 제공하면 해당 값의 첫번 째 인덱스를 반환
            // indexof 해서 i 랑 같으면 스트라이크고, -1이면 x i 랑 다르면 볼
            int[] result = getResult(computer, user);

            System.out.println(printResult(result));
            if (isSame(3, result[0])) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    // 결과를 프린트하는 메소드
    private static String printResult(int[] result) {
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
    private static int[] getResult(List<Integer> computer, List<Integer> user) {
        int[] result = new int[2];
        for (int idx = 0; idx < computer.size(); idx++) {
            addStrikeAndBall(result, idx, computer.indexOf(user.get(idx)));
        }
        return result;
    }

    // strike 와 ball 의 값을 증가시켜주는 메소드
    private static void addStrikeAndBall(int[] result, int idx, int idxOf) {
        if (isSame(idx, idxOf)) {
            result[0]++; // strike
            return;
        }
        if (isPositive(idxOf)) {
            result[1]++; // ball
            return;
        }
    }

    // 양수인지 아닌지 확인하는 메소드
    private static boolean isPositive(int idxOf) {
        return idxOf > 0;
    }

    // 파라미터 두개를 비교하는 메소드
    private static boolean isSame(int num, int idxOf) {
        return idxOf == num;
    }

    // 사용자 숫자 입력받는 메소드
    private static List<Integer> getUserNumber() {
        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        addInputNumber(user, getSplit());
        return user;
    }

    // 사용자의 숫자를 추가하는 메소드
    private static void addInputNumber(List<Integer> user, String[] userNumber) {
        for (Integer num : toInts(userNumber)) {
            user.add(num);
        }
    }

    // 입력받은 숫자를 분리하여 배열에 저장하는 메소드
    private static String[] getSplit() {
        return Console.readLine().split("");
    }

    // 분리하여 배열에 저장된 문자들을 숫자로 변환하는 메소드
    private static int[] toInts(String[] userNumber) {
        int[] numbers = new int[userNumber.length];
        for (int i = 0; i < userNumber.length; i++) {
            numbers[i] = Integer.parseInt(userNumber[i]);
        }
        return numbers;
    }

    // 컴퓨터 숫자 부여받는 메소드
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (isSize(computer)) {
            addRandomNumber(computer, Randoms.pickNumberInRange(1, 9));
        }
        return computer;
    }

    // 컴퓨터 리스트의 사이즈가 3 미만인지 확인하는 메소드
    private static boolean isSize(List<Integer> computer) {
        return computer.size() < 3;
    }

    // 컴퓨터의 숫자를 랜덤으로 추가하는 메소드
    private static void addRandomNumber(List<Integer> computer, int randomNumber) {
        if (isContains(computer, randomNumber)) {
            computer.add(randomNumber);
        }
    }

    // 중복된 숫자가 있는지 확인하는 메소드
    private static boolean isContains(List<Integer> computer, int randomNumber) {
        return !computer.contains(randomNumber);
    }
}