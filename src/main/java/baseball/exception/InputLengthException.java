package baseball.exception;

public class InputLengthException {
    public static boolean isInputLengthThree(String[] inputArray)throws IllegalArgumentException{
        if(inputArray.length!=3){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
