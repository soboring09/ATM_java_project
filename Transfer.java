public class Transfer extends Transaction {
    private Keypad keypad;

    public Transfer(int accountNumber, Screen screen, BankDatabase bank, Keypad keypad) {
        super(accountNumber, screen, bank);
        this.keypad = keypad;
    }

    public void execute() {
        Screen screen = getScreen();
        BankDatabase bank = getBankDatabase();
        int myAccount = getAccountNumber();

        // Step 1 - ask user enter destination
        screen.displayMessage("\nEnter destination account number (0 to cancel): ");
        int toAccount = keypad.getInput();

        if (toAccount == 0) {
            screen.displayMessageLine("\nCancel...");
            return;
        }

        // cannot transfer to self
        if (toAccount == myAccount) {
            screen.displayMessageLine("\nCannot transfer to your own account!");
            return;
        }

        // check if account exist
        if (bank.authenticateUserExists(toAccount) == false) {
            screen.displayMessageLine("\nAccount not exist!");
            return;
        }

        // Step 2 - ask amount, allow decimal like 9.90
        screen.displayMessage("\nEnter amount to transfer (HKD, e.g. 100.50, 0 to cancel): ");
        double amount = keypad.getDoubleInput();

        if (amount == 0) {
            screen.displayMessageLine("\nCancel...");
            return;
        }

        if (amount <= 0) {
            screen.displayMessageLine("\nAmount must > 0");
            return;
        }

        // check balance
        double myBalance = bank.getAvailableBalance(myAccount);
        if (amount > myBalance) {
            screen.displayMessageLine("\nNot enough money!");
            return;
        }

        // do transfer
        bank.debit(myAccount, amount);
        bank.credit(toAccount, amount);

        screen.displayMessage("\nTransferred ");
        screen.displayDollarAmount(amount);
        screen.displayMessageLine(" to " + toAccount + " OK.");
    }
}
