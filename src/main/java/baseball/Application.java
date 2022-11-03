package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static int ballNumber = 0;
    public static int strikeNumber = 0;
    public static void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void finishAnnounce() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomNumber.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumber;
    }
    public static boolean isEnterNumberExcept(String userEnterNumber) {
        boolean isExcepted = false;
        List<Integer> OneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        if (userEnterNumber.length() != 3) {
            isExcepted = true;
        } else if (userEnterNumber.charAt(0) == userEnterNumber.charAt(1) || userEnterNumber.charAt(1) == userEnterNumber.charAt(2)
            || userEnterNumber.charAt(0) == userEnterNumber.charAt(2)) {
            isExcepted = true;
        }
        for (int i = 0; i < 3; i++) {
            if (!OneToNine.contains(Character.getNumericValue(userEnterNumber.charAt(i)))) {
                isExcepted = true;
            }
        }
        return isExcepted;
    }
    public static List<Integer> getEnterNumber(String userEnterNumber) {
        List<Integer> enterNumber = new ArrayList<>();
        if (!isEnterNumberExcept(userEnterNumber)) {
            for (int i = 0; i < 3; i++) {
                enterNumber.add(Character.getNumericValue(userEnterNumber.charAt(i)));
            }
        } else {
            throw new IllegalArgumentException("정확한 세 자리 숫자를 입력해주세요");
        }
        return enterNumber;
    }

    public static void countBallAndStrike(List<Integer> randomNumber, List<Integer> enterNumber) {
        for(int i = 0; i < 3; i++) {
            if(randomNumber.contains(enterNumber.get(i))) {
                ballNumber++;
            }
            if(randomNumber.get(i) == enterNumber.get(i)) {
                strikeNumber++;
                ballNumber--;
            }
        }
    }

    public static void announceBallAndStrike(List<Integer> randomNumber) {
        if (strikeNumber == 3) {
            finishAnnounce();
        if (Console.readLine().equals("1")) {
            game();
        } else if (Console.readLine().equals("2")) {
            System.exit(0);
        } else {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
        } else {
            if (ballNumber == 0 && strikeNumber == 0) {
            System.out.println("낫싱");
            } else if (ballNumber == 0){
                System.out.println(strikeNumber+"스트라이크");
            } else if (strikeNumber == 0) {
                System.out.println(ballNumber+"볼 ");
        } else {
                System.out.println(ballNumber+"볼 "+strikeNumber+"스트라이크");
        }
    public static void announceBallAndStrike(List<Integer> randomNumber, List<Integer> ballAndStrikeNumber) {
        if (strikeNumber == 3) {
            finishAnnounce();
            caseOfAllStrike(Console.readLine());
        } else {
            caseOfAllBallAndStrike(ballAndStrikeNumber);
            repeatGameUntilSuccess(randomNumber);
        }
    }
    public static void repeatGameUntilSuccess(List<Integer> randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        List<Integer> enterNumber = getEnterNumber(userEnterNumber);
        countBallAndStrike(randomNumber, enterNumber);
    }
    public static void game() {
        List<Integer> randomNumber = getRandomNumber();
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        List<Integer> enterNumber = getEnterNumber(userEnterNumber);
        List<Integer> ballAndStrikeNumber = countBallAndStrike(randomNumber, enterNumber);
        announceBallAndStrike(randomNumber, ballAndStrikeNumber);
    }

    public static void main(String[] args) {
        startAnnounce();
        String userEnterNumber = Console.readLine();
    }
}
