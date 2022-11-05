package model;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private int numSelecUser;

    public User() {
        this.numSelecUser = 0;
    }

    public void inputNumOfUser() {
        this.numSelecUser = this.getInputAllRightNumOfUser();
    }

    private int getInputAllRightNumOfUser() {
        // TODO : 숫자 받기
        String strInput = getString();
        // TODO : 숫자로 변환하면서 숫자인지 검증
        int numInput = parseIntFromStr(strInput);
        // TODO : 입력이 음수인지 확인
        isValidPositiveInt(numInput);
        // TODO : 길이가 3개인지
        isValidLength(strInput);
        // TODO : 서로 다른 수인지 확인
        isValidNumOfIndividually(strInput);
        return numInput;
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
        throw new IllegalArgumentException("양수를 입력해주세요.");
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
}
