package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Controller {
    private static final String THREE_STRIKE = "3스트라이크";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    Controller() {
    }

    void start() {
        Controller controller = new Controller();
        View view = new View();
        Model model = new Model();

        int exit = 0;
        String result = "";

        view.gameStartText();
        model.setComputernumber(controller.randomNumber());

        while (true) {
            String number = view.numberInputText();
            model.setHumannumber(number);

            result = controller.compareNumber(model.getHumanArrayList(), model.getComputerArrayList(), model);
            view.gameResultOutputText(result);

            if (result.equals(THREE_STRIKE)) {
                exit = Integer.parseInt(view.victoryOutputText());
            }

            if (exit == 2) {
                view.gameEnd();
                break;
            } else if (exit == 1) {
                exit = 0;
                model.clearComputerArrayList();
                model.setComputernumber(controller.randomNumber());
            }
        }
    }

    String compareNumber(ArrayList<String> humanlist, ArrayList<String> computerlist, Model model) {
        Controller controller = new Controller();
        ArrayList<String> computerlistcopy = controller.copyList(computerlist);

        int strike = controller.countStrike(humanlist, computerlist);
        computerlistcopy = controller.removeComputerListCopy(humanlist, computerlist, computerlistcopy);
        int ball = controller.countBall(humanlist, computerlistcopy);

        computerlistcopy.clear();
        model.clearHumanArrayList();

        String result = controller.combineText(strike, ball);
        return result;
    }

    int countStrike(ArrayList<String> humanlist, ArrayList<String> computerlist) {
        int strike = 0;

        for (int pointer = 0; pointer < 3; pointer++) {
            if (humanlist.get(pointer).equals(computerlist.get(pointer))) {
                strike++;
            }
        }
        return strike;
    }

    int countBall(ArrayList<String> humanlist, ArrayList<String> computerlistcopy) {
        int ball = 0;

        for (int pointer = 0; pointer < 3; pointer++) {
            if (computerlistcopy.contains(humanlist.get(pointer))) {
                ball++;
            }
        }
        return ball;
    }

    ArrayList<String> removeComputerListCopy(ArrayList humanlist, ArrayList computerlist, ArrayList computerlistcopy) {
        for (int pointer = 0; pointer < 3; pointer++) {
            if (humanlist.get(pointer).equals(computerlist.get(pointer))) {
                computerlistcopy.remove(humanlist.get(pointer));
            }
        }
        return computerlistcopy;
    }

    ArrayList<String> copyList(ArrayList<String> original) {
        ArrayList<String> copy = new ArrayList<>();

        for (String index : original) {
            copy.add(index);
        }
        return copy;
    }

    String combineText(int strike, int ball) {
        String result = "";

        if (strike == 3) {
            result = THREE_STRIKE;
        } else if (strike > 0 && strike < 3 && ball == 0) {
            result = strike + STRIKE;
        } else if (strike > 0 && strike < 3 && ball > 0) {
            result = ball + BALL + " " + strike + STRIKE;
        } else if (strike == 0 && ball > 0) {
            result = ball + BALL;
        } else if (strike == 0 && ball == 0) {
            result = NOTHING;
        }
        return result;
    }

    String randomNumber() {
        int randomnumber = 0;

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        randomnumber = computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
        String result = Integer.toString(randomnumber);
        return result;
    }
}
