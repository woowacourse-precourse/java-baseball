package baseball;

public class GameStart {

    public void Start() {
        do {
            gameStart();
        } while (confirmUserFinalInput());
    }

    private static void gameStart() {
        ComputerNums computerNums = new ComputerNums(3);
        boolean allStrike;
        do {
            BaseballCount baseballCount = new BaseballCount(computerNums.getNumbers(), new UserNums(UserInput.startInput()).getNumbers());
            new SystemOutput(baseballCount);
            allStrike = AllStrike(baseballCount);
        } while (!allStrike);
        SystemOutput.allStrikeMessage();
    }

    private static boolean confirmUserFinalInput() {
        String userfinalinput = UserInput.endInput();
        if (gameEnd(userfinalinput)) {
            return true;
        }
        if (gameRe(userfinalinput)) {
            return false;
        }
        throw new IllegalArgumentException("1이나 2가 아닙니다.");

    }

    private static boolean gameEnd(String userfinalinput) {
        return userfinalinput.equals("1");
    }

    private static boolean gameRe(String userfinalinput) {
        return userfinalinput.equals("2");
    }

    private static boolean AllStrike(BaseballCount baseballCount) {
        return baseballCount.getStrikecount() == 3;
    }


}
