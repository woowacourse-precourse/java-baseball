package baseball.controller;

import baseball.ball.Ball;
import baseball.model.Model;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Model model= new Model();
    View view = new View();
    Ball ball = new Ball();
    public void start(){
        view.startMention();
        while (true) {
            view.printInput();
            String input = Console.readLine();
            try {
                if (!model.findException(input)) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }
            int inp = Integer.parseInt(input);
            int Strike = model.findStrike(ball.getScore(), inp);
            int Ball = model.findBall(ball.getScore(), inp);
            if (Strike == 3){
                view.threeStrike();
                String in = Console.readLine();
                try{
                    if (model.InputException(in)) throw new IllegalArgumentException();
                }catch (IllegalArgumentException e){
                    e.printStackTrace();
                    break;
                }
                if ("1".equals(in)){
                    ball = new Ball();
                }else if ("2".equals(in)){
                    break;
                }
            } else if (Ball != 0 && Strike != 0) {
                view.strikeAndBall(Strike,Ball);
            } else if (Ball != 0){
                view.ball(Ball);
            }else if (Strike !=0){
                view.strike(Strike);
            }else if (Ball == 0 && Strike == 0){
                view.incorrect();
            }
        }
    }
}
