package baseball;

import baseball.enums.Announcement;
import baseball.enums.BallCount;
import baseball.enums.Menu;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    public List<Integer> generateThreeDiffDigit() {
        List<Integer> integerList = new ArrayList<>();
        while (integerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!integerList.contains(randomNumber)) {
                integerList.add(randomNumber);
            }
        }
        return integerList;
    }

    public List<Integer> askInputThreeDiffDigit(Gamer gamer) {
        Announcement.INPUT_NUMBER.printAnnouncement();
        String input = gamer.inputThreeDiffDigit();
        return convertIntegerList(input);
    }

    private List<Integer> convertIntegerList(String str) {
        List<Integer> integerList = new ArrayList<>();

        String[] strArr = str.split("");
        for (String element:
                strArr) {
            Integer convertedElement = Integer.parseInt(element);
            integerList.add(convertedElement);
        }
        return integerList;
    }

    public void updateBallCount(List<Integer> threeDiffDigitOfGamer, Game game) {
        judgeBall(threeDiffDigitOfGamer, game);
        String ballCount = convertBallCountStr(game);
        game.setBallCount(ballCount);
    }

    private void judgeBall(List<Integer> threeDiffDigitOfGamer, Game game) {
        for (int idx = 0; idx < 3; idx++) {
            for (int jdx = 0; jdx < 3; jdx++) {
                int digitOfGame = game.getThreeDiffDigit().get(idx);
                int digitOfGamer = threeDiffDigitOfGamer.get(jdx);

                countBallType(digitOfGame, digitOfGamer, idx, jdx, game);
            }
        }
    }
    private void countBallType(int digitOfGame, int digitOfGamer, int idx, int jdx, Game game) {
        if (digitOfGame == digitOfGamer) {
            if (idx == jdx) {
                game.setNumberOfStrike(game.getNumberOfStrike() + 1);
            }
            if (idx != jdx) {
                game.setNumberOfBall(game.getNumberOfBall() + 1);
            }
        }
    }

    private String convertBallCountStr(Game game) {
        StringBuilder stringBuilder = new StringBuilder();

        if (game.getNumberOfBall() > 0) {
            stringBuilder.append(game.getNumberOfBall()).append(BallCount.BALL.getKorean());
        }
        if (game.getNumberOfStrike() > 0) {
            stringBuilder.append(game.getNumberOfStrike()).append(BallCount.STRIKE.getKorean());
        }

        if (game.getNumberOfBall() == 0 && game.getNumberOfStrike() == 0) {
            stringBuilder.append(BallCount.NOTHING.getKorean());
        }

        return String.valueOf(stringBuilder);
    }

    public boolean askReplay(Gamer gamer) {
        Announcement.ASK_REPLAY.printlnAnnouncement();
        String input = gamer.inputPlayAgainOrNot();

        return input.equals(Menu.REPLAY.getMenuNumber());
    }

}
