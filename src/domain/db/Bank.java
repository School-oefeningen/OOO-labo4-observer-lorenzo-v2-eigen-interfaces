package domain.db;

import domain.model.BankObserver;
import domain.model.DomainException;
import domain.model.Rekening;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements BankSubject {
    private Map<Integer, Rekening> rekeningen = new HashMap<Integer, Rekening>();
    private List<BankObserver> observers = new ArrayList<>();

    public Bank() {}

    public void addRekening(Rekening rekening) {
        if (rekening == null) throw new DomainException("Rekening can't be null");
        int rekeningNummer = getAmountOfRekeningen() + 1;
        rekeningen.put(rekeningNummer, rekening);
        notifyObservers(BankEvent.NEW, rekening, rekeningNummer, 0);
    }

    public int getAmountOfRekeningen() {
        return rekeningen.size();
    }

    public void deposit(int rekeningNummer, double amountToDeposit) {
        Rekening rekening = getRekening(rekeningNummer);
        rekening.deposit(amountToDeposit);
        notifyObservers(BankEvent.DEPOSIT, rekening, rekeningNummer, amountToDeposit);
    }

    public void withdraw(int rekeningNummer, double amountToWithdraw) {
        Rekening rekening = getRekening(rekeningNummer);
        rekening.withdraw(amountToWithdraw);
        notifyObservers(BankEvent.WITHDRAW, rekening, rekeningNummer, amountToWithdraw);
    }

    private Rekening getRekening(int rekeningNummer) {
        Rekening rekening = rekeningen.get(rekeningNummer);
        if (rekening == null) throw new DomainException("Rekening doesn't exist");
        return rekening;
    }

    @Override
    public void addObserver(BankObserver observer) {
        if (observer == null) throw new DomainException("Observer can't be null");
        observers.add(observer);
    }

    @Override
    public void removeObserver(BankObserver observer) {
        if (observer == null) throw new DomainException("Observer can't be null");
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(BankEvent event, Rekening rekening, int rekeningNummer, double amount) {
        for (BankObserver o: observers) {
            o.update(event, rekening, rekeningNummer, amount);
        }
    }
}
