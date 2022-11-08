package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Baseball {
    int user_answer;
    boolean run = true;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void end(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        user_answer = Integer.parseInt(Console.readLine());

        if(user_answer==2) run = false;
    }

    public boolean isNum(String response){
        boolean result = true;
        for(int i=0; i<response.length(); i++){
            if(response.charAt(i)>=49 && response.charAt(i)<=57)
                continue;//숫자인지 확인
            else {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isDifferent(String response){
        return Arrays.asList(response.split(""))
                .stream()
                .distinct()
                .count()==3;
    }

    public boolean isThree(String response){
        return (response.length()==3);
    }

    public boolean generateEx(String response){
        if(!isNum(response))
            throw new IllegalArgumentException("1~9사이의 숫자로만 입력해주세요.");

        if(!isThree(response))
            throw new IllegalArgumentException("3자리 숫자로 입력해주세요.");

        if(!isDifferent(response))
           throw new IllegalArgumentException("서로 다른 숫자로만 입력해주세요.");

        return true;
    }
}
