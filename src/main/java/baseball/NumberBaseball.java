package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class NumberBaseball implements Game {
    static final int LENGTH_OF_BASEBALL_NUMBER = 3;
    static final int MAXIMUM_STRIKE = 3;

    private int strikeCount;
    private int ballCount;
    private String computer;
    private String user;

    NumberBaseball () {}

    @Override public void play() throws IllegalArgumentException {
        strikeCount = 0;
        ballCount = 0;
        setComputerNumberInString();
        while (strikeCount != MAXIMUM_STRIKE) {
            user = Game.getUserAnswerInString("숫자를 입력해주세요 : ");
            isValidBaseballNumber();
            compareComputerAndUser();
            printResult();
        }
    }

    @Override public int choiceRestartOrExit() throws IllegalArgumentException {
        String userAnswer = Game.getUserAnswerInString("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if (!isValidAnswer(userAnswer)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(userAnswer);
    }

    private boolean isValidAnswer(String userAnswer) {
        return userAnswer.equals(String.valueOf(START)) || userAnswer.equals(String.valueOf(EXIT));
    }

    private void isValidBaseballNumber() throws IllegalArgumentException {
        boolean userIsValid =
                isValidValue() && isValidLength() && isValidOfDuplication();
        if (!userIsValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidLength() {
        return user.length() == LENGTH_OF_BASEBALL_NUMBER;
    }

    private boolean isValidOfDuplication() {
        return user.length() == user.chars().distinct().count();
    }

    private boolean isValidValue() {
        boolean result = true;
        try {
            Integer.valueOf(user);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private void compareComputerAndUser() {
        strikeCount = Game.countSameLetterInSameIndexWithoutDuplicate(user, computer);
        ballCount = Game.countSameLetterInDifferentIndexWithoutDuplicate(user, computer);
    }

    private void printResult() {
        if (strikeCount == MAXIMUM_STRIKE) {
            printThreeStrike();
        } else if (strikeCount == 0 && ballCount == 0) {
            printNothingMatch();
        } else {
            printScore();
        }
    }

    private void printNothingMatch() {
        System.out.println("낫싱");
    }

    private void printThreeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printScore() {
        System.out.printf("%d볼 %d스트라이크\n", ballCount, strikeCount);
    }

    private void setComputerNumberInString() {
        computer = "";
        while (computer.length() < LENGTH_OF_BASEBALL_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(String.valueOf(randomNumber))) {
                computer += randomNumber;
            }
        }
    }
}
