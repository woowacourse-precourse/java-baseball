package baseball;

import baseball.enums.Announcement;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Announcement.GAME_START.printlnAnnouncement();

        Gamer gamer = new Gamer();
        GameMachine gameMachine = new GameMachine();

        boolean playFlag = true;
        while (playFlag) {
            Game game = new Game();
            List<Integer> integerList = gameMachine.generateThreeDiffDigit();
            game.setThreeDiffDigit(integerList);

            while (game.getNumberOfStrike() != 3) {
                game.initializeBallCount();

                List<Integer> threeDiffDigitOfGamer = gameMachine.askInputThreeDiffDigit(gamer);
                gameMachine.updateBallCount(threeDiffDigitOfGamer, game);

                System.out.println(game.getBallCount());
            }
            Announcement.GAME_END.printlnAnnouncement();

            playFlag = gameMachine.askReplay(gamer);
        }
    }
}
