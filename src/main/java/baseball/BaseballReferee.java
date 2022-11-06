package baseball;

public class BaseballReferee {



    private BaseballInput answer;

    BaseballReferee(BaseballInput answer){
        this.answer = answer;

    }

    public BaseballOutput judge(BaseballInput target){
        int ball = 0;
        int strike = 0;

        if(answer.containNumber(target.getFirst())){
            ball++;
        }
        if(answer.containNumber(target.getSecond())){
            ball++;
        }
        if(answer.containNumber(target.getThird())){
            ball++;
        }

        if(answer.getFirst() == target.getFirst()){
            strike++;
            ball--;
        }

        if(answer.getSecond() == target.getSecond()){
            strike++;
            ball--;
        }

        if(answer.getThird() == target.getThird()){
            strike++;
            ball--;
        }
        return new BaseballOutput(ball, strike);
    }
}
