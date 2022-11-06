package baseball;

public class Application {

    private void start_game() {
        // 기능 요구사항 1번
    }
    private void make_RandomNum() {
        // 기능 요구사항 2번
    }

    private void input_PlayerNum() {
        // 기능 요구사항 3번
    }

    private void get_BallAndStrikeCount() {
        // 기능 요구사항 4번
    }

    private void progress_GameRule() {
        // 기능 요구사항 5번
    }

    private void close_game() {
        // 기능 요구사항 6번
    }

    private void play() {
        start_game();
        make_RandomNum();
        input_PlayerNum();
        get_BallAndStrikeCount();
        progress_GameRule();
        close_game();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.play();

    }
}
