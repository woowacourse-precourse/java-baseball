package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Model {
    private ArrayList<String> humanarraylist;
    private ArrayList<String> computerarraylist;

    Model() { }

    private String humannumber;
    private String computernumber;

    public String getHumannumber() {
        return humannumber;
    }

    public void setHumannumber(String humannumber) {
        Model model = new Model();

        model.isContainChar(humannumber);
        model.isContainZero(humannumber);
        model.isCorrectRange(humannumber);
        humanarraylist = model.isDuplicate(humannumber);

        this.humannumber = humannumber;
    }

    public String getComputernumber() {
        return computernumber;
    }

    public void setComputernumber(String computernumber) {
        this.computernumber = computernumber;
        computerarraylist = new ArrayList<>(Arrays.asList(computernumber.split("")));
    }

    public ArrayList<String> getHumanArrayList() {
        return humanarraylist;
    }

    public ArrayList<String> getComputerArrayList() {
        return computerarraylist;
    }

    public void clearComputerArrayList() {
        computerarraylist.clear();
    }

    public void clearHumanArrayList() {
        humanarraylist.clear();
    }

    private void isContainChar(String humannumber) {
        int number = 0;

        try {
            number = Integer.parseInt(humannumber);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }//공백 확인
    }

    private void isContainZero(String humannumber) {
        if(humannumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectRange(String humannumber) {
        if(humannumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private ArrayList<String> isDuplicate(String humannumber) {
        HashSet<String> hashset = new HashSet<>(Arrays.asList(humannumber.split("")));
        ArrayList<String> arraylsit = new ArrayList<>(Arrays.asList(humannumber.split("")));

        if(hashset.size() != arraylsit.size()) {
            throw new IllegalArgumentException();
        }

        return arraylsit;
    }
}
