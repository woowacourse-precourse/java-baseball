package baseball.game;

import baseball.user.Opponent;
import baseball.user.User;

public class BaseBall {

    private User user;
    private Opponent opponent;

    public Boolean start = true;

    public int strike = 0;
    public int ball = 0;

    public String start_Message = "숫자 야구 게임을 시작합니다.";
    public String required_num = "숫자를 입력해주세요 : ";
    public String match_Message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public String end_Message = "게임이 종료되었습니다.";
    public String restart_Message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public final int SIZE = 3;



    public BaseBall() {
        this.user = new User();
        this.opponent = new Opponent();
    }


    public void playGame(){
        System.out.println(start_Message); //게임 시작 메시지 출력
        //사용자에게 입력 받기
        while(this.start){ //종료 버튼을 누르지 않는다면 계속 반복
            System.out.print(required_num); // 사용자에게 입력받기 위한 메시지 출력
            int user_num = this.user.inputNumber();
            int opponent_num = this.opponent.getNumber();
            checkStrike(user_num, opponent_num);
            checkBall(user_num, opponent_num);
            print_state();  //현재 스트라이크, 볼 상태 출력
            right_answer(); //3스트라이크 시 종료 or 재시작
            init_Strike_Ball(); //스트라이크, 볼 0으로 초기화

        }
    }

    public void checkStrike(int user_num, int opponent_num){
        while(user_num > 0){
            int user_remain = user_num % 10;
            int opponent_remain = opponent_num % 10;
            if(user_remain == opponent_remain){
                this.strike += 1;
            }
            user_num /= 10;
            opponent_num /= 10;
        }
    }

    public void checkBall(int user_num, int opponent_num){
        String user_num_s = String.valueOf(user_num);
        String opponent_num_s = String.valueOf(opponent_num);

        for(int i = 0; i < this.SIZE; i++){
            for(int j = 0; j < this.SIZE; j++){
                equalCharacter(i, j, user_num_s.charAt(i), opponent_num_s.charAt(j));
            }
        }
    }
    public void equalCharacter(int i , int j, Character user, Character opponent){
        if(i != j && user == opponent){
            this.ball += 1;
        }
    }

    public void print_state(){
        if(this.strike != 0 && this.ball != 0){
            System.out.printf("%d볼 %d스트라이크%n", this.ball, this.strike);
        }else if(this.strike != 0 && this.ball == 0){
            System.out.printf("%d스트라이크%n", this.strike);
        }else if(this.strike == 0 && this.ball != 0){
            System.out.printf("%d볼%n", this.ball);
        }else{
            System.out.println("낫싱");
        }
    }

    public void init_Strike_Ball(){ //사용자에게 입력받은것을 확인하고 나서 strike, ball 초기화
        this.strike = 0;
        this.ball = 0;
    }
    public void restart(){ //게임 끝나면 초기화
        System.out.println(restart_Message);
        this.start = this.user.restart(); //사용자에게 다시 할건지 입력받기
        if(this.start){
            this.user = new User();
            this.opponent = new Opponent();
        }else{
            System.out.println(end_Message);
        }
    }

    public void right_answer() {
        if(this.strike == 3){
            System.out.println(match_Message);
            restart();  //다시 할건지 물어보는 함수
        }
    }

}
