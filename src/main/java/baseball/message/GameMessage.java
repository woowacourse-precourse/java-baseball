package baseball.message;

public interface GameMessage {
    String START_GAME = "숫자 야구 게임을 시작합니다.";
    String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    String WIN = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String NEW_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    String APPLICATION_END = "애플리케이션을 종료합니다.";
    String STRIKE = "스트라이크";
    String BALL = "볼";
    String NOTHING = "낫싱";
}
