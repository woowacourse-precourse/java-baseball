package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    public boolean reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartNumber = Integer.parseInt(Console.readLine());
        if(restartNumber == 1){
            return true;
        }
        return false;
    }

}
