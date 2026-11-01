public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(int theAccountNumber, int thePIN, 
                          double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        this.interestRate = 0.005;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0.0) {
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("Interest rate must be >= 0.0");
        }
    }
}