package baseball;

/**
 * 한 주기의 게임 운영을 담당하는 클래스
 */
public class NumberBaseballGame {

    /**
     * 게임을 실행하는 메서드
     */
    void run() {
        ThreeDigitNumber randomThreeDigitNumber = new ThreeDigitNumber(
            RandomManager.getDistinctIntegersInRange(1, 9, 3));

        while (true) {
            IOManager.print("숫자를 입력해주세요 : ");

            ThreeDigitNumber userThreeDigitNumber = new ThreeDigitNumber(
                IOManager.splitIntegerIntoIntegerArray(IOManager.getNextInt()));

            IOManager.println(
                randomThreeDigitNumber.getCompareResult(userThreeDigitNumber).toString());

            if (userThreeDigitNumber.equals(randomThreeDigitNumber)) {
                break;
            }
        }

        IOManager.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
