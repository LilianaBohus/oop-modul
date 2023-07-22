package bank;

import java.math.BigDecimal;

public class BankAccount {

    private String accountName;
    private BigDecimal balance;
    private final String accountNumber;

    public BankAccount(String name, String accountNumber) {
        this.accountName = name;
        this.balance = new BigDecimal(0);
        this.accountNumber = accountNumber;
    }

    public BankAccount(String name, BigDecimal balance, String accountNumber) {
        this.accountName = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance = balance.add(new BigDecimal(amount));
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(double amount) throws InsufficentBalanceException {
        if (amount < balance.doubleValue())
            balance = balance.subtract(new BigDecimal(amount));
        else
            throw new InsufficentBalanceException(String.format("Cannot withdraw set amount %s because balance is %s", amount, balance));
    }

    public void withdraw(BigDecimal amount) throws InsufficentBalanceException {
        if (balance.compareTo(amount) > 0)
            balance = balance.subtract(amount);
        else
            throw new InsufficentBalanceException(String.format("Cannot withdraw set amount %s because balance is %s", amount, balance));
    }

    public void transfer(BankAccount target, BigDecimal amount) throws InsufficentBalanceException {
        this.withdraw(amount);
        target.deposit(amount);
    }

    public void transfer(BankAccount target, double amount) throws InsufficentBalanceException {
        this.withdraw(amount);
        target.deposit(amount);
    }

    public static boolean isValidAccountNumber(BankAccount account) {
        String parsedNumber = account.getAccountNumber().replace(" ", "").replace("-", "");

        int sum = 0;
        for (int i = 0; i < parsedNumber.length(); i++) {
            sum += parseCharToInt(parsedNumber.charAt(i));
        }

        boolean sameParity =
                parseCharToInt(parsedNumber.charAt(0)) % 2 ==
                parseCharToInt(parsedNumber.charAt(parsedNumber.length() - 1)) % 2;

        return sum >= 20 && sameParity;
    }

    private static int parseCharToInt(char parsedNumber) {
        return Integer.parseInt(String.valueOf(parsedNumber));
    }

    class InsufficentBalanceException extends Throwable {
        public InsufficentBalanceException(String message) {
            super(message);
        }
    }
}
