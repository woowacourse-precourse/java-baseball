package baseball.domain;

public class OneBaseBallNumber {
    private BaseBallNumber baseBallNumber;
    private int baseBallPosition;


    public OneBaseBallNumber() {

    }

    OneBaseBallNumber(BaseBallNumber baseBallNumber, int baseBallPosition) {
        this.baseBallNumber = baseBallNumber;
        this.baseBallPosition = baseBallPosition;
    }

    /**
     * 공한개의 정보(번호, 위치)를 리턴
     * @param number 숫자
     * @param baseBallPosition 위치정보
     * @return OneBaseBallNumebr 객체 리턴
     */
    public OneBaseBallNumber OneBaseBallNumberInfo(int number, int baseBallPosition) {
        return new OneBaseBallNumber(new BaseBallNumber(number), baseBallPosition);
    }
}
