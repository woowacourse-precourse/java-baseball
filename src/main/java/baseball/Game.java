package baseball;

import java.util.List;

public class Game {
        Computer com = new Computer();
        User user = new User();
        Message message = new Message();
    int strikeCount;
    int ballCount;
    List<Integer> comList;
    List<Integer> userList;
    //랜덤 컴퓨터 숫자생성과 유저 숫자 입력을 한번에 메소드로 실행

    public void plusStrikeCount(){
        strikeCount++;
    }
    public void plusBallCount(){
        ballCount++;
    }

    public int vaildStrike (List<Integer> com, List<Integer> user) {
        strikeCount=0;
        for (int i = 0; i < com.size(); i++) {
                if (com.get(i) == user.get(i)) {
                    plusStrikeCount();
                }
            }
        return strikeCount;
    }

    public int vaildBall (List<Integer> com, List<Integer> user) {
        ballCount=0;
        for (int i = 0; i < com.size(); i++) {
            if (com.contains(user.get(i))) {
                plusBallCount();
            }
        }
        return ballCount;
    }

    public String vaildList (int strikeCount, int ballCount){
        ballCount = ballCount -strikeCount;
        if (0 < ballCount && 0 < strikeCount) {
                return (ballCount + message.ballSentence + strikeCount + message.strikeSentence);
            } else if (0 == strikeCount && 0 < ballCount) {
                return (ballCount + message.ballSentence );
            } else if (0 < strikeCount && 0 == ballCount) {
                return (strikeCount + message.strikeSentence);
            } else if (0 == ballCount && 0 == strikeCount) {
                return (message.nothing);
            }else throw new IllegalArgumentException();
    }
    public boolean threeStrike (int strikeCount){
        if(strikeCount==3) {
            return true;
        }   return false;
    }

    public boolean play() throws IllegalStateException {
        comList = com.comNumList();
        System.out.println(message.startSentence);
        while (true){
            System.out.print(message.whileGameSentence);
            userList = user.userNumList(user.userNumFormatCheck(user.userNumLengthCheck()));
            vaildStrike(comList,userList);
            vaildBall(comList,userList);
            System.out.println(vaildList(strikeCount, ballCount));
            boolean end = threeStrike(strikeCount);
            if(end){
                System.out.println(message.endGameSentence);
                System.out.println(message.restart);
                return user.restart();

            }
        }
    }





}
