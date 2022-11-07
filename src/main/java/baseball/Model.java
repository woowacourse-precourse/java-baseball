package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Model {
    private ArrayList<String> humanlist;
    private ArrayList<String> computerlist;
    private String humannumber;
    private String computernumber;

    Model() {
    }

    /*
     *Below Human number Method
     */
    public String getHumannumber() {
        return humannumber;
    }

    public void setHumannumber(String humannumber) {
        Model model = new Model();

        model.isContainChar(humannumber);
        model.isContainZero(humannumber);
        model.isCorrectRange(humannumber);
        humanlist = model.isDuplicate(humannumber);

        this.humannumber = humannumber;
    }

    public ArrayList<String> getHumanArrayList() {
        return humanlist;
    }

    public void clearHumanArrayList() {
        humanlist.clear();
    }

    /*
     *Below Computer number Method
     */
    public String getComputernumber() {
        return computernumber;
    }

    public void setComputernumber(String computernumber) {
        this.computernumber = computernumber;
        computerlist = new ArrayList<>(Arrays.asList(computernumber.split("")));
    }

    public ArrayList<String> getComputerArrayList() {
        return computerlist;
    }

    public void clearComputerArrayList() {
        computerlist.clear();
    }

    /*
     *Below Exception Method
     */
    private void isContainChar(String humannumber) {
        try {
            int number = Integer.parseInt(humannumber);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void isContainZero(String humannumber) {
        if (humannumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectRange(String humannumber) {
        if (humannumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private ArrayList<String> isDuplicate(String humannumber) {
        HashSet<String> hashset = new HashSet<>(Arrays.asList(humannumber.split("")));
        ArrayList<String> arraylsit = new ArrayList<>(Arrays.asList(humannumber.split("")));

        if (hashset.size() != arraylsit.size()) {
            throw new IllegalArgumentException();
        }
        return arraylsit;
    }
}
