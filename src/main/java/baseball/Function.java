package baseball;

public class Function {
    static boolean checkArrayContain(int[] array, int number){
        for (int value : array) {
            if (value == number){
                return true;
            }
        }
        return false;
    }

    static boolean checkArrayContain(char[] array, char number){
        for (int value : array) {
            if (value == number){
                return true;
            }
        }
        return false;
    }

    static char[] getCharArrayToString(String str){
        char[] Array = new char[str.length()];

        for (int i=0; i<str.length(); i++){
            Array[i] = str.charAt(i);
        }
        return Array;
    }

    public static int checkStrike(int[] array, int number) {
        for(int i=0; i<3; i++){
            if(array[i]==number){
                return i;
            }
        }
        return -1;
    }
}
