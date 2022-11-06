package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }//public static void main

    public static List<Integer> getUserNumber() {
        List<Integer> user = new ArrayList<>();
        String userRandomNumber = "";
        int i = 0;

        System.out.print("숫자를 입력해주세요: ");
        userRandomNumber = exceptReadingLine(Console.readLine());
        while (user.size() < 3) {
            if (!user.contains(userRandomNumber.substring(i, i + 1))) {
                user.add(Integer.parseInt(userRandomNumber.substring(i, i + 1)));
                i++;
            }
        }
        return user;
    }//public static void userNumber

    public static String exceptReadingLine(String readLine) {
        if (readLine.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력. 시스템 종료");
        }
        if (readLine.charAt(0) == readLine.charAt(1) || readLine.charAt(1) == readLine.charAt(2) || readLine.charAt(0) == readLine.charAt(2)) {
            throw new IllegalArgumentException("잘못된 입력. 시스템 종료");
        }
        if (!readLine.matches("-?\\d+")) {
            throw new IllegalArgumentException("잘못된 입력. 시스템 종료");
        }
        return readLine;
    }//public static String exceptReadingLine

    public static List<Integer> getEnemyNumber() {
        List<Integer> enemy = new ArrayList<>();

        while (enemy.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!enemy.contains(randomNumber)) {
                enemy.add(randomNumber);
            }
        }
        return enemy;
    }//public static void enemyNumber

}
