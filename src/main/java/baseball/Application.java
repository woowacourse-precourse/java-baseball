package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
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


}
