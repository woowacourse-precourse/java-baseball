package baseball.view;

import baseball.controller.GameTest;
import baseball.domain.Baseball;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PrinterTest {
    public static final String requestInput = "숫자를 입력해주세요 : ";
    public static final String messageBall = "볼 ";
    public static final String messageStrike = "스트라이크";
    private static final String messageClear = "3개의 숫자를 모두 맞히셨습니다!";
    public static final String messageGameEnd = "게임 종료";
    private static final String messageShutDownCheck = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String messageNothing = "낫싱";


    public static void showRequestInput() {
        System.out.print(requestInput);
    }

    public static void showClear() {
        System.out.println(messageClear);
    }

    public static void showShutDownCheck() {
        System.out.println(messageShutDownCheck);
    }

    @Test
    void 체크결과출력() {
        List<Integer> answer = Arrays.asList(3,2,1);
        List<Integer> input1 = Arrays.asList(1,2,3);
        List<Integer> input2 = Arrays.asList(4,5,6);
        List<Integer> input3 = Arrays.asList(1,3,2);
        assertThat(printRoundResult(GameTest.checkAnswer(answer,input1))).isEqualTo("2볼 1스트라이크");
        assertThat(printRoundResult(GameTest.checkAnswer(answer,input2))).isEqualTo("낫싱");
        assertThat(printRoundResult(GameTest.checkAnswer(answer,input3))).isEqualTo("3볼");
    }

    // 결과 출력
    private String printRoundResult (Baseball game) {
        StringBuilder sb = new StringBuilder();
        if (game.getBall()!=0) {
            sb.append(game.getBall()+ PrinterTest.messageBall);
        }
        if (game.getStrike()!=0) {
            sb.append(game.getStrike() + PrinterTest.messageStrike);
        }
        if (game.getStrike()==0 && game.getBall()==0) {
            sb.append(PrinterTest.messageNothing);
        }
        return sb.toString().trim();
    }
}