package baseball;

public class AnswerResultJudgement {
    private String answer;

    public AnswerResultJudgement(String answer) {
        this.answer = answer;
    }


    public int countBall(String input){
        int ball=0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)!=answer.charAt(i) && answer.contains(Character.toString(input.charAt(i)))) {
                ball+=1;
            }
        }
        return ball;
    }
    public int countStrike(String input){
        int strike=0;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i)==answer.charAt(i)) {
                strike+=1;
            }
        }
        return strike;
    }
    public String getResult(String input){
        int strikeCnt=countStrike(input);
        int ballCnt=countBall(input);
        return printResult(new int[]{ballCnt, strikeCnt});
    }
    public String printResult(int[] result){
        if(result[0]==0 && result[1]==0){
            return "낫싱";
        }
        if(result[0]<=0 && result[1]>0){
            return String.format("%d스트라이크", result[1]);
        }else if(result[0]>0 && result[1]==0){
            return String.format("%d볼", result[0]);
        }
        return String.format("%d볼 %d스트라이크", result[0], result[1]);
    }
}
