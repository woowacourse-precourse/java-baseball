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
        hint = new Hint();
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
    public void announceBallAndStrike() {
        // TODO: 변수명 바꾸던지 repeat에 넣던지
        if (count.getStrikeNumber() == 3) {
            Announce.finishAnnounce();
            String oneOrTwo = Console.readLine();
            finishGame(oneOrTwo);
        }
        if (count.getStrikeNumber() < 3) {
            System.out.println(hint.announceResult());
            repeatGameUntilSuccess();
        }
    }
    public void repeatGameUntilSuccess() {
        System.out.print("숫자를 입력해주세요 : ");
        String userEnterNumber = Console.readLine();

        enterNumber.getList(userEnterNumber);
        // TODO: 테스트 완료되면 지울 것
        System.out.println(enterNumber.getEnterNumber());

        count.calStrike(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        count.calBall(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        // TODO: 테스트 완료되면 지울 것
        System.out.println(count.getStrikeNumber() + " " + count.getBallNumber());
        announceBallAndStrike();

        count.resetCount();
    }
    public void startGame() {
        randomNumber.getList();
        repeatGameUntilSuccess();
    }
}
