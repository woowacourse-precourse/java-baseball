package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> targetDigits;

    public void setTargetDigits() {
//        Set<Integer> digitSet = new HashSet<>();
//        while (digitSet.size() < 3) {
//            digitSet.add(Randoms.pickNumberInRange(1, 9));
//        }
//        List<Integer> digitList = new ArrayList<>(digitSet);
//        System.out.println(digitList);
//        return digitList;

        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
        this.targetDigits = digits;
    }

    public List<Integer> getTargetDigits() {
        return this.targetDigits;
    }

    public int[] countStrikesAndBalls(List<Integer> targetDigits, List<Integer> inputDigits) {

        int[] strikesAndBalls = {0, 0};
        for (int i = 0; i < 3; i++) {
            if (targetDigits.get(i).equals(inputDigits.get(i))) {
                strikesAndBalls[0] += 1;
            } else if (targetDigits.contains(inputDigits.get(i))) {
                strikesAndBalls[1] += 1;
            }
        }
        return strikesAndBalls;
    }


    public String makeInfoString(int strikeCnt, int ballCnt) {
        String info = "";
        if (ballCnt > 0 && strikeCnt > 0) {
            info = ballCnt + "볼 " + strikeCnt + "스트라이크";
        } else if (ballCnt > 0) {
            info = ballCnt + "볼";
        } else if (strikeCnt > 0) {
            info = strikeCnt + "스트라이크";
        } else {
            info = "낫싱";
        }
        return info;
    }
}
