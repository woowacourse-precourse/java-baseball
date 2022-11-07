package model;

public class GamePlayer {

    public static final int MAXIMUM_NUMBER = 9;
    public static final int MINIMUM_NUMBER = 1;
    public static final int SIZE = 3;

    public int[] numbers;

    public GamePlayer() {
        numbers = new int[SIZE];
    }

    /**
     * 숫자로 이루어진 문자열을 입력 받아 배열에 담는다. 서로 다른 SIZE 크기의 자릿수가 아니라면 올바르게 작동하지 않는다.
     *
     * @param str 숫자로 이루어진 문자열
     */
    public void saveNumbers(String str) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (str.charAt(i) - '0');
        }
    }
}
