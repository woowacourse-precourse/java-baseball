package model;

public class User {

    final int NUM_RESTART_GAME = 1;
    final int NUM_END_GAME = 2;
    final String MSG_INPUT_NUM_INDIVIDUALLY = "각각의 다른 숫자를 입력해주세요.";

    final String MSG_INPUT_POSITIVE_NUM = "양수를 입력해주세요.";
    final String MSG_INPUT_LENGTH_ONLY_THREE = "입력의 길이는 \"3\" 만 가능합니다.";

    private int numSelecUser;
    private int numProceedUser;

    public User() {
        this.numSelecUser = 0;
        this.numProceedUser = 0;
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

    public void InputProceedNum() {
        String strInput = UseFunc.getString();
        int numInput = UseFunc.parseIntFromStr(strInput);
        isValidPositiveInt(numInput);
        isValidEndReGameNum(numInput);
        this.numProceedUser = numInput;
    }

    private void isValidEndReGameNum(int num) {
        if (num == NUM_RESTART_GAME || num == NUM_END_GAME) {
            return;
        }
        throw new IllegalArgumentException(MSG_INPUT_POSITIVE_NUM);
    }

    public int getNumProceedUser() {
        return numProceedUser;
    }

    private void isValidUser(String strInput, int numInput) {
        isValidPositiveInt(numInput);
        isValidLength(strInput);
        isValidNumOfIndividually(strInput);
    }


    private void isValidPositiveInt(int num) {
        if (num > 0) {
            return;
        }
        throw new IllegalArgumentException(MSG_INPUT_POSITIVE_NUM);
    }


    private void isValidLength(String str) {
        if (str.length() == 3) {
            return;
        }
        throw new IllegalArgumentException(MSG_INPUT_LENGTH_ONLY_THREE);
    }


    private void isValidNumOfIndividually(String str) {
        if (UseFunc.isNumOfIndividually(str)) {
            return;
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
