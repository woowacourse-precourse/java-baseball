package baseball.view;

/**
 * 이 인터페이스를 구현하면 게임과 컨트롤러에서 발생하는 에러를 여기로 출력해줍니다
 */
public interface ErrorView {
    void printError(String content);
}
