package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

public enum Resize {
    B6x6(6,"6x6"),
    B8x8(8,"8x8"),
    B10x10(10,"10x10"),
    B12x12(12,"12x12");

    @Getter
    private final int size;
    @Getter
    private final String label;

    Resize(int size, String labal){
        this.size = size;
        this.label = labal;
    }
}
