package baseball;

public class Application {

    static class BaseBall {

        public BaseBall() {

        }

        public void game() {
            gameInit();
            gamePrepare();
        }

        private void gameInit() {
            printOpeningStatus();
        }

        private void printOpeningStatus() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        private void gamePrepare() {
            makeGoal();
        }
    }

    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        baseBall.game();
    }
}
