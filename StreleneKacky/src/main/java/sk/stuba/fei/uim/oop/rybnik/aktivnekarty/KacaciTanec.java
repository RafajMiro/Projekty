package sk.stuba.fei.uim.oop.rybnik.aktivnekarty;

import sk.stuba.fei.uim.oop.rybnik.Rybnik;

import java.util.Collections;

public class KacaciTanec extends AktivnaKarta{
    public KacaciTanec(){
        this.name = "Kacaci tanec";
    }
    @Override
    public void pouziKartu(Rybnik rybnik){
        for(int i = 0;i<6;i++){
            rybnik.getBalicekNeaktivnychKariet().add(rybnik.getRybnik().get(0));
            rybnik.getRybnik().remove(0);
        }
        Collections.shuffle(rybnik.getBalicekNeaktivnychKariet());
        for(int i = 0;i<6;i++){
            rybnik.getRybnik().add(rybnik.getBalicekNeaktivnychKariet().get(0));
            rybnik.getBalicekNeaktivnychKariet().remove(0);
        }



    }
    public String getName(){
        return this.name;
    }
}
