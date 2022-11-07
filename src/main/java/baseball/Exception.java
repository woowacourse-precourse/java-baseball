package baseball;

public class Exception {
    public static void inputSizeException(){
        throw new IllegalArgumentException(Print.SIZE_EXCEPTION_MSG);
    }
    public static void inputNumberDuplicate(){
        throw new IllegalArgumentException(Print.DUPLICATE_EXCEPTION_MSG);
    }
    public static void newGameNumberException(){
        throw new IllegalArgumentException(Print.NEWGAME_EXCEPTION_MSG);
    }
    public static void inputIsZeroException(){
        throw new IllegalArgumentException(Print.RANGE_EXCEPTION_MSG);
    }
    public static void numberOnlyException(){
        throw new NumberFormatException(Print.NUMBERONLY_EXCEPTION_MSG);
    }
}
