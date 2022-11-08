package baseball;

public class OutputHandler {
    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printGetUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void Strike_andBall_result_print(int strike, int ball){
        int sum = strike+ball;
        if(strike==3 && ball==0){
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if((sum) ==0){
            System.out.println("낫싱");
        }else if(sum <=3 && sum >0 )
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }
    public void printRestart_orExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
