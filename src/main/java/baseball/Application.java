package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameContinue = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameContinue == 1){
            BaseBallGame.baseBallGame();
            gameContinue = Integer.parseInt(GameContinueInput.gameContinue());
        }

    }
}
