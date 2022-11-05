package baseball.controller;

public class Valid {

    private boolean isNumOneToNine(int num) {
        if (num >= 1 && num <= 9) {
            return true;
        } else {
            return false;
        }
    }

}
