package repository;

import data.ComputerData;

import java.util.List;

public class ComputerRepository {
    private ComputerData computerData;

    public ComputerRepository(ComputerData computerData){
        this.computerData=computerData;
    }

    public void setRandomNum(){
        computerData.setRandomNum();
    }

    public List<Integer> getComputerData(){
        return computerData.getComputerData();
    }

    public Integer getDataIndex(Integer integer){
        return computerData.getDataIndex(integer);
    }
}