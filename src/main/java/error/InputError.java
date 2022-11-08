package error;

public class InputError {

    public static boolean digitIsNotThree(int num) {
        if (num < 100 || num > 999)
            return true;
        else
            return false;
    }
}
