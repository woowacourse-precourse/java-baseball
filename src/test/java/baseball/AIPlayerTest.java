package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class AIPlayerTest {

    @Test
    @DisplayName("시작 메시지 출력")
    public void printHelloMessage() {
        var emptyAnswer = "";
        var sut = new AIPlayer(emptyAnswer);

        var helloMessage = sut.helloMessage();

        assertEquals(helloMessage, "숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("숫자 입력 요구 메시지 출력")
    public void askForNumber() {
        var emptyAnswer = "";
        var sut = new AIPlayer(emptyAnswer);

        var askMessage = sut.askMessage();

        assertEquals(askMessage, "숫자를 입력해주세요 : ");
    }

    @Test
    @DisplayName("성공 메시지 출력")
    public void printSuccessMssage() {
        var emptyAnswer = "";
        var sut = new AIPlayer(emptyAnswer);

        var successMssage = sut.successMessage();

        assertEquals(successMssage, "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("게임 종료 메시지 출력")
    public void printRestartMessage() {
        var emptyAnswer = "";
        var sut = new AIPlayer(emptyAnswer);

        var restartMessage = sut.restartMessage();

        assertEquals(restartMessage, "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
