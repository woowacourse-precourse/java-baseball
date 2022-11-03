package baseball;

public class PlayerInputFilter {
    private int[] numbers;

    public PlayerInputFilter(){
        numbers = new int[3];
    }

    String getInput(){
        return "";
    }

    void checkException(String input){

    }

    boolean isNotNumber(String input){
        return false;
    }

    void noNumberException(){

    }

    boolean isNotThreeDigit(String input){
        return false;
    }

    void notThreeDigitException(){

    }

    boolean containsZero(String input){
        return false;
    }

    void containsZeroException(){

    }

    boolean containsSameNumber(String input){
        return false;
    }

    void containsSameNumberException(){

    }

    int[] convertNumbersToArray(String input){
        return new int[]{};
    }

    void insertNumber(){

    }
}
