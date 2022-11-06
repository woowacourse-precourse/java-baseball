package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Controller {
    Controller() {}

    void start() {
        Controller controller = new Controller();
        View view = new View();
        Model model = new Model();

        int exit = 0;
        String result = "";

        view.gameStartText();
        model.setComputernumber(controller.randomNumber());
        System.out.println(model.getComputernumber());

        while(true) {
            String number = view.numberInputText();
            model.setHumannumber(number);

            result = controller.compareNumber(model.getHumanArrayList(), model.getComputerArrayList(), model);
            view.gameResultOutputText(result);

            if(result.equals("3스트라이크")) {
                exit = Integer.parseInt(view.victoryOutputText());
            }

            if(exit == 2) {
                view.gameEnd();
                break;
            } else if(exit == 1){
                exit = 0;
                model.clearComputerArrayList();
                model.setComputernumber(controller.randomNumber());
            }
        }
    }

    String compareNumber(ArrayList<String> humanarraylist, ArrayList<String> computerarraylist, Model model) {
        Controller controller = new Controller();

        ArrayList<String> ballcomputerarraylist = controller.copyArrayList(computerarraylist);
        String result = "";

        int strike = controller.countStrike(humanarraylist, computerarraylist);
        ballcomputerarraylist = controller.countBallArrayList(humanarraylist, computerarraylist, ballcomputerarraylist);
        int ball = controller.countBall(humanarraylist, ballcomputerarraylist);

        ballcomputerarraylist.clear();
        model.clearHumanArrayList();
        result = controller.combineStrike(strike, ball);

        return result;
    }

    int countStrike(ArrayList<String> humanarraylist, ArrayList<String> computerarraylist) {
        int strike = 0;

        for(int pointer = 0; pointer < 3; pointer++) {
            if(humanarraylist.get(pointer).equals(computerarraylist.get(pointer))) {
                strike++;
            }
        }

        return strike;
    }

    int countBall(ArrayList<String> humanarraylist, ArrayList<String> ballcomputerarraylist) {
        int ball = 0;

        for(int pointer = 0; pointer < 3; pointer++) {
            if(ballcomputerarraylist.contains(humanarraylist.get(pointer))) {
                ball++;
            }
        }

        return ball;
    }

    ArrayList<String> countBallArrayList(ArrayList<String> humanarraylist, ArrayList<String> computerarraylist, ArrayList<String> ballcomputerarraylist) {

        for(int pointer = 0; pointer < 3; pointer++) {
            if(humanarraylist.get(pointer).equals(computerarraylist.get(pointer))) {
                ballcomputerarraylist.remove(humanarraylist.get(pointer));
            }
        }

        return ballcomputerarraylist;
    }

    ArrayList<String> copyArrayList(ArrayList<String> original) {
        ArrayList<String> copy = new ArrayList<>();

        for(String index : original) {
            copy.add(index);
        }

        return copy;
    }

    String combineStrike(int strike, int ball) {
        String result = "";

        if(strike == 3) {
            result = "3스트라이크";
        } else if(strike > 0 && strike < 3 && ball == 0) {
            result = strike + "스트라이크";
        } else if(strike > 0 && strike < 3 && ball > 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if(strike == 0 && ball > 0) {
            result = ball + "볼";
        } else if(strike == 0 && ball == 0) {
            result = "낫싱";
        }

        return result;
    }

    String randomNumber() {
        String result = "";
        int randomnumber = 0;

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        randomnumber = computer.get(0) *100 + computer.get(1) * 10 + computer.get(2);
        result = Integer.toString(randomnumber);

        return result;
    }
}
