package baseball.gamesetting;

public class InputException extends Computer {
    void judgeNotNumber(String a) {
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
    
    void judgeIncludeZero(String a) {
        if (a.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력하세요");
        }
    }

    void judgeRange(String a) throws IllegalArgumentException {
        int i = Integer.parseInt(a);
        if (i<100 || i >999) {
            throw new IllegalArgumentException("세 개의 숫자를 입력하세요");
        }
    }

    void judgeDifferentNumber(String a) {
        int i = Integer.parseInt(a);
        int firstNumber = i/100;
        int secondNumber =  (i - 100*firstNumber)/10;
        int lastNumber = i - 100*firstNumber - 10*secondNumber;
        if (firstNumber == secondNumber || secondNumber == lastNumber || lastNumber == firstNumber) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요");   
        }
    }

    public void judgeException(String a) {
        this.judgeNotNumber(a);
        this.judgeIncludeZero(a);
        this.judgeRange(a);
        this.judgeDifferentNumber(a);
    }

    public void restartJudgeException(String a) {
        this.judgeNotNumber(a);
        if(!a.equals("1") && !a.equals("2")) {
            throw new IllegalArgumentException("다시 시작하세요");
        }
    }
}