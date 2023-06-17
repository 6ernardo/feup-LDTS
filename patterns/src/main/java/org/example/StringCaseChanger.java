package org.example;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String ret = "";

        for(int i=0; i<drink.getText().length(); i++){
            if(Character.isLowerCase(drink.getText().charAt(i))){
                ret+=Character.toUpperCase(drink.getText().charAt(i));
            }
            else{
                ret+=Character.toLowerCase(drink.getText().charAt(i));
            }
        }

        drink.setText(ret);
    }
}
