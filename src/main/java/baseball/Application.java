package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    // 1. 상대방(컴퓨터)의 숫자를 설정한다.
    private static List<Integer> getNumberOfComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 2. 사용자(User)의 컴퓨터를 설정한다.
    private static List<Integer> getNumberOfUser(List<Integer> user) {
        System.out.print("숫자를 입력해주세요 : ");
        String numOfUserString = Console.readLine();

        // 2-1 : 사용자의 입력값을 검증한다.
        try {
            isValidStringInputOfUser(numOfUserString);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // 2-2 : 사용자의 입력값을 List로 바꾼다.
        user = stringToList(numOfUserString);
        return user;
    }

    // 2-1 : 사용자의 입력값을 검증한다
    private static boolean isValidStringInputOfUser(String stringInputOfUser) throws IllegalArgumentException {

        int num = 0;

        // 1. 정수가 아닌 값을 입력했을 시 오류를 발생시킨다.
        try {
            num = Integer.parseInt(stringInputOfUser);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자입니다.");
        }

        // 2. 세 자리의 수가 아닌 경우 오류를 발생시킨다.
        if (num > 1000 || num < 100)
            throw new IllegalArgumentException("세 자리의 수가 아닙니다.");

        // 3. 서로 다른 세 자리의 수가 아닌 경우 오류를 발생시킨다.
        int hundreds = num / 100;
        int tens = (num % 100) / 10;
        int ones = num % 10;

        if (hundreds == tens || hundreds == ones || tens == ones) {
            throw new IllegalArgumentException("서로 다른 세 자리의 수가 아닙니다.");
        }

        return true;
    }

    // 2-2 : 사용자의 입력값을 List로 바꾼다.
    private static List<Integer> stringToList(String numOfUserString) {
        List<Integer> user = new ArrayList<>();
        int numOfUserInteger = Integer.parseInt(numOfUserString);

        user.add(numOfUserInteger / 100);
        user.add((numOfUserInteger % 100) / 10);
        user.add(numOfUserInteger % 10);

        return user;
    }

    // 3-1 : 재입력이 필요하면 true를 반환하고, 그렇지 않으면 false를 반환한다.
    private static boolean isNeedReEnter() {
        // 1. 3S가 나오지 못하는 경우 true를 반환한다.
//        return true;

        // 2. 3S가 나온 경우에는 false를 반환한다.
        return false;
    }

    // 3-2-1 : strike count하기
    private static int howMuchStrike(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    // 3-2-2 : ball count하기
    private static int howMuchBall(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;

        if (computer.get(0) == user.get(1) || computer.get(0) == user.get(2)) {
            ballCount++;
        }

        if (computer.get(1) == user.get(0) || computer.get(1) == user.get(2)) {
            ballCount++;
        }

        if (computer.get(2) == user.get(0) || computer.get(2) == user.get(1)) {
            ballCount++;
        }

        return ballCount;
    }

    // 3-2 : computer와 user을 비교하여 BallCount를 반환한다.
    private static String getBallCount(List<Integer> computer, List<Integer> user) {
        // 3-2-1. 스트라이크 count하기
        int countOfStrike = howMuchStrike(computer, user);

        // 3-2-2. 볼 conut하기
        int countOfBall = howMuchBall(computer, user);

        // 3. 두 문자열을 합쳐서 반환하기 ex) 1S + 1B -> return "1S1B";
        return countOfBall + "볼 " + countOfStrike + "스트라이크";
    }

    public static void main(String[] args) {

        // 1. 상대방(컴퓨터)의 숫자를 설정한다.
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        computer = getNumberOfComputer(computer);
        System.out.println("computer = " + computer); // 테스트 출력

        // 2. 사용자에게서 숫자를 입력받는다.
        List<Integer> user = new ArrayList<>();

        // 3. 사용자의 입력값에 따라 Ball Count를 출력한다.
        while (isNeedReEnter()) {
            user.clear();
            user = getNumberOfUser(user);

            String ballCount = getBallCount(computer, user); // ex) 1볼 1스트라이크
        }
    }


}