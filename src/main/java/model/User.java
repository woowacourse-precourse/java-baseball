package model;

import utill.ConstantVO;
import utill.UseFunc;

public class User {


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

    public void inputProceedNum() {
        String strInput = UseFunc.getString();
        int numInput = UseFunc.parseIntFromStr(strInput);
        isValidPositiveInt(numInput);
        isValidEndReGameNum(numInput);
        this.numProceedUser = numInput;
    }

    private void isValidEndReGameNum(int num) {
        if (num == ConstantVO.NUM_RESTART_GAME || num == ConstantVO.NUM_END_GAME) {
            return;
        }
        throw new IllegalArgumentException(ConstantVO.MSG_INPUT_POSITIVE_NUM);
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
        throw new IllegalArgumentException(ConstantVO.MSG_INPUT_POSITIVE_NUM);
    }


    private void isValidLength(String str) {
        if (str.length() == 3) {
            return;
        }
        throw new IllegalArgumentException(ConstantVO.MSG_INPUT_LENGTH_ONLY_THREE);
    }


    private void isValidNumOfIndividually(String str) {
        if (UseFunc.isNumOfIndividually(str)) {
            return;
        }
        throw new IllegalArgumentException(ConstantVO.MSG_INPUT_NUM_INDIVIDUALLY);
    }


    public int getNumSelecUser() {
        return numSelecUser;
    }

    public static User getInstanceUser() {
        return (new User());
    }
}
