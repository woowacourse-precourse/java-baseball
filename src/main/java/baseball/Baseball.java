package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Baseball {
    int user_answer;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void end(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        user_answer = Integer.parseInt(Console.readLine());
    }

    public boolean possibleNum(String response){
        boolean result = false;
        for(int i=0; i<response.length()-1; i++){
            if((response.charAt(i)!=response.charAt(i+1)) || (response.charAt(i)!=response.charAt(2-i)))
                result = true; //숫자 3개가 모두 다른 숫자인지 확인
        }

        for(int i=0; i<response.length(); i++){
            if(response.charAt(i)>=49 || response.charAt(i)<=57)
                result = true; //숫자인지 확인
        }
        return result;
    }

    public void generateEx(int response){
        String str_response = String.valueOf(response);
        if(!(str_response.length()==3 && possibleNum(str_response)))
           throw new IllegalArgumentException();
    }
}
