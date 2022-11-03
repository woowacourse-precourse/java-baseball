package baseball.service;


import baseball.mapper.StringMapper;

public class NumberCondition {
    private final String answer;

    public NumberCondition(String answer) {
        this.answer = answer;
    }

    public int countContainmentRightness(String number) {
        int cnt = 0;
        for(int i=0 ; i<number.length() ; i++) {
            String oneOfNum = StringMapper.ctos(number.charAt(i));
            if (doesContain(oneOfNum)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countDigitRightness(String number) {
        int cnt = 0;
        for(int i=0 ; i<number.length() ; i++) {
            String oneOfNum = StringMapper.ctos(number.charAt(i));
            if (isDigitCorrect(oneOfNum, i)) {
                cnt++;
            }
        }
        return cnt;
    }


    private boolean doesContain(String oneOfNum) {
        return answer.contains(oneOfNum);
    }

    private boolean isDigitCorrect(String oneOfNum, int digit) {
        boolean result = false;
        if (answer.indexOf(oneOfNum) == digit) {
            result = true;
        }
        return result;
    }
}
