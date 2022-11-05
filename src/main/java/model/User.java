package model;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private int numSelecUser;

    public User() {
        this.numSelecUser = 0;
    }

    public void inputNumOfUser() {
        numSelecUser = this.getInputAllRightNumOfUser();
    }

    private int getInputAllRightNumOfUser() {
        String strInput = getString();
        int numInput = parseIntFromStr(strInput);
        // TODO
        isValidUser(strInput, numInput);
        return numInput;
    }

    private void isValidUser(String strInput, int numInput) {
        isValidPositiveInt(numInput);
        isValidLength(strInput);
        isValidNumOfIndividually(strInput);
    }

    private String getString() {
        return readLine();
    }

    private int parseIntFromStr(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private boolean isValidPositiveInt(int num) {
        if (num > 0) {
            return true;
        }
        throw new IllegalArgumentException("숫자를 입력해주세요.");
    }

    private boolean isValidLength(String str) {
        if (str.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException("입력의 길이는 \"3\" 만 가능합니다.");
    }

    private boolean isValidNumOfIndividually(String str) {
        if (UseFunc.isNumOfIndividually(str)) {
            return true;
        }
        throw new IllegalArgumentException("각각의 다른 숫자를 입력해주세요.");
    }


    public int getNumSelecUser() {
        return numSelecUser;
    }

    public static User getInstanceUser() {
        return (new User());
    }
}
