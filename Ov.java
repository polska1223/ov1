package ov1;

import java.util.Scanner;

public class Ov {
    private double saldo;
    private boolean ingecheckt;

    public Ov(double startSaldo) {
        saldo = Math.max(startSaldo, 0);
        ingecheckt = false;
    }

    public double bekijkSaldo() {
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

    public void checkIn() {
        if (!ingecheckt) {
            ingecheckt = true;
            System.out.println("Je bent ingecheckt.");
        } else {
            System.out.println("Je bent al ingecheckt.");
        }
    }
    
    public void checkUit(double ritKosten) {
        if (ingecheckt) {
            if (saldo >= ritKosten) {
                saldo -= ritKosten;
                System.out.println("Je bent uitgecheckt. Ritkosten: " + ritKosten + ", Nieuw saldo: " + saldo);
            } else {
                System.out.println("Onvoldoende saldo om uit te checken.");
            }
            ingecheckt = false;
        } else {
            System.out.println("Je bent niet ingecheckt.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer startsaldo in: ");
        double startSaldo = scanner.nextDouble();
        Ov mijnKaart = new Ov(startSaldo);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Bekijk saldo");
            System.out.println("2. Voeg saldo toe");
            System.out.println("3. Check in");
            System.out.println("4. Check uit");
            System.out.println("5. Stoppen");
            System.out.print("Kies een optie: ");
            int keuze = scanner.nextInt();

            if (keuze == 1) {
                System.out.println("Huidig saldo: " + mijnKaart.bekijkSaldo());
            } else if (keuze == 2) {
                System.out.print("Voer bedrag in: ");
                double bedrag = scanner.nextDouble();
                mijnKaart.voegSaldoToe(bedrag);
            } else if (keuze == 3) {
                mijnKaart.checkIn();
            } else if (keuze == 4) {
                System.out.print("Voer ritkosten in: ");
                double ritKosten = scanner.nextDouble();
                mijnKaart.checkUit(ritKosten);
            } else if (keuze == 5) {
                System.out.println("Programma gestopt.");
                scanner.close();
                break;
            } else {
                System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }
    }
}
