package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // 컴퓨터 숫자 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] pcNum = genPcNum();
        // System.out.println(pcNum[0]+" "+pcNum[1]+" "+pcNum[2]);

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

}
