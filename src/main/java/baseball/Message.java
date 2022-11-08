package baseball;

class Message {

    static class GameMessage {
        private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
        private static final String ENTER_BASEBALLLIST = "숫자를 입력해주세요 : ";
        private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        private static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        public static void printGameStart() {
            System.out.println(GAME_START);
        }
        public static void printEnterBasebllList() {
            System.out.println(ENTER_BASEBALLLIST);
        }
        public static void printGameOver() {
            System.out.println(GAME_OVER);
        }
        public static void printRestartGame() {
            System.out.println(RESTART_GAME);
        }
    }
}
