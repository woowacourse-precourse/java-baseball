package baseball;

import java.util.List;

public class Baseball {
    public void play() {
        Input input = new Input();
        Output output = new Output();
        RandomNumber randomNumber = new RandomNumber();
        Strike strike = new Strike();
        Ball ball = new Ball();

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<String> computer = randomNumber.generate();
            List<String> user = input.getNumber();

            int strikeCount = strike.count(computer, user);
            int ballCount = ball.count(computer, user);

            while(true) {
                Boolean result = output.result(strikeCount, ballCount);
                // 정답
                if(result) {
                    break;
                }
                user = input.getNumber();
                strikeCount = strike.count(computer, user);
                ballCount = ball.count(computer, user);
            }

            // 게임 종료
            if(!input.continuePlay()) {
                break;
            }
        }
    }
}
