package domain.db;

import domain.model.BankObserver;
import domain.model.Rekening;

public interface BankSubject {

    public void addObserver(BankObserver observer);

    public void removeObserver(BankObserver observer);

    public void notifyObservers(BankEvent event, Rekening rekening, int rekeningNummer, double amount);
}
