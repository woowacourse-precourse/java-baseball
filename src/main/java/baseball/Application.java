package baseball;

public class Application {
    public static void main(String[] args) {
        boolean agreeRestart;

        do {
            String computerNumber = Input.computer();
            boolean has3Strikes;

            do {
                String playerNumber = Input.player();
                Input.checkError(playerNumber);
                PlayBaseball game = new PlayBaseball(computerNumber, playerNumber);
                game.countStrikes();
                game.countBalls();
                game.printBallCounts();
                has3Strikes = game.check3Strikes();
            } while (!has3Strikes);

            boolean isValidReply;

            do {
                Restart reply = new Restart();
                agreeRestart = reply.decideRestart();
                isValidReply = reply.checkValidity();
            } while (!isValidReply);
        } while (agreeRestart);
    }
}
