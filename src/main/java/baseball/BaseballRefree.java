package baseball;

public class BaseballRefree {

    private String answerNumber;
    private boolean[] answerNumberFlags;


    private void setAnswerNumberFlags() {
        this.answerNumberFlags = new boolean[10];

        for (char ch : this.answerNumber.toCharArray()) {
            this.answerNumberFlags[Character.getNumericValue(ch)] = true;
        }
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber;
        this.setAnswerNumberFlags();
    }

    private int getBallCount(String numbers){
        int count = 0;

        for (char ch : numbers.toCharArray()) {
            if (answerNumberFlags[Character.getNumericValue(ch)]) count += 1;
        }
        return count;
    }

    private int getStrikeCount(String numbers){
        int count = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == answerNumber.charAt(i)) count += 1;
        }
        return count;
    }

    private void announceResult(int ballCount, int strikeCount) {
        String statement = "";

        if (ballCount-strikeCount > 0) statement += String.format("%d볼", ballCount-strikeCount);
        if (statement.length() > 0 && strikeCount > 0) statement += " ";
        if (strikeCount > 0) statement += String.format("%d스트라이크", strikeCount);
        if (statement.length() == 0) statement = "낫싱";

        System.out.println(statement);
    }

    public boolean judge(String numbers){
        int ballCount = getBallCount(numbers);
        int strikeCount = getStrikeCount(numbers);

        announceResult(ballCount, strikeCount);

        return strikeCount == answerNumber.length();
    }

}
