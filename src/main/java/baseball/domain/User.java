package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private String baseballNumber;
    private String restartSelection;

    public String getBaseballNumber() {
        return baseballNumber;
    }

    public String getRestartSelection() {
        return restartSelection;
    }

    /**
     * 도메인 로직
     */
    public void inputBaseballNumber() {
        this.baseballNumber = Console.readLine();
    }

    public void selectRestart() {
        this.restartSelection = Console.readLine();
    }

    public boolean isValidSelection() {
        if (restartSelection.length() != 1)
            return false;

        if (!Character.isDigit(restartSelection.charAt(0)))
            return false;

        int selection = Integer.parseInt(restartSelection);
        return selection == 1 || selection == 2;
    }

    public boolean isValidNumber() {
        if (baseballNumber.length() != 3)
            return false;

        long count = baseballNumber.chars()
                .distinct()
                .filter(Character::isDigit)
                .filter(o -> o != '0')
                .count();

        return count == 3;
    }
}
