package baseball;

public class CheckInput {
    public static boolean isInput(String value) {

        if(value.length() != 3){ // 3자리 글자인지 확인
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){ // 숫자만 넣었는지 확인
            if(!Character.isDigit(value.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        if(!duplicationCheck(value)){ // 중복 값 확인
            throw new IllegalArgumentException();
        }
        return false;
    }

    public static boolean duplicationCheck(String str) {
        int a = str.charAt(0) - '0';
        int b = str.charAt(1) - '0';
        int c = str.charAt(2) - '0';

        if(a != b && a != c && b != c) {
            return true;
        } else {
            return false;
        }
    }
}
