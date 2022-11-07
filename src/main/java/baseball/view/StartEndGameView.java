package baseball.view;

public class StartEndGameView extends GameView {
    private static final String OUTPUT_GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String OUTPUT_3STRIKE_ENDGAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OUTPUT_NEWGAME_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public void startGamePrint() {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_GAME_START);
        newLine(sb);
        print(sb.toString());
    }
    public void endGamePrint(){
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_3STRIKE_ENDGAME);
        newLine(sb);
        sb.append(OUTPUT_NEWGAME_OR_EXIT);
        newLine(sb);
        print(sb.toString());
    }

}
