package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseballTest {
    Baseball baseball = new Baseball();
    @Test
    void 메시지_상수로_구분하기() {
        Assertions.assertEquals(Message.ASK, "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Assertions.assertEquals(Message.CLEAR, "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        Assertions.assertEquals(Message.INPUT, "숫자를 입력해 주세요 : ");
        Assertions.assertEquals(Message.BALL, "볼");
        Assertions.assertEquals(Message.STRIKE, "스트라이크");
        Assertions.assertEquals(Message.NOTHING, "낫싱");
        Assertions.assertEquals(Message.START, "숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 사용자_변수_난수_초기화하기() {
        Assertions.assertEquals(baseball.getUserNumber(), "");
        Assertions.assertEquals(baseball.getRandomNumber(), "");
    }

    @Test
    void 세자리_난수_생성하기() {
        baseball.initialize();
        String randomNumber = baseball.getRandomNumber();

        Assertions.assertEquals(randomNumber.length(), 3);

        boolean flag = true;
        for (int i = 0; i < randomNumber.length(); i++) {
            if(randomNumber.indexOf(randomNumber.toCharArray()[i]) != i) {
                flag = false;
            }
        }

        Assertions.assertEquals(flag, true);
    }
}
