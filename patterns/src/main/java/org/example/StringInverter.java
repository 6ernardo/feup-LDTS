package org.example;

public class StringInverter implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        StringBuilder sb = new StringBuilder(drink.getText());

        sb.reverse();

        drink.setText(sb.toString());
    }

}
