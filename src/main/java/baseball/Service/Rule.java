package baseball.Service;

import baseball.Domain.ThrowBall;
import java.util.List;

public class Rule {
    public int ball(List<Integer> answer,int input,int i)
    {
        for(int j=0;j<answer.size();j++)
        {
            if(input==answer.get(j)&&i!=j){
                System.out.println(answer.get(i)+""+input);
                System.out.println(i+""+j);
                return 1;
            }
        }
        return 0;
    }
   public int strike(int answer, int input)
   {
       if(answer==input)
       {
           return 1;
       }else {
           return 0;
       }
   }
    public String ruleCheck(List<Integer> computerAnswer, ThrowBall throwBall)
    {
        int strikeCount = 0;
        int ballCount = 0;
        for(int i=0;i<3;i++)
        {
           strikeCount= strikeCount+strike(computerAnswer.get(i),throwBall.getTrowBall(i));
           ballCount = ballCount+ball(computerAnswer,throwBall.getTrowBall(i),i);
        }
        if(strikeCount==0&&ballCount==0)
        {
            return "낫싱";
        }
        else if(strikeCount==0)
        {
            return ballCount+"볼";
        }else if(ballCount ==0)
        {
            return strikeCount+"스트라이크";
        }
        return ballCount+"볼 "+strikeCount+"스트라이크";
    }
}
