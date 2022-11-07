package baseball.view.output;


import baseball.utils.message.OutputMessage;

public class OutputImpl implements Output {

    @Override
    public void printMessage(String resultMessage) {
        if(resultMessage.equals(OutputMessage.NUMBER_REQUEST)){
            System.out.print(resultMessage);
            return;
        }
        System.out.println(resultMessage);
    }
}
