package com.l14gr05.proj.model.menu;

import java.util.Arrays;

public class LossMenu extends Menu {
    public LossMenu(){
        super();
        this.entries= Arrays.asList("Retry", "Quit");
    }

    public boolean isSelectedQuit() {
        return isSelected(1);
    }

    public boolean isSelectedRetry() {
        return isSelected(0);
    }
}
