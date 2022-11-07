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

    public void printComparisonResult() {
        System.out.println(makeResultString());
    }

    public void printGameEndNotice() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public String makeResultString() {
        if (numberOfBallAndStrike[BALL] == 0 && numberOfBallAndStrike[STRIKE] == 0) {
            return "낫싱";
        }
        if (numberOfBallAndStrike[BALL] == 0) {
            return "3스트라이크";
        }
        if (numberOfBallAndStrike[STRIKE] == 0) {
            return "3볼";
        }
        return numberOfBallAndStrike[BALL] + "볼 " + numberOfBallAndStrike[STRIKE] + "스트라이크";
    }

    public void countNumberOfBallAndStrike(int input) {
        numberOfBallAndStrike = new int[3];
        String inputString = String.valueOf(input);

        for (int index = 0; index < DIGITS_OF_RANDOM_NUMBER; index++) {
            char digit = inputString.charAt(index);
            int comparisonResult = compareWithRandomNumber(digit, index);

            if (comparisonResult == NOTHING) {
                continue;
            }

            numberOfBallAndStrike[comparisonResult] += 1;
        }
    }

    public int compareWithRandomNumber(char digit, int index) {
        if (isStrike(digit, index)) {
            return STRIKE;
        }
        if (isBall(digit)) {
            return BALL;
        }
        return NOTHING;
    }

    public boolean isStrike(char input, int index) {
        return randomNumber.toString().charAt(index) == input;
    }

    public boolean isBall(char input) {
        return randomNumber.toString().contains(Character.toString(input));
    }

}
