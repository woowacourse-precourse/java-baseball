package baseball;

import camp.nextstep.edu.missionutils.Console;

class Restart {
    private final static String YES = "1";
    private final static String NO = "2";
    private final String reply;

    Restart () {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        this.reply = Console.readLine();
    }

    boolean decide() {
        if (reply.equals(YES)) {
            return true;
        }
        return false;
    }

    boolean isValid() {
        if(reply.equals(YES) || reply.equals(NO)) {
            return true;
        }
        return false;
    }

}
