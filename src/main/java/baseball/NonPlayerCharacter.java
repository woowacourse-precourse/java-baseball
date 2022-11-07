package baseball;

public class NonPlayerCharacter {
    private static final int NOTHING = -1;
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int DIGITS_OF_RANDOM_NUMBER = 3;

    RandomNumber randomNumber = RandomNumber.getInstance();

    static int[] numberOfBallAndStrike;

    public void printGameStartNotice() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printNumberInputNotice() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameEndNotice() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean isStrike(char input, int index) {
        return randomNumber.toString().charAt(index) == input;
    }


}
