package sk.stuba.fei.uim.oop.rybnik.aktivnekarty;

import sk.stuba.fei.uim.oop.rybnik.Rybnik;

public class KacaciPochod extends AktivnaKarta{
    public KacaciPochod(){
        this.name = "Kacaci pochod";
    }
    @Override
    public void pouziKartu(Rybnik rybnik){
        rybnik.getBalicekNeaktivnychKariet().add(rybnik.getRybnik().get(0));
        for(int i=0;i<5;i++){
            rybnik.getRybnik().set(i,rybnik.getRybnik().get(i+1));
        }
        rybnik.getRybnik().set(5,rybnik.getBalicekNeaktivnychKariet().get(0));
        rybnik.getBalicekNeaktivnychKariet().remove(0);
    }
    public String getName(){
        return this.name;
    }
}