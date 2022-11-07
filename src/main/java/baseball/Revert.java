package baseball;

public class Revert {

    public char[] revertStringToCharArray(String input) {

        return input.toCharArray();
    }

    public int[] revertCharArrayToAsciiArray(char[] charArray) {
        int[] asciiArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            asciiArray[i] = charArray[i];
        }
        return asciiArray;
    }

    public int[] revertCharArrToIntArr(char[] charArr) {
        int[] intArr = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(charArr[i]));
        }
        return intArr;
    }
}
