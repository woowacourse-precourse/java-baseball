package baseball.controller;

import baseball.BaseBall;
import baseball.answer.AnswerGenerator;
import baseball.answer.RandomsGenerator;
import baseball.input.ConsoleInput;
import baseball.input.UserInput;

import static baseball.text.StaticText.*;

public class BaseBallController {
    private AnswerGenerator generator;
    private UserInput input;
    private BaseBall baseBall;

    /**
     * 해당 메소드에서 의존성을 관리해준다.
     */
    private void init() {
        this.generator = new RandomsGenerator();
        this.input = new ConsoleInput();
        this.baseBall = new BaseBall(generator, input);
    }

    public void run() {
        init();

        PROGRAM_START.print();

        int askPlay = 1;
        while (askPlay == 1) {
            this.baseBall.play();
            askPlay = Integer.parseInt(this.input.readRetryable());
        }

        PROGRAM_END.print();
    }
}
