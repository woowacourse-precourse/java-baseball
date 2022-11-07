package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private final int MAX_STRIKE = 3;
    private List<Integer> number;

    public Computer() {
        number = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public boolean checkResult(String inputNumber) {
        int[] strikeAndBallCount = getStrikeAndBallCount(inputNumber);
        int strikeCnt = strikeAndBallCount[0];
        int ballCnt = strikeAndBallCount[1];

        System.out.println(buildSentence(strikeCnt, ballCnt));
        if (strikeCnt == MAX_STRIKE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param 사용자가 입력한 3개의 숫자
     * @return count[0] : strike 갯수, count[1] : ball 갯수
     */
    private int[] getStrikeAndBallCount(String inputNumber) {
        int[] count = new int[2];
        for (int i = 0; i < inputNumber.length(); i++) {
            int eachNumber = convertCharToInt(inputNumber.charAt(i));
            if (number.get(i) == eachNumber) {
                count[0]++;
            } else if (number.contains(eachNumber)) {
                count[1]++;
            }
        }

        return count;
    }

    private int convertCharToInt(char c){
        return c - '0';
    }

    private String buildSentence(int strikeCnt, int ballCnt){
        StringBuilder sb = new StringBuilder();
        if (ballCnt != 0) {
            sb.append(ballCnt).append("볼 ");
        }
        if (strikeCnt != 0) {
            sb.append(strikeCnt).append("스트라이크");
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            sb.append("낫싱");
        }

        return sb.toString().trim();
    }

}
