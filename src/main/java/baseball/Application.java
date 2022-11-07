package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터 숫자 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] pcNum = genPcNum();

        // 플레이어 입력값 분석
        int[] judgement = getUmpire(inputNum, pcNum);

        // 분석 결과에 따른 힌트 도출
        String hint = getHint(judgement);

        // 분석 결과에 따른 결과 도출
        String result = getResult(judgement);
    }
    private static int[] genPcNum() {
        int[] pcNum = new int[3];
        pcNum[0] = pickNumberInRange(1, 9);
        do {
            pcNum[1] = pickNumberInRange(1, 9);
        } while (pcNum[1] == pcNum[0]);
        do {
            pcNum[2] = pickNumberInRange(1, 9);
        } while (pcNum[0] == pcNum[2] || pcNum[1] == pcNum[2]);
        return pcNum;
    }
    private static int[] getUmpire(int[] inputNum, int[] pcNum) {        
        int[] judgement = {0, 0};  // judgement = {볼, 스트라이크}
        for (int i=0; i < inputNum.length; i++) {
            if (inputNum[i] == pcNum[i]) {
                judgement[1] += 1;
            } else if (Arrays.asList(pcNum).contains(inputNum[i])) {
                judgement[0] += 1;
            }
        }    
        return judgement;
    }
    private static String getHint(int[] judgement) {
        String hint;
        if (judgement[0] + judgement[1] == 0) {
            hint = "낫싱";
        } else if (judgement[0] == 0) {
            hint = String.valueOf(judgement[1]) + "스트라이크";
        } else if (judgement[0] == 0) {
            hint = String.valueOf(judgement[0]) + "볼";
        } else {
            hint = String.valueOf(judgement[0]) + "볼 " + String.valueOf(judgement[1]) + "스트라이크";
        }
        return hint;
    }
    private static String getResult(int[] judgement) {
        String result;
        if (judgement[1] == 3) {
            result = "win";
        } else {
            result = "retry";
        }
        return result;
    }
}
