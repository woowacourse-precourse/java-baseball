package baseball;

public class Application {
    public static void main(String[] args) {
        Game.init();
    }
}
class Game {
    static final String INITGAME = "숫자 야구 게임을 시작합니다.";
    static void init() {
        System.out.println(INITGAME);
    }
}