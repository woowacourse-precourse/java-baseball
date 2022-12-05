package baseball.view;

import static baseball.Rendering.START;

public class OutputView {

    public String printStart(){

        String start = START.print() + "\n";
        System.out.println(start);
        return start;
    }


}
