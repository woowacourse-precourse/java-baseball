package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    protected static int is_in_progress = 1;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (is_in_progress == 1) {
            Game.start();
            set_is_in_progress();
        }
    }

    public static void set_is_in_progress() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            is_in_progress = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

