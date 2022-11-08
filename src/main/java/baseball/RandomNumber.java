package baseball;

public class RandomNumber {

    private static String randomValue;

    public RandomNumber(String randomValue) {
        RandomNumber.randomValue = randomValue;
    }

    public int countDuplicate(String userInput) {
        int ballNum = 0;
        for (int i = 0; i < randomValue.length(); i++) {
            if (randomValue.indexOf(userInput.charAt(i)) != -1) {
                ballNum++;
            }
        }
        return ballNum;
    }

    public int countExactSame(String userInput) {
        int strikeCnt = 0;
        for (int i = 0; i < randomValue.length(); i++) {
            if (userInput.charAt(i) == randomValue.charAt(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public char randomNumInChar(int i) {
        return randomValue.charAt(i);
    }
}
