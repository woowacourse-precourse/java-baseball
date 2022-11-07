package baseball;

public class BaseballGame {
    Computer com;
    User user;
    int strike;
    int ball;

    BaseballGame(){
    }

    public void initialzeScore(){
        this.strike=0;
        this.ball=0;
    }

    public void setComputer(){
        this.com=new Computer();
    }


    public void playing(){
        this.user=new User();
        do {
            initialzeScore();
            user.inputUser();
            checkPoint();
            printAnswer();
        }while(checkAnswer());
    }

    public void checkPoint(){
        for(int idx=0;idx<3;idx++){
            int user_at=this.user.value.charAt(idx)-'0';
            if(user_at==this.com.value.get(idx)) {
                strike++;
            }
            else if(this.com.value.contains(user_at)){
                ball++;
            }
        }
    }

    public void printAnswer(){
        StringBuilder answer=new StringBuilder();

        if(ball>0){
            answer.append(ball+"볼 ");
        }
        if(strike>0){
            answer.append(strike+"스트라이크 ");
        }
        if(answer.length()==0){
            answer.append("낫싱");
        }

        System.out.println(answer);
    }

    public boolean checkAnswer(){
        if(this.strike!=3){
            return true;
        }
        else{
            return false;
        }
    }



}
