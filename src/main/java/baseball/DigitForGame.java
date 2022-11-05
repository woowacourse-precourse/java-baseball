package baseball;

public interface DigitForGame {
    /**
     * @param otherNumber 현재 Number 객체와 비교할 다른 Number 객체
     * @return 두 객체의 값이 같다면 true, 그렇지 않다면 false 반환
     */
    boolean equals(DigitForGame otherNumber);

    /**
     * 입력으로 주어진 수가 알맞은 입력값인지 확인함
     * @param number 검증할 int 형 숫자값
     * @return 알맞은 입력값인 경우 true, 그렇지 않다면 false 반환
     */
    boolean validateNumber(int number);
}
