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
    public void start() {answer=random.pick();}
    @Override
    public void play() {
        String playInput;
        start();
        System.out.println(answer);
        do{
            System.out.print("숫자를 입력해주세요 : ");
            playInput=input.playInput();
            check(playInput);
        }while (!answer.equals(playInput));
        end();
    }
    @Override
    public void end() {
        System.out.print("게임 종료");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endInput= input.endInput();
        if(endInput.equals("1")){
            play();
        }
        else if(endInput.equals("2")) {
            System.out.println("종료되었습니다");
        }
    }
    private void check(String playInput){
        if(answer.equals(playInput)){
            System.out.print("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다.! ");
        }
        else{
            point(playInput);
        }
    }
    private void point(String playInput){ //값 내기
        int strikePoint=0;
        int ballPoint=0;
        for(int i=0; i<range; i++){
            if(answer.indexOf(playInput.charAt(i)) == i){
                strikePoint=strikePoint+1;
            }
            else if(answer.indexOf(playInput.charAt(i)) != -1){
                ballPoint=ballPoint+1;
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