package ov1;

public class Kaart {
    private double saldo;
    private boolean ingecheckt;

    public Kaart(double startSaldo) {
        this.saldo = Math.max(startSaldo, 0);
        this.ingecheckt = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void voegSaldoToe(double bedrag) {
        if (bedrag > 0) {
            saldo += bedrag;
            System.out.println("Nieuw saldo: " + saldo);
        } else {
            System.out.println("Ongeldig bedrag.");
        }
    }

    public boolean isIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(boolean status) {
        this.ingecheckt = status;
    }

    public boolean betaalRit(double ritKosten) {
        if (saldo >= ritKosten) {
            saldo -= ritKosten;
            return true;
        }
        return false;
    }
}
