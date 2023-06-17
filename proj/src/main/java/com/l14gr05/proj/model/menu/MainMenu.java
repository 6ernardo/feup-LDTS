package com.l14gr05.proj.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {
    public MainMenu(){
        super();
        this.entries= Arrays.asList("Start", "Exit");
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }
}
