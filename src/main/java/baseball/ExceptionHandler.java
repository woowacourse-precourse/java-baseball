package baseball;

public class ExceptionHandler {
    public void checkIsDigit(String userNumber){
        for (int i = 0; i<userNumber.length(); i++){

            if (!Character.isDigit(userNumber.charAt(i))){
                throw new IllegalArgumentException("입력한 값에 숫자가 아닌 값이 포함되어 있습니다.");
            }

        }
    }

    public void checkIsValidLength(String userNumber){
        if (userNumber.length() != 3){
            throw new IllegalArgumentException("입력한 값이 세자리 숫자가 아닙니다.");
        }
    }

    public void checkIsValidRestartInput(String restartInput){
        if (!"12".contains(restartInput)){
            throw new IllegalArgumentException("입력한 값이 1이나 2가 아닙니다.");
        }
    }
}
