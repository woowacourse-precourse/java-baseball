package baseball;

public class Error_check {
    private String target;

    Error_check(String target){
        this.target = target;
    }

    private boolean check_input_lenght() {
        if (this.target.length() != 3) {
            return false;
        }
        return true;
    }

    private boolean check_isnum() {
        int temp_num = 0;
        for (int i = 0; i < this.target.length(); i++) {
            temp_num = Character.getNumericValue(this.target.charAt(i));
            if (!(temp_num > 0 && temp_num < 10)) {
                return false;
            }
        }
        return true;
    }

    private boolean check_duplicate() {
        int[] check_array = new int[10];
        int now_value = 0;

        for (int i = 0; i < this.target.length(); i++) {
            now_value = Character.getNumericValue(this.target.charAt(i));
            check_array[now_value] += 1;
            if (check_array[now_value] > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean launch_input_check() {
        if (check_input_lenght() == false) {
            return false;
        }
        if (check_isnum() == false) {
            return false;
        }
        if (check_duplicate() == false) {
            return false;
        }
        return true;
    }
}
