package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;


public class Application {
    public static void main(String[] args) {
        HashMap<String, Integer> is_in_progress = new HashMap<>();
        is_in_progress.put("state", 1);
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (is_in_progress.get("state") == 1) {
            Game.start();
            set_is_in_progress(is_in_progress);
        }
    }

    public static void set_is_in_progress(HashMap<String, Integer> is_in_progress) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            is_in_progress.put("state", Integer.parseInt(Console.readLine()));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

