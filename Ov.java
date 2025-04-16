package ov1;

import java.util.Scanner;

public class Ov {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer startsaldo in: ");
        double startSaldo = scanner.nextDouble();

        Kaart kaart = new Kaart(startSaldo);
        Paaltje paaltje = new Paaltje();

        boolean actief = true;
        while (actief) {
            System.out.println("\nMenu:");
            System.out.println("1. Bekijk saldo");
            System.out.println("2. Voeg saldo toe");
            System.out.println("3. Check in");
            System.out.println("4. Check uit");
            System.out.println("5. Stoppen");
            System.out.print("Kies een optie: ");
            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    System.out.println("Huidig saldo: " + kaart.getSaldo());
                    break;
                case 2:
                    System.out.print("Voer bedrag in: ");
                    double bedrag = scanner.nextDouble();
                    kaart.voegSaldoToe(bedrag);
                    break;
                case 3:
                    paaltje.checkIn(kaart);
                    break;
                case 4:
                    System.out.print("Voer ritkosten in: ");
                    double ritKosten = scanner.nextDouble();
                    paaltje.checkUit(kaart, ritKosten);
                    break;
                case 5:
                    System.out.println("Programma gestopt.");
                    actief = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze, probeer opnieuw.");
            }
        }

        scanner.close();
    }
}
