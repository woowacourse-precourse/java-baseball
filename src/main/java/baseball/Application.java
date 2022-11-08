package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//1.문한 반복: 진행 여부 1, 2
//2.랜덤 3자리 숫자 저장
//무한 반복
//3.입력
// 입력 예외처리
// 잘못 입력하면 프로그램 종료
//4.야구 판별
//1) 각 자릿수 숫자로 랜덤 숫자 탐색
//만약 숫자와 자릿수 같으면 스트라이크 카운트
//만약 숫자만 같고 자릿수 다르면 볼 카운트
//2) 출력
// 3스트라이크이면 3개의 숫자를 모두 맞히셨습니다! 게임 종료 , // 카운트 초기화, 진행 여부 입력, 중단
// 스트라이크, 볼 모두0이면 낫싱
// 스트라이크0이고 볼 0아니면  출력
// 스트라이크 0 아니거볼 0 이면 출력
// 둘 다 0아닌 경우
public class Application {

    //2.랜덤 3자리 숫자 저장
    public static List<Integer> random3Number(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String inputMethod(boolean flag, String input){
        //3.입력
        // 입력 예외처리
        // 잘못 입력하면 프로그램 종료
        try {
            System.out.println("숫자를 입력해주세요 : ");
            input = Console.readLine();

            if (input.length() != 3 || input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2) || input.charAt(0) < '1' || input.charAt(0) > '9' || input.charAt(1) < '1' || input.charAt(1) > '9' || input.charAt(2) < '1' || input.charAt(2) > '9') {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            flag=true;
            throw new IllegalArgumentException();
        }
        if(flag){
            return "inputError";
        }
        return input;
    }

    // 스트라이크, 볼 카운트 클래스
    public static class BaseBallCnt{
        int strcnt;
        int ballcnt;

        public BaseBallCnt(int strcnt, int ballcnt) {
            this.strcnt = strcnt;
            this.ballcnt = ballcnt;
        }
    }

    public static void baseBallValid(BaseBallCnt baseBallCnt, List<Integer> computer, String input) {
        //4.야구 판별
        //1) 각 자릿수 숫자로 랜덤 숫자 탐색
        //만약 숫자와 자릿수 같으면 스트라이크 카운트
        //만약 숫자만 같고 자릿수 다르면 볼 카운트
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(j) == (input.charAt(i) - '0') && i == j) {
                    baseBallCnt.strcnt++;
                } else if (computer.get(j) == (input.charAt(i) - '0') && i != j) {
                    baseBallCnt.ballcnt++;
                }
            }
        }
    }

    public static String baseBallPrint(BaseBallCnt baseBallCnt, String again){
        //2) 출력
        // 3스트라이크이면 3개의 숫자를 모두 맞히셨습니다! 게임 종료 , // 카운트 초기화, 진행 여부 입력, 중단
        // 스트라이크, 볼 모두0이면 낫싱
        // 스트라이크0이고 볼 0아니면  출력
        // 스트라이크 0 아니거볼 0 이면 출력
        // 둘 다 0아니면
        if (baseBallCnt.strcnt == 3) {
            System.out.println(baseBallCnt.strcnt+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            again = Console.readLine();
            return again;
        }
        if (baseBallCnt.strcnt == 0 && baseBallCnt.ballcnt == 0) {
            System.out.println("낫싱");
        }
        if (baseBallCnt.strcnt==0 && baseBallCnt.ballcnt != 0) {
            System.out.println(baseBallCnt.ballcnt + "볼");
        }
        if (baseBallCnt.strcnt != 0 && baseBallCnt.ballcnt==0) {
            System.out.println(baseBallCnt.strcnt + "스트라이크");
        }
        if(baseBallCnt.strcnt!=0 && baseBallCnt.ballcnt!=0){
            System.out.println(baseBallCnt.ballcnt + "볼 " + baseBallCnt.strcnt + "스트라이크");
        }
        return "";
    }

    public static String userStart(boolean flag, String again, List<Integer> computer){
        //무한 반복
        while (true) {
            String input="";
            input = inputMethod(flag, input);
            if(input.equals("inputError")){ return "inputError";}

            BaseBallCnt baseBallCnt = new BaseBallCnt(0,0);
            baseBallValid(baseBallCnt, computer, input);

            again = baseBallPrint(baseBallCnt, again);
            if(!again.equals("")){
                return again;
            }
        }
    }

    public static void startBaseballGame(){
        String again = "1";
        //1.문한 반복: 진행 여부 1, 2
        //2.랜덤 3자리 숫자 저장
        while (again.equals("1")) {
            if (again.equals("2")) {
                break;
            }
            boolean flag=false;
            List<Integer> computer = random3Number();

            System.out.println("숫자 야구 게임을 시작합니다.");
            again = userStart(flag, again, computer);
            if(again.equals("inputError")){
                return;
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startBaseballGame();
    }
}