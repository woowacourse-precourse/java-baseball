package baseball.utils;

public class ChangeToChar {
    public ChangeToChar(){
    }
    public char[] changetoChar(int number) {
        char[] cNumber = new char[]{'0', '0', '0'};
        for(int cnt = 2; number != 0; --cnt) {
            cNumber[cnt] = (char)(48 + number % 10);
            number /= 10;
        }
        return cNumber;
    }
}
