package domain.model;

import domain.db.Bank;
import domain.db.BankEvent;

public class RekeningLogger implements BankObserver {

    public RekeningLogger(Bank bank) {
        bank.addObserver(this);
    }

    @Override
    public void update(BankEvent event, Rekening rekening, int rekeningNummer, double amount) {
        String out;

        switch (event) {
            case NEW:
                out = String.format("Log: nieuwe rekening met nummer %s en saldo %s.", rekeningNummer, rekening.getSaldo());
                break;
            default:
                out = String.format("Log: %s op rekening %s met hoeveelheid %s, nieuw saldo: %s.", event, rekeningNummer, amount, rekening.getSaldo());
        }

        System.out.println(out);
    }
}
