package baseball;

public class BaseballGameConsole {

    public void playGame(Player player) {
        startingGuide(player.getName());
        do {
            // Play single baseball game
        } while (true); // Ask player to play a new game
    }

    private void startingGuide(String playerName) {
        System.out.println(playerName + "반갑습니다.");
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
