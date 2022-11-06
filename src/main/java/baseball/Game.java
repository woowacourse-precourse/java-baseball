package baseball;

public class Game {

    private static final int END_GAME = 2;

    private static Player player;
    private static Answer answer;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void start() {
        do {
            set();
            progress();
        } while (player.choose() != END_GAME);
    }

    public static void set() {
        player = new Player();
        answer = new Computer().createAnswer();
    }

    public static void progress(){
        while (true) {
            if (player.guess(answer)) {
                break;
            }
        }
    }
}
