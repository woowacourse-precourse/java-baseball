package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNum {

    private final int[] indexes = new int[10];

    private final int[] nums = new int[3];

    /**
     *  중복 없는 3자리 수를 랜덤으로 생성한다.
     */
    public BaseballNum() {
        int index = 1;
        while (index <= 3) {
            int nextNum = Randoms.pickNumberInRange(1, 9);
            if (indexes[nextNum] == 0) {
                nums[index - 1] = nextNum;
                indexes[nextNum] = index++;
            }
        }
    }

    /**
     * 랜덤이 아닌 지정된 수를 이용해 BaseballNum을 생성
     * @param num  3자리 수
     * @throws IllegalArgumentException 입력된 수가 3자리가 아니거나, 중복이 있을 경우 예외를 발생시킨다.
     */
    public BaseballNum(int num) throws IllegalArgumentException {

        if (num < 0) throw new IllegalArgumentException();

        String numStr = Integer.toString(num);
        if (numStr.length() != 3) throw new IllegalArgumentException();

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            if (indexes[digit] != 0) throw new IllegalArgumentException();

            indexes[digit] = i + 1;
            nums[i] = digit;
        }
    }

    public int getFirst() {
        return nums[0];
    }

    public int getSecond() {
        return nums[1];
    }

    public int getThird() {
        return nums[2];
    }

    /**
     * 입력된 숫자가 3자리 수에서 위치한 곳을 반환한다.
     * @param num 위치를 얻고 싶은 숫자를 입력
     * @return 존재한다면 1 ~ 3 중 해당하는 위치를 반환. 없다면 0을 반환
     */
    public int getIndex(int num) {
        try {
            return indexes[num];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

}
