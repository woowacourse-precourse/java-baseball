package model;

public class User {

    final String MSG_INPUT_NUM_INDIVIDUALLY = "각각의 다른 숫자를 입력해주세요.";

    final String MSG_INPUT_POSITIVE_NUM = "양수를 입력해주세요.";
    final String MSG_INPUT_LENGTH_ONLY_THREE = "입력의 길이는 \"3\" 만 가능합니다.";

    private int numSelecUser;

    public User() {
        this.numSelecUser = 0;
    }

    public void inputNumOfUser() {
        numSelecUser = this.getInputAllRightNumOfUser();
    }

    private int getInputAllRightNumOfUser() {
        String strInput = UseFunc.getString();
        int numInput = UseFunc.parseIntFromStr(strInput);
        isValidUser(strInput, numInput);
        return numInput;
    }

    private void isValidUser(String strInput, int numInput) {
        isValidPositiveInt(numInput);
        isValidLength(strInput);
        isValidNumOfIndividually(strInput);
    }


    private boolean isValidPositiveInt(int num) {
        if (num > 0) {
            return true;
        }
        throw new IllegalArgumentException(MSG_INPUT_POSITIVE_NUM);
    }


    private boolean isValidLength(String str) {
        if (str.length() == 3) {
            return true;
        }
        throw new IllegalArgumentException(MSG_INPUT_LENGTH_ONLY_THREE);
    }


    private boolean isValidNumOfIndividually(String str) {
        if (UseFunc.isNumOfIndividually(str)) {
            return true;
        }
        throw new IllegalArgumentException(MSG_INPUT_NUM_INDIVIDUALLY);
    }


    public int getNumSelecUser() {
        return numSelecUser;
    }

    public static User getInstanceUser() {
        return (new User());
    }
}
