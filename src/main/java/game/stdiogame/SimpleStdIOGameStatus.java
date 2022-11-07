package game.stdiogame;

import game.GameStatus;

public class SimpleStdIOGameStatus extends GameStatus {
    private String inputData;
    private String outputData;

    public SimpleStdIOGameStatus() {
        super();
        inputData = null;
        outputData = null;
    }

    public String getInputData() {
        return inputData;
    }

    public String getOutputData() {
        return outputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }
}
