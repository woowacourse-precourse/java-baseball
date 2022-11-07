package baseball.view;

public class StartEndGameView extends GameView {
    private static final String OUTPUT_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OUTPUT_ENDGAME = "게임 종료";
    private static final String OUTPUT_NEWGAME_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGamePrint() {
        outputBuilder(OUTPUT_GAME_START);
    }
    public void successGamePrint(){
        output = new StringBuilder();
        output.append(OUTPUT_SUCCESS);
        newLine();
        outputBuilder(OUTPUT_NEWGAME_OR_EXIT);
    }

    public void endGamePrint() {
        outputBuilder(OUTPUT_ENDGAME);
    }
}
