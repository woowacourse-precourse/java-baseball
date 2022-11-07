package baseball.view;

import baseball.service.GameService;

public class OrderView {
    public static void startOrder(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(GameService.makeRandomBall());
    }
    public static void inputOrder(){
        System.out.print("숫자를 입력해주세요 : ");
    }
}