package baseball;

import java.util.List;

public class Result {
    int strike;
    int ball;
    public void countStrikeAndBall(List<Integer> userList, List<Integer> computerList){
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).equals(computerList.get(i))){
                this.strike++; //나중에 class로 바꿀 생각
            }
            else if(computerList.contains(userList.get(i))){
                this.ball++;
            }
        }
    }
}
