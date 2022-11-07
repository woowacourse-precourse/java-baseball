package baseball.Service;

public class Rule {
    public boolean Ball(String answer,char input,int i)
    {
        char answers[] = answer.toCharArray();
        for(int j=0;i<answers.length;i++)
        {
            if(input==answers[i]&&i!=j){
                return true;
            }
        }
        return false;
    }

}
