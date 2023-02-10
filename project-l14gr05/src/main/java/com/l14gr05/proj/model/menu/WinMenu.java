package com.l14gr05.proj.model.menu;

import java.util.Arrays;

public class WinMenu extends Menu{
    private int finalscore;
    public WinMenu(int finalscore){
        super();
        this.entries= Arrays.asList("Play Again", "Exit");
        this.finalscore=finalscore;
    }

    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }

    public boolean isSelectedExit(){
        return isSelected(1);
    }

    public int getFinalscore() {
        return finalscore;
    }
}
