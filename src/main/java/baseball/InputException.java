package baseball;

public class InputException {
    public void inputEmptyException(String input) throws IllegalArgumentException{
        if (input.isEmpty()) {
            throw new IllegalArgumentException("inputEmptyException");
        }
    }

    public void inputNotThreeNumberException(String input) throws IllegalArgumentException{
        inputEmptyException(input);

        if(input.length()!=3){
            throw new IllegalArgumentException("inputNotThreeNumberException: input length is not 3");
        }
        
        for(int location=0; location<3; location++){
            if(input.charAt(location)<'0' || '9'<input.charAt(location)){
                throw new IllegalArgumentException("inputNotThreeNumberException: input is not number");
            }
        }
    }

    public void inputNotOneOrTwoException(String input) throws IllegalArgumentException{
        inputEmptyException(input);

        if(input.length()!=1){
            throw new IllegalArgumentException("inputNotOneOrTwoException: input length is not 1");
        }

        if(input.charAt(0)!='1' && input.charAt(0)!='2'){
            throw new IllegalArgumentException("inputNotOneOrTwoException: input is not 1 or 2");
        }
    }
}