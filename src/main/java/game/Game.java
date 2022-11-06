package game;

import ballAndStrike.Count;
import ballAndStrike.Hint;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final RandomNumber randomNumber;
    private final EnterNumber enterNumber;
    private final Count count;
    private final Hint hint;
    public Game() {
        randomNumber = new RandomNumber();
        enterNumber = new EnterNumber();
        count = new Count();
        hint = new Hint(count);
    }
    public void finishOrRestart(String enterOneOrTwo) {
        if (enterOneOrTwo.equals("1")) {
            randomNumber.resetNumber();
            count.resetCount();
            startGame();
        }
        if (!enterOneOrTwo.equals("1") && !enterOneOrTwo.equals("2")) {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
    }
    public void getCaseThreeStrike() {
        Announce.finishAnnounce();
        String oneOrTwo = Console.readLine();
        finishOrRestart(oneOrTwo);
    }
    public void getCaseNotThreeStrike() {
        System.out.println(hint.printHint());
        count.resetCount();
        repeatGameUntilSuccess();
    }
    public void separateCase() {
        if (count.getStrikeNumber() == 3) {
            getCaseThreeStrike();
        }
        if (count.getStrikeNumber() < 3) {
            getCaseNotThreeStrike();
        }
    }
    public void repeatGameUntilSuccess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        enterNumber.getList(userEnterNumber);
        count.calStrike(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        count.calBall(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        separateCase();
    }
    public void startGame() {
        Announce.startAnnounce();
        randomNumber.getList();
        repeatGameUntilSuccess();
    }
}
