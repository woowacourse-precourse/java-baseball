package baseball;

public class BaseBall implements Game{
    private String answer="";
    private Input input;
    private Random random;
    private int range;
    public BaseBall(int mix,int max,int range){
        this.range=range;
        random =new Random(mix,max,range);
        input =new Input(range);
        play();
    }
    @Override
    public void start() {
        answer=random.pick();
    }

    @Override
    public void play() {
        String hitter;
        start();
        do{
            System.out.print("숫자를 입력해주세요 : ");
            hitter=input.playInput();
            check(hitter);
        }while (!answer.equals(hitter));
        end();
    }
    @Override
    public void end() {
        input.endInput();
    }
    private void check(String hitter){
        if(answer.equals(hitter)){
            System.out.print("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다.! ");
        }
        else{
            point(hitter);
        }
    }
    private void point(String hitter){ //값 내기
        int strikePoint=0;
        int ballPoint=0;
        for(int i=0; i<range; i++){
            if(answer.indexOf(hitter.charAt(i)) == i){
                ballPoint=ballPoint+1;
            }
            else if(answer.indexOf(hitter.charAt(i)) != -1){
                strikePoint=strikePoint+1;
            }
        }
        score(strikePoint,ballPoint);
    }
    @Override
    public void score(int strikePoint, int ballPoint) {
        String score;
        if(ballPoint+strikePoint == 0)  score="낫싱";
        else if(strikePoint !=0 && ballPoint == 0)  score=strikePoint+"스트라이크";
        else if(ballPoint !=0 && strikePoint ==0)   score=ballPoint+"볼";
        else score=ballPoint+"볼 "+strikePoint+"스트라이크";
        System.out.print(score);
    }
}