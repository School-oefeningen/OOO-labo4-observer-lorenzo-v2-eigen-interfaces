package domain.model;

public class Rekening {
    private double saldo;

    public Rekening(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        if (saldo < 0) throw new DomainException("Saldo must be positive");
        this.saldo = saldo;
    }

    public void deposit(double amountToDeposit) {
        if (amountToDeposit < 0) throw new DomainException("Amount to deposit must be positive");
        setSaldo(getSaldo() + amountToDeposit);
    }

    public void withdraw(double amountToWithdraw) {
        double newSaldo = getSaldo() - amountToWithdraw;
        if (newSaldo < 0) throw new DomainException("Amount to withdraw is too great");
        setSaldo(newSaldo);
    }
}
