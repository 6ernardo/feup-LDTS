package org.example;

public class StringReplacer implements StringTransformer {

    private Character a;
    private Character b;

    public StringReplacer(Character a, Character b){
        this.a=a;
        this.b=b;
    }

    @Override
    public void execute(StringDrink drink) {
        String ret= "";

        for(int i=0; i<drink.getText().length(); i++){
            if(drink.getText().charAt(i)==a){
                ret+=b;
            }
            else ret+=drink.getText().charAt(i);
        }

        drink.setText(ret);
    }
}
