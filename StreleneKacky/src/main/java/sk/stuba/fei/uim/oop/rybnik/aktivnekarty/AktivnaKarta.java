package sk.stuba.fei.uim.oop.rybnik.aktivnekarty;

import sk.stuba.fei.uim.oop.rybnik.Rybnik;

public abstract class AktivnaKarta {
    protected String name;

    public abstract void pouziKartu(Rybnik rybnik);

    public String getName() {
        return name;
    }
}
