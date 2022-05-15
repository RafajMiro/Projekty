package sk.stuba.fei.uim.oop.rybnik.aktivnekarty;

import sk.stuba.fei.uim.oop.rybnik.Rybnik;
import sk.stuba.fei.uim.oop.utility.KeyboardInput;

public class DivokyBill extends AktivnaKarta{
    public DivokyBill() {
        this.name = "Divoky Bill";
    }
    @Override
    public void pouziKartu(Rybnik rybnik){
        int vyberPola = KeyboardInput.readInt("Vyber pole kde chces zamierit a vystrelit");
        while(true){
            if(vyberPola>=1&&vyberPola<=6)break;
            else vyberPola=KeyboardInput.readInt("Mojko poli je 6, tak daj cislo 1-6");
        }
        vyberPola -=1;
        for(int i=0; i<rybnik.getPocetHracov(); i++){
            if(rybnik.getRybnik().get(vyberPola).getName().equals("Kacka hraca "+(i+1))){
                rybnik.getHraci().get(i).strataZivota();
                for(int j=vyberPola;j<5;j++){
                    rybnik.getRybnik().set(j, rybnik.getRybnik().get(j+1));
                }
                rybnik.getRybnik().set(5, rybnik.getBalicekNeaktivnychKariet().get(0));
                rybnik.getBalicekNeaktivnychKariet().remove(0);
                break;
            }else if(rybnik.getRybnik().get(vyberPola).getName().equals("Voda")){
                System.out.println("Trafil si vodu");
                break;
            }
        }
        rybnik.getStavZamerania().get(vyberPola).setZamierene(false,"Nezamierene");
    }
    public String getName(){
        return this.name;
    }
}
