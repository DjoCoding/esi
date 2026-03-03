import java.util.Arrays;
import java.util.Map;

class Transaction {
    private final String type;
    private final double amount;
    private final double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        assert type.equals("DEPOSIT") || type.equals("WITHDRAW") : "Invalid type value";

        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return Map.ofEntries(
                Map.entry("type", this.type),
                Map.entry("amount", String.valueOf(this.amount)),
                Map.entry("balance_after", String.valueOf(this.balanceAfter))).toString();
    }
}

class TransactionLog {
    private Transaction[] entries;
    private int size;

    public TransactionLog() {
        this.size = 0;
        this.entries = new Transaction[50];
    }

    public TransactionLog(int initialSize) {
        this.size = 0;
        this.entries = new Transaction[initialSize];
    }

    public void add(Transaction t) {
        if (this.size >= this.entries.length)
            this.resize();
        this.entries[this.size] = t;
        this.size += 1;
    }

    public Transaction get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.entries[index];
    }

    public int count() {
        return this.size;
    }

    private void resize() {
        assert this.size >= this.entries.length : "Size must be bigger than the length";
        this.entries = Arrays.copyOf(this.entries, this.size * 2);
    }
}

class BankAccount {
    private final String owner;
    private double balance;
    private TransactionLog log;

    public BankAccount(String owner, double initialBalance, TransactionLog log) {
        this.owner = owner;
        this.balance = initialBalance;

        this.log = log;
        if (this.log == null) {
            this.log = new TransactionLog();
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be > 0");
        }
        this.balance += amount;
        this.log.add(new Transaction("DEPOSIT", amount, this.balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be > 0");
        }

        if (amount > this.balance) {
            throw new RuntimeException("Insufficient balance");
        }

        this.balance -= amount;
        this.log.add(new Transaction("WITHDRAW", amount, this.balance));
    }

    public void log() {
        for (int i = 0; i < this.log.count(); ++i) {
            Transaction t = this.log.get(i);
            System.out.println(t.toString());
        }
        System.out.println("%.4f".formatted(this.balance));
    }
}

record Operation(String type, double amount) {
}

class Operations {

    public static Operation[] operations = {
            new Operation("DEPOSIT", 100),
            new Operation("WITHDRAW", 50),
            new Operation("DEPOSIT", 100),
            new Operation("WITHDRAW", 50),
            new Operation("DEPOSIT", 100),
            new Operation("WITHDRAW", 50),
            new Operation("DEPOSIT", 100),
            new Operation("WITHDRAW", 50),
            new Operation("DEPOSIT", 100),
            new Operation("WITHDRAW", 50),
    };
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Mohammed Djaoued BOUHADDA", 0, null);
        for (Operation op : Operations.operations) {
            if (op.type().equals("WITHDRAW")) {
                account.withdraw(op.amount());
            } else {
                account.deposit(op.amount());
            }
        }
        account.log();
    }
}