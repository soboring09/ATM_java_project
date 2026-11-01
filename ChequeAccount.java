public class ChequeAccount extends Account {
    private double limitPerCheque;
    public ChequeAccount(int theAccountNumber, int thePIN, 
                         double theAvailableBalance, double theTotalBalance) {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        this.limitPerCheque = 50000.0; 
    }
    public double getLimitPerCheque() {
        return limitPerCheque;
    }
    public void setLimitPerCheque(double limitPerCheque) {
        if (limitPerCheque >= 0.0) {
            this.limitPerCheque = limitPerCheque;
        } else {
            throw new IllegalArgumentException("Limit per cheque must be >= 0.0");
        }
    }
}