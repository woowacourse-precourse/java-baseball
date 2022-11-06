package baseball;

public class RandomNumber {

    private static String randomValue;
    private static final int CORRECTINPUTLENGTH = 3;

    public RandomNumber(String randomValue){
        this.randomValue = randomValue;
    }

    public int countDuplicate(String userInput) {
        int ballNum = 0;
        for (int i = 0; i < CORRECTINPUTLENGTH; i++) {
            if (randomValue.indexOf(userInput.charAt(i)) != -1) {
                ballNum++;
            }
        }
        return ballNum;
    }

    public char randomNumInChar(int i) {
        return randomValue.charAt(i);
    }
}
