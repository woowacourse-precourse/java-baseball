package baseball;

import java.util.HashMap;
import java.util.List;

public class Answer {
    public List<String> list;

    public Answer() {};
    public Answer(List<String> answer) {
        this.list = answer;
    }

    public void validate() {
        try {
            lengthThree(this.list);
            isNumberFromOneToNine(this.list);
            distinct(this.list);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void lengthThree(List<String> answerDigits) throws IllegalArgumentException {
        if (answerDigits.size() != Integer.parseInt(Constant.ANSWER_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumberFromOneToNine(List<String> answerDigits) throws IllegalArgumentException {
        for (String digit : answerDigits) {
            int ascii = digit.toCharArray()[0];
            if (ascii < Constant.ASCII_ONE || ascii > Constant.ASCII_NINE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void distinct(List<String> answerDigits) throws IllegalArgumentException {
        HashMap<String, String> digitsMap = new HashMap<>();
        for (String digit : answerDigits) {
            if (digitsMap.get(digit) != null) {
                throw new IllegalArgumentException();
            }
            digitsMap.put(digit, "checked");
        }
    }
}
