package baseball;

import baseball.Controller.Simulation;

public class Application {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }

}
