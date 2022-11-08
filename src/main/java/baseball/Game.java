package baseball;

public class Game {
    public static final boolean CORRECT_ANSWER = true;
    private String userNumber = "";
    private String computerNumber = "";
    private NumberMaker numberMaker;

    public Game() {
        numberMaker = new NumberMaker();
    }

    public void playGame() {
        computerNumber = numberMaker.getComputerNumber();
        while (true) {
            userNumber = numberMaker.getUserNumber();
            printStrikeBallResult(userNumber, computerNumber);
            if (numberResult(userNumber, computerNumber) == CORRECT_ANSWER) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void printStrikeBallResult(String userNumber, String computerNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strikeCount++;
            } else if (computerNumber.contains(userNumber.substring(i, i + 1))) {
                ballCount++;
            }
        }
        if (ballCount + strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }
    }

    private boolean numberResult(String userNumber, String computerNumber) {
        return userNumber.equals(computerNumber);
    }
}
