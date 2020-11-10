package domain.model;

import domain.db.BankEvent;

public interface BankObserver {

    public void update(BankEvent event, Rekening rekening, int rekeningNummer, double amount);
}
