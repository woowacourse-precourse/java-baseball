package baseball;

public class ErrorCheck {
    private String target;

    ErrorCheck(String target){
        this.target = target;
    }

    private boolean checkInputLenght() {
        if (this.target.length() == 3) {
            return true;
        }
        return false;
    }

    private boolean checkInputLenght(int type) {
        if (this.target.length() == 1) {
            return true;
        }
        return false;
    }

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

    public boolean launchErrorCheck() {
        if (checkInputLenght() == false) {
            return false;
        }
        if (checkIsNum() == false) {
            return false;
        }
        if (checkDuplicate() == false) {
            return false;
        }
        return true;
    }

    public boolean launchErrorCheck(int type) {
        if (checkInputLenght(type) == false) {  //오버 로딩을 통해서 타입별 렝스 길이 체크(1자릿수 체크 메서드)
            return false;
        }
        if (checkIsNum() == false) {
            return false;
        }
        if (checkDuplicate() == false) {
            return false;
        }
        return true;
    }
}
