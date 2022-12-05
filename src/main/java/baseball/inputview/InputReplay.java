package baseball.inputview;

import camp.nextstep.edu.missionutils.Console;

public class InputReplay {

    public int run() {
        printMessage();
        return input();
    }

    public void printMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public int input() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
