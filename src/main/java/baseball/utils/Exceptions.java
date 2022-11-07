package baseball.utils;

public class Exceptions {

    public static void isNumber(String str){
        for (int i=0; i<Constants.INPUT_SIZE; i++){
            if (str.charAt(i)>intToChar(Constants.RANDOM_END_NUM) || str.charAt(i)<intToChar(Constants.RANDOM_START_NUM)){
                throw new IllegalArgumentException();
            }
        }
    }
    public static void checkNumSize(String str){
        if (str.length()!=Constants.INPUT_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static void restartInput(String str){
        if (str.length()!=1){
            throw new IllegalArgumentException();
        }
        if (str.length()==1 && str.charAt(0)!=intToChar(Constants.RESTART_GAME) && str.charAt(0)!=intToChar(Constants.END_GAME)){
            throw new IllegalArgumentException();
        }
    }
    public static char intToChar(int num){
        char ch = (char) (num + '0');
        return ch;
    }

}
