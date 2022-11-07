package baseball;

abstract class ErrorCheck {
    private String target;

    ErrorCheck(String target){
        this.target = target;
    }

    abstract boolean checkInputLenght();

    private boolean checkIsNum() {
        int tempNumber = 0;
        for (int i = 0; i < this.target.length(); i++) {
            tempNumber = Character.getNumericValue(this.target.charAt(i));
            if (!(tempNumber > 0 && tempNumber < 10)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicate() {
        int[] check_array = new int[10];
        int nowValue = 0;

        for (int i = 0; i < this.target.length(); i++) {
            nowValue = Character.getNumericValue(this.target.charAt(i));
            check_array[nowValue] += 1;
            if (check_array[nowValue] > 1) {
                return false;
            }
        }
        return true;
    }

    private void throwException() {
        throw new IllegalArgumentException();
    }

    public void launchErrorCheck() {
        if (checkInputLenght() == false) {
            throwException();
        }
        if (checkIsNum() == false) {
            throwException();
        }
        if (checkDuplicate() == false) {
            throwException();
        }
    }
}

class OneValueCheckError extends ErrorCheck {
    private String target;
    OneValueCheckError(String target) {
        super(target);
        this.target = target;
    }

    public boolean checkInputLenght() {
        if (target.length() == 1) {
            return true;
        }
        return false;
    }
}

class ThreeValueCheckError extends ErrorCheck {
    private String target;
    ThreeValueCheckError(String target) {
        super(target);
        this.target = target;
    }

    public boolean checkInputLenght() {
        if (target.length() == 3) {
            return true;
        }
        return false;
    }
}
