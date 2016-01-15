package support;

/**
 * Created by Dorian on 13-Jan-16.
 */
public class TimeLimit {
    protected long startTime;
    protected double timeLimit;
    protected int combinationLimit;
    protected int totalCombinations = 1;

    protected boolean countTime = false;
    protected boolean countCombinations = false;

    /**
     if the method is called it sets the time limit on the program
     @param timeLimit
     */
    public void setTimeLimit(double timeLimit){
        this.timeLimit = timeLimit * 1000;
        this.countTime = true;
    }
    /**
     if the method is called it  sets the combination count limit
     on to the program
     @param combinationLimit
     */
    public void setCombinationLimit(int combinationLimit){
        this.combinationLimit = combinationLimit;
        this.countCombinations = true;
    }
    
    public int getTotalCombos() {
    	return totalCombinations;
    }
    /**
     checkLimits method checks whether either
     a) surpassed time is above the limit
     b) surpassed tried combinations is above the limit
     @return boolean true if limit is surpassed
     */
    public boolean checkLimits(){
        if (countTime){
            return (System.currentTimeMillis() - startTime > timeLimit);
        }
        if(countCombinations){
            totalCombinations++;
            return (totalCombinations > combinationLimit);
        }
        return false;
    }

}
