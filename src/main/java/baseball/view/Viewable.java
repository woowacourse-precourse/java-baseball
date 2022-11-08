package baseball.view;

import baseball.uitls.Hints;

public interface Viewable {

    /**
     * 힌트를 받아 힌트를 출력하는 메서드이다.
     * @param hints Gameplayer와 Computer의 수를 비교한 결과 나오는 hints이다.
     */
    public void printHint(Hints hints);

    /**
     * 게임 시작 멘트를 출력하는 메서드이다.
     */
    public void printStart();

    /**
     * 게임 플레이중 입력을 유도하는 멘트를 출력하는 메서드이다.
     */
    public void printInput();

    /**
     * 게임이 종료되었을 때 출력하는 메서드이다.
     */
    public void printEnd();

    /**
     * 게임을 계속 진행할 것인지 물어보는 멘트를 출력하는 메서드이다.
     */
    public void printIsContinue();
}
