package ov1;

public class Paaltje {

    public void checkIn(Kaart kaart) {
        if (!kaart.isIngecheckt()) {
            kaart.setIngecheckt(true);
            System.out.println("Je bent ingecheckt.");
        } else {
            System.out.println("Je bent al ingecheckt.");
        }
    }

    public void checkUit(Kaart kaart, double ritKosten) {
        if (kaart.isIngecheckt()) {
            if (kaart.betaalRit(ritKosten)) {
                System.out.println("Je bent uitgecheckt. Ritkosten: " + ritKosten + ", Nieuw saldo: " + kaart.getSaldo());
            } else {
                System.out.println("Onvoldoende saldo om uit te checken.");
            }
            kaart.setIngecheckt(false);
        } else {
            System.out.println("Je bent niet ingecheckt.");
        }
    }
}
