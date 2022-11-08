package baseball.service;
public interface Service {
    void readyGame();
    int[] baseBall(char[] var1, char[] var2);
    int randNumGenerate(int var1, int var2);
    void check(char[] var1, char var2, int var3, int[] var4);
    void printBaseBallCount(int[] var1);
    void errorCheck(int var1);
}
