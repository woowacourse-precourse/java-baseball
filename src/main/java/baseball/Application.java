package baseball;

public class Application {
    static final int EXIT_GAME = 2;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean is_quit = false;
        while (!is_quit) {
            Game.startGame();
            // if문 2번 쓰면 error 반환
            // TODO 입력값 요청 및 저장, int 반환이 한번에 있는 구조 Refactoring할 필요성
            if (Game.ResetGameOrQuit() == EXIT_GAME) {
                is_quit = true;
            }
        }
    }
}