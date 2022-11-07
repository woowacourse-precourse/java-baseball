package baseball.domain;

public class Player {
    private static final int COUNT_VALUE = 3;
    private int[] predictedValue;

    public Player(){
        predictedValue = new int[COUNT_VALUE];
    }

    public int[] getPredictedValue() {
        return predictedValue;
    }

    public void setPredictedValue(String input) {
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < COUNT_VALUE; i++) {
            this.predictedValue[i] = Character.getNumericValue(inputArray[i]);
        }
    }
}
