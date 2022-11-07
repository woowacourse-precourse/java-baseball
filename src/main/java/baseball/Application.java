package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터 숫자 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] pcNum = genPcNum();
        // System.out.println(pcNum[0]+" "+pcNum[1]+" "+pcNum[2]);

        // 테스트용 pc - input set
        // int[] testPc = {1,2,3};
        // int[] testInput = {3,2,1};

        // 플레이어 입력값 분석
        int[] judgement = getUmpire(inputNum, pcNum);
        // int[] judgement = getUmpire(testInput, testPc);
        // System.out.println("ball : " + judgement[0]);
        // System.out.println("strike : " + judgement[1]);
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

}
