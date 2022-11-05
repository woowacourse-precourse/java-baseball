package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.opening());

        do {
            game.doGame(); // 게임을 수행한다. (컴퓨터의 랜덤 발생, 사용자 입력 받기, 비교하기, 정답인 경우 return )
        } while (true);
    }
}
