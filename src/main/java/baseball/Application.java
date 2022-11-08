package baseball;

public class Application {
    private static final String REPLAY_QUESTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";
    private static final int REPLAY = 1;
    private static final int NO_REPLAY = 2;

    public static void main(String[] args) {

        while (true) {
            GamePlayer.playGame();

            int replay = Integer.parseInt(
                    ConsoleInput.inputWithMessage(REPLAY_QUESTION)
            );

            if(checkReplay(replay)){
                return;
            }
        }
    }

    private static boolean checkReplay(int replay) {
        if (replay != REPLAY && replay != NO_REPLAY) {
            throw new IllegalArgumentException();
        }
        return replay == NO_REPLAY;
    }

}
