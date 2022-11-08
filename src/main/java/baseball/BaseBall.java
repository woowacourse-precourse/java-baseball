package baseball;
import java.util.List;
public class BaseBall {
    private List<Integer> answer;
    private Input input;
    private Random random;
    private int range;
    public BaseBall(int min,int max,int range){
        this.range=range;
        random =new Random(min,max,range);
        input =new Input(min,max,range);
        play();
    }
    private void start() {answer=random.pick();}
    public void play() {
        String playInput,answerToString;
        start();
        answerToString=answer.toString().replaceAll("[^0-9]","");
        do{
            System.out.print("숫자를 입력해주세요 : ");
            playInput=input.playInput();
            point(playInput);
        }while (!answerToString.equals(playInput));
        end();
    }
    private void end() {
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endInput= input.endInput();
        if(endInput.equals("1")){
            play();
        }
        else if(endInput.equals("2")) {
            System.out.println("종료되었습니다");
        }
    }
    private void point(String playInput){
        int strikePoint=0,ballPoint=0,checkNum;
        for(int i=0; i<range; i++){
            checkNum=Character.getNumericValue(playInput.charAt(i));
            if(answer.indexOf(checkNum) == i){
                strikePoint=strikePoint+1;
            }
            else if(answer.contains(checkNum)){
                ballPoint=ballPoint+1;
            }
        }
        score(strikePoint,ballPoint);
    }
    private void score(int strikePoint, int ballPoint) {
        String board;
        if(strikePoint == range)    board="3스트라이크\n"+range+"개의 숫자를 모두 맞히셨습니다.!";
        else if(ballPoint+strikePoint == 0)  board="낫싱";
        else if(strikePoint !=0 && ballPoint == 0)  board=strikePoint+"스트라이크";
        else if(ballPoint !=0 && strikePoint ==0)   board=ballPoint+"볼";
        else board=ballPoint+"볼 "+strikePoint+"스트라이크";
        System.out.println(board);
    }
}