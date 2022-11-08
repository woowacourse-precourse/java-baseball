package baseball;

/**
 * 한 주기의 게임 운영을 담당하는 클래스
 */
public class NumberBaseballGame {

    /**
     * 게임을 실행하는 메서드
     */
    void run() {
        MultiDigitNumber randomMultiDigitNumber = new MultiDigitNumber(
            RandomManager.getDistinctIntegersInRange(1, 9, 3));
        while (true) {
            IOManager.print("숫자를 입력해주세요 : ");

            MultiDigitNumber userMultiDigitNumber = new MultiDigitNumber(
                IOManager.splitIntegerIntoIntegerArray(IOManager.getNextInt()));

            IOManager.println(
                randomMultiDigitNumber.getCompareResult(userMultiDigitNumber).toString());

            if (userMultiDigitNumber.equals(randomMultiDigitNumber)) {
                break;
            }
        }

        IOManager.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
