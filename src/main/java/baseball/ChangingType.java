package baseball;

public class ChangingType {
    public int StringToInt(String word){
        return Integer.parseInt(word);
    }

    public int[] StringArrToIntArr(String[] word){
        int[] number = new int[word.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(word[i]);
        }
        return number;
    }
}
