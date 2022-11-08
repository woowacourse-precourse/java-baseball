package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Answer {
    public static int retry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String goOrStop = Console.readLine();
        regexCheck(goOrStop); //잘못된 입력값 예외처리
        int continueCheck = Integer.parseInt(goOrStop);
        return continueCheck;
    }

    public static void regexCheck(String goOrStop) {
        try{
            int check = Integer.parseInt(goOrStop);
        }catch (Exception ex){
            throw new IllegalArgumentException("숫자가 아닌 값을 포함하고 있습니다. 1(재시작) 또는 2(게임종료) 중에 선택해주세요.");
        }
        int check = Integer.parseInt(goOrStop);
        if(check!=1 && check!=2){
            throw new IllegalArgumentException("잘못입력하셨습니다. 1(재시작) 또는 2(게임종료) 중에 선택해주세요.");
        }
    }
}
