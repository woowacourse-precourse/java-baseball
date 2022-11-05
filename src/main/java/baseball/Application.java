package baseball;

/**
 * 1. 게임 시작
 * 2. 컴퓨터의 랜덤 번호 100 ~ 999
 * 3. 사용자 입력 100 ~ 999(반복)
 * 4. 랜덤번호와 사용자 입력번호를 비교하여 볼, 스트라이크, 낫싱 판단(반복)
 * 5. 맞추면 게임 끝 다시시작 1, 종료 2
 */

/**
 * 컴퓨터 랜덤 값을 저장하는 기능
 * 사용자 입력을 받는 기능
 * 사용자 입력을 저장하는 기능
 * 볼, 스트라이크, 낫싱을 판단하는 기능
 * 사용자에게 진행 결과를 알려주는 기능
 * 결과
 */

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
