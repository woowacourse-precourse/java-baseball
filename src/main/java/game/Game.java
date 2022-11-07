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
            enterNumber.resetNumber();
            count.resetCount();
            startGame();
        }
        if (!enterOneOrTwo.equals("1") && !enterOneOrTwo.equals("2")) {
            throw new IllegalArgumentException("숫자를 1, 2 중에 하나를 입력해주세요!");
        }
    }
    public void finishAnnounce() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void getCaseThreeStrike() {
        finishAnnounce();
        finishOrRestart(Console.readLine());
    }
    public void getCaseNotThreeStrike() {
        System.out.println(hint.printHint());
        enterNumber.resetNumber();
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
        enterNumber.getList(Console.readLine());
        count.calStrike(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        count.calBall(randomNumber.getRandomNumber(), enterNumber.getEnterNumber());
        separateCase();
    }
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumber.getList();
        repeatGameUntilSuccess();
    }
}
