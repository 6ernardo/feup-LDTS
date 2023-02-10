package org.example;

public class StringBar extends Bar{
    private boolean happyhour;

    public StringBar(){
        happyhour=false;
    }

    @Override
    public boolean isHappyHour() {
        return happyhour;
    }

    @Override
    public void startHappyHour() {
        happyhour=true;
    }

    @Override
    public void endHappyHour() {
        happyhour=false;
    }
}
