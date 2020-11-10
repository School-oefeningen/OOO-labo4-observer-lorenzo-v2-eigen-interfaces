package domain.model;

import domain.db.Bank;
import domain.db.BankEvent;

import java.time.LocalDate;

public class Auditor implements BankObserver {

    public Auditor(Bank bank) {
        bank.addObserver(this);
    }

    @Override
    public void update(BankEvent event, Rekening rekening, int rekeningNummer , double amount) {

        if (event == BankEvent.NEW) {
            String out = String.format("Nieuwe rekening geopend op datum %s met nummer %s en saldo %s.", LocalDate.now(), rekeningNummer, rekening.getSaldo());
            System.out.println(out);
        }
    }
}
