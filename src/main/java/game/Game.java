package game;

import ballAndStrike.Count;
import ballAndStrike.Hint;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private RandomNumber randomNumber;
    private EnterNumber enterNumber;
    private Count count;
    private Hint hint;
    public Game() {
        randomNumber = new RandomNumber();
        enterNumber = new EnterNumber();
        count = new Count();
        hint = new Hint(count);
    }
    public void finishGame(String enterOneOrTwo) {
        if (enterOneOrTwo.equals("1")) {
            randomNumber.resetNumber();
            count.resetCount();
            startGame();
        }
        if (!enterOneOrTwo.equals("1") && !enterOneOrTwo.equals("2")) {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
    }
    public void caseOfThreeStrike() {
        Announce.finishAnnounce();
        String oneOrTwo = Console.readLine();
        finishGame(oneOrTwo);
    }
    public void caseOfNotThreeStrike() {
        hint.announceResult();
        count.resetCount();
        repeatGameUntilSuccess();
    }
    public void announceBallAndStrike() {
        if (count.getStrikeNumber() == 3) {
            caseOfThreeStrike();
        }
        if (count.getStrikeNumber() < 3) {
            caseOfNotThreeStrike();
        }
    }
    public void repeatGameUntilSuccess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();
        enterNumber.getList(userEnterNumber);

        count.calStrike(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        count.calBall(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());

        announceBallAndStrike();
    }
    public void startGame() {
        randomNumber.getList();
        repeatGameUntilSuccess();
    }
}
