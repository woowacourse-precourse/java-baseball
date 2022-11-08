package baseball;

import java.io.Console;
import java.util.Scanner;
import java.io.IOException;

public class Application {
    static int ball = 0;
    static int strike = 0;
    static int reset = 0;
    static int computer = 0;
    static String str_com;
    static int user = 0;
    static String str_user;
    static Scanner sc;

/*    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        sc = new Scanner(System.in);
        int i, j;
        computer();
        while (true) {
            strike = 0;
            ball = 0;
            System.out.print("숫자를 입력해주세요 : ");
            str_user = "";
            user = getUser();
            str_user = Integer.toString(user);
            playgame(str_user);
            score();
            if (strike == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                reset = sc.nextInt();
                if (reset == 1) // 새로 시작
                    computer();
                else if (reset == 2)
                    break;
            }
        }
        sc.close();
    }*/


/*    public static void computer() {
        int cnt = 0;
        computer = (int) (Math.random() * 899) + 100; // 100~999 중 1개 선택
        str_com = "";
        str_com = Integer.toString(computer); // 컴퓨터 입력받기
        while (true) {
            for (int i = 0; i < str_com.length(); i++) {
                for (int j = i + 1; j < str_com.length(); j++) {
                    if (str_com.charAt(i) == str_com.charAt(j)) {
                        cnt++;
                    }
                }
            }
            if (cnt != 0)
                computer = (int) (Math.random() * 899) + 100; // 랜덤 값이 "서로 다른 3자리의 수"가 나오게 만들어줌
            else
                break;
        }
    }*/

/*
    public static int getUser() {
        user = sc.nextInt(); // user 입력받기
        String string_user = Integer.toString(user);
        if(user < 100 || user > 999)
            throw new IllegalArgumentException();
        for (int i = 0; i < string_user.length(); i++) {
            if ((int) string_user.charAt(i) >= 0 && (int) string_user.charAt(i) <= 9)
                throw new IllegalArgumentException();
            for (int j = i + 1; j < string_user.length(); j++) {
                if (string_user.charAt(i) == string_user.charAt(j))
                    throw new IllegalArgumentException();
            }
        }

        return user;
    }
*/

    public static void playgame(String str_user) {
        int i, j;
        str_com = Integer.toString(computer);
        for (i = 0; i < str_com.length(); i++) {
            if (str_com.charAt(i) == str_user.charAt(i)) {
                strike++;
                continue;
            }
            for (j = 0; j < str_user.length(); j++) {
                if (i != j && str_com.charAt(i) == str_user.charAt(j)) {
                    ball++;
                    break;
                }
            }
        }
    }

/*    public static void score() {
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike != 0 && ball == 0)
            System.out.println(strike + "스트라이크");
        else if (strike == 0 && ball != 0)
            System.out.println(ball + "볼");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");
    }*/
}