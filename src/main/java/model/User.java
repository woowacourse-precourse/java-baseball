package model;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public int numSelecUser;

    public User() {
        this.numSelecUser = 0;
    }

    public void choiceNum() {
        // TODO : 숫자의 검증
        // TODO : 숫자인지?
        // TODO : 길이가 3개인지
        // TODO : 문자열인지 or 정수인지
    }

    public String getString() {
        String strInput = "";
        strInput = readLine();
        return strInput;
    }


    public int parseIntFromStr(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public boolean isValidLength(String str) throws IllegalArgumentException {
        if (str.length() == 3) {
            return true;
        } else {
            throw new IllegalArgumentException("입력의 길이는 \"3\" 만 가능합니다.");
        }
    }


}
