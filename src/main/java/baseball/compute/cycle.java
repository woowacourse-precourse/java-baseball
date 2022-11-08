package baseball.compute;

import baseball.Application;

public class cycle {
    public static void restart(String sign) {
        if (sign.equals("1")) {
            Application.game();
        }
        else if(sign.equals("2")) {
            System.out.println("게임 종료");
        }else {
            System.out.println("1이나 2를 입력해주세요.");
        }

    }
}
