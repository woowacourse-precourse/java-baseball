package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        boolean status = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (status) {
            Game game = new Game();
            game.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String line = Console.readLine();
            validInputReplay(line);
            if (wantExit(line)) {
                status = false;
                System.out.println("게임 종료");
            }
        }
    }

    private static void validInputReplay(String line) {
        if (!(wantRestart(line) || wantExit(line))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean wantRestart(String line) {
        return "1".equals(line);
    }

    private static boolean wantExit(String line) {
        return "2".equals(line);
    }

}
