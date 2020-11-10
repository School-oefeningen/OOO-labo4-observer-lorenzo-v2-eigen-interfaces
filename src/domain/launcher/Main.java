package domain.launcher;

import domain.db.Bank;
import domain.model.Auditor;
import domain.model.Rekening;
import domain.model.RekeningLogger;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Auditor auditor = new Auditor(bank);
        RekeningLogger rekeningLogger = new RekeningLogger(bank);

        Rekening rekening = new Rekening(100);
        bank.addRekening(rekening);
        bank.deposit(1, 500);
        bank.withdraw(1, 200);

        System.out.println();

        Rekening rekening2 = new Rekening(350);
        bank.addRekening(rekening2);
        bank.deposit(2, 50);
        bank.withdraw(2, 100);
    }
}
