package baseball;

public class BaseballGameConsole {

    private final Validator validator = new Validator();
    private final Computer computer = new Computer();

    public void playGame(Player player) {
        startingGuide(player.getName());
        do {
            playSingleGame(player);
        } while (true); // Ask player to play a new game
    }

    private void startingGuide(String playerName) {
        System.out.println(playerName + "반갑습니다.");
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void playSingleGame(Player player) {
        boolean matchedAllNumber = false;
        String randomNumber = computer.selectRandomNumber();

        do {
            System.out.println("숫자를 입력해주세요. :");
            String predictedNumber = player.predictNumber();
            validator.validatePrediction(predictedNumber);

            Result result = computer.resultOfPrediction(randomNumber, predictedNumber);
            // Update matchedAllNumber

            // Show result message
        } while (!matchedAllNumber);
    }
}
