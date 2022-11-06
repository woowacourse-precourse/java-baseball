package baseball.utils;

public class Exceptions {

    public static void isNumber(String str){
        for (int i=0; i<3; i++){
            if (str.charAt(i)>'9' || str.charAt(i)<'0'){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void checkNumSize(String str){
        if (str.length()!=3){
            throw new IllegalArgumentException();
        }
    }

    public static void restartInput(String str){
        if (str.length()!=1){
            throw new IllegalArgumentException();
        }
        if (str.length()==1 && str.charAt(0)!='1' && str.charAt(0)!='2'){
            throw new IllegalArgumentException();
        }
    }

}
