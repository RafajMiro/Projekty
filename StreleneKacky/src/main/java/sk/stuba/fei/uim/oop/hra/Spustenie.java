package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

import java.util.ArrayList;
import java.util.List;

public class Spustenie {
    Rybnik hra = new Rybnik();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private final List<Integer> mrtvyHraci = new ArrayList<>();

    public Spustenie() {
        spusti();
    }
    public void spusti() {
        System.out.println(ANSI_YELLOW+"          HRA ZACINA"+ANSI_RESET);
        int aktivPocet = hra.getPocetHracov();
        int i = 0;
        while (aktivPocet > 1) {
            if(hra.getHraci().get(i).isHraczije()){
                System.out.println(ANSI_BLUE+"-------------------------------");
                hra.vypisPola();
                System.out.println("-------------------------------"+ANSI_RESET);
                hra.vypisHraca(i);
                int ks = 0, kz=0, pz=0, vyber;
                for(int k=0;k<3;k++){
                    if(hra.getHraci().get(i).getKartyHraca().get(k).getName().equals("Vystrelit"))ks++;
                    if(hra.getHraci().get(i).getKartyHraca().get(k).getName().equals("Zamierit"))kz++;
                }
                for(int k=0;k<6;k++){
                    if(hra.getStavZamerania().get(k).isZamierene())pz++;
                }
                if(pz == 0 && ks == 3){
                    System.out.println("Nemozes pouzit ziadnu kartu, lebo nikde nie je zamierene, prichadzas o kolo");
                    vyber = KeyboardInput.readInt("Stlac 1 pre pokracovanie");
                }else if (pz == 6 && kz == 3){
                    System.out.println("Nemozes pouzit ziadnu kartu, lebo vsade je zamierene, prichadzas o kolo");
                    vyber = KeyboardInput.readInt("Stlac 1 pre pokracovanie");
                }else if(pz == 0 && ks < 3){
                    System.out.println("-------------------------------");
                    vyber = KeyboardInput.readInt("Vyber kartu, ktora sa pouzije");
                    while(true){
                        if(vyber>=1&&vyber<=3)break;
                        else{
                            vyber=KeyboardInput.readInt("Mojko mas 3 karty, tak daj cislo 1-3");
                        }
                    }
                    while (true) {
                        if (hra.getHraci().get(i).getKartyHraca().get(vyber - 1).getName().equals("Vystrelit")) {
                            vyber = KeyboardInput.readInt("Prosim vyber inu kartu, tuto zahrat nemozes");
                            while(true){
                                if(vyber>=1&&vyber<=3)break;
                                else{
                                    vyber=KeyboardInput.readInt("Mojko mas 3 karty, tak daj cislo 1-3");
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    hra.getHraci().get(i).getKartyHraca().get(vyber-1).pouziKartu(hra);
                    System.out.println("-------------------------------");
                }else if(pz == 6 && kz < 3){
                    System.out.println("-------------------------------");
                    vyber = KeyboardInput.readInt("Vyber kartu, ktora sa pouzije");
                    while(true){
                        if(vyber>=1&&vyber<=3)break;
                        else{
                            vyber=KeyboardInput.readInt("Mojko mas 3 karty, tak daj cislo 1-3");
                        }
                    }
                    while (true) {
                        if (hra.getHraci().get(i).getKartyHraca().get(vyber - 1).getName().equals("Zamierit")) {
                            vyber = KeyboardInput.readInt("Prosim vyber inu kartu, tuto zahrat nemozes");
                            while(true){
                                if(vyber>=1&&vyber<=3)break;
                                else{
                                    vyber=KeyboardInput.readInt("Mojko mas 3 karty, tak daj cislo 1-3");
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    hra.getHraci().get(i).getKartyHraca().get(vyber-1).pouziKartu(hra);
                    System.out.println("-------------------------------");
                }else{
                    System.out.println("-------------------------------");
                    vyber = KeyboardInput.readInt("Vyber kartu, ktora sa ma pouzit");
                    while(true){
                        if(vyber>=1&&vyber<=3)break;
                        else{
                            vyber=KeyboardInput.readInt("Mojko mas 3 karty, tak daj cislo 1-3");
                        }
                    }
                    hra.getHraci().get(i).getKartyHraca().get(vyber - 1).pouziKartu(hra);
                    System.out.println("-------------------------------");
                }
                hra.getBalicekAktivnychKariet().add(hra.getHraci().get(i).getKartyHraca().get(vyber - 1));
                hra.getHraci().get(i).vymazKartu(vyber);
                hra.getHraci().get(i).setKartyHraca(hra.getBalicekAktivnychKariet().get(0));
                hra.getBalicekAktivnychKariet().remove(0);
            }
            if(!hra.getHraci().get(i).isHraczije() && !mrtvyHraci.contains(hra.getHraci().get(i).getCislo())) {
                aktivPocet -= 1;
                mrtvyHraci.add(i+1);
                for (int h=0;h<3;h++){
                    hra.getBalicekAktivnychKariet().add(hra.getHraci().get(i).getKartyHraca().get(i));
                }
                if(aktivPocet == 1) break;
            }
            i++;
            if(i==hra.getPocetHracov())i=0;
        }
        vypisVytaza();
    }
    public void vypisVytaza(){
        for (int j = 0; j < hra.getPocetHracov(); j++) {
            if (hra.getHraci().get(j).isHraczije()) {
                System.out.println(ANSI_YELLOW+"        Vyhral hrac " + hra.getHraci().get(j).getCislo()+ANSI_RESET);
                break;
            }
        }
    }
}