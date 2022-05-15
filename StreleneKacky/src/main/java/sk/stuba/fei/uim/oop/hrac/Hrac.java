package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.rybnik.aktivnekarty.AktivnaKarta;

import java.util.ArrayList;
import java.util.List;

public class Hrac {
    private final int cislo;
    private int zivoty;
    private final List<AktivnaKarta> kartyHraca;
    private boolean hraczije;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public Hrac(int cislo){
        this.cislo = cislo;
        this.zivoty = 5;
        this.kartyHraca = new ArrayList<>(3);
        this.hraczije = true;
    }

    public int getCislo(){
        return cislo;
    }
    public int getZivoty(){
        return zivoty;
    }
    public void setKartyHraca(AktivnaKarta kartaHraca) {
        this.kartyHraca.add(kartaHraca);
    }
    public List<AktivnaKarta> getKartyHraca() {
        return this.kartyHraca;
    }
    public boolean isHraczije() {
        return hraczije;
    }
    public void vymazKartu(int cislokarty){
        this.kartyHraca.remove(cislokarty-1);
    }
    public void strataZivota(){
        System.out.println("Hrac "+this.cislo+" stratil 1 zivot");
        this.zivoty -=1;
        if (this.zivoty == 0){
            System.out.println(ANSI_RED+"Hrac "+this.cislo+" stratil vsetky zivoty => vypadava"+ANSI_RESET);
            this.hraczije = false;
        }else{
            System.out.println("Pocet zivotov hraca "+this.cislo+" je teraz:"+this.zivoty);
        }
    }
}