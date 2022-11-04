package baseball;

public class CheckUtil {

    public void checkIsValidDigit(String input){
        for(char c:input.toCharArray()){
            int c_int = Character.getNumericValue(c);
            if(c_int<1 || c_int>9){
                throw new IllegalArgumentException("1-9 사이의 유효한 숫자만 입력하세요.");
            }
        }
    }

    public void checkIsValidLength(int length){
        if(length != 3){
            throw new IllegalArgumentException("3자리 숫자만 입력하세요.");
        }
    }
}
