package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class Application {
    private static int[] pcNum;
    private static int[] playerNum = new int[3];
    private static int[] judgement;
    private static String hint;
    private static String result;
    private static String restart;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        pcNum = genPcNum();  // 컴퓨터 숫자 생성
        do {
            playGame();
            getRestartNum();  // 게임 재시작 여부 확인
        } while (restart == "1");
        assertThat(restart).isEqualTo("2");  // 게임 종료 여부 확인
        System.out.println("게임을 종료합니다.");
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
    private static int[] getUmpire(int[] playerNum, int[] pcNum) {        
        int[] judgement = {0, 0};  // judgement = {볼, 스트라이크}
        for (int i=0; i < playerNum.length; i++) {
            if (playerNum[i] == pcNum[i]) {
                judgement[1] += 1;
            } else if (Arrays.asList(pcNum).contains(playerNum[i])) {
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
    private static boolean isPlayerNumValid(int[] playerNum) {
        boolean playerNumValidity = true;
        // 3자리 수인지 확인
        // if (playerNum.length != 3) {
        //     playerNumValidity = false;
        // }
        // 1 ~ 9 값만 존재하는지 확인
        for (int i = 0; i < playerNum.length; i++) {
            if (playerNum[i] < 1 || playerNum[i] > 9) {
                playerNumValidity = false;
            }
        }
        // 서로 다른 수인지 확인
        if (playerNum[0] == playerNum[1]) {
            playerNumValidity = false;
        }
        if (playerNum[1] == playerNum[2]) {
            playerNumValidity = false;
        }
        if (playerNum[2] == playerNum[0]) {
            playerNumValidity = false;
        }
        return playerNumValidity;
    }
    private static void getPlayerNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String[] playerInput = Console.readLine().split("");
        if (playerInput.length != 3) {
            throw new IllegalArgumentException("Input should be a length of 3.");
        }
        for (int i=0; i < playerInput.length; i++) {
            try {
                playerNum[i] = Integer.parseInt(playerInput[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Input should be integers.")
            }
        }
        boolean playerNumValidity = isPlayerNumValid(playerNum); // 유효성 검사
        if (playerNumValidity == false) {
            throw new IllegalArgumentException("Input should be 3 different integers in range of 1 to 9.");
        }
    }
    private static void playGame() {
        do {
            getPlayerNum();  // 플레이어 입력값 요구 + 유효성 검사
            judgement = getUmpire(playerNum, pcNum);  // 플레이어 입력값 분석
            hint = getHint(judgement);  // 분석 결과에 따른 힌트 도출
            result = getResult(judgement);  // 분석 결과에 따른 결과 도출
        } while (result == "retry");
    }
    private static void getRestartNum() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restart = Console.readLine();
        if (restart != "1" || restart != "2") {
            throw new IllegalArgumentException("Input should only be '1' or '2'.");
        }

    }
}