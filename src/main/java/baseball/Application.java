package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        chooseResetOrExit();
    }

    static void startGame() {
    }

    static void chooseResetOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();

        if (s.equals("1")) {
            startGame();
        } else if (s.equals("2")) {
            return;
        }
    }
}
