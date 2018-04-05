package com.example.andrewclark.calculator_clark;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String totalEntry = "0 + ";
    String currentEntry = "";
    String currentSymbol = "";
    String PlusMin = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button butC = (Button) findViewById(R.id.butC);
        Button butCE = (Button) findViewById(R.id.butCE);
        Button butPlusMin = (Button) findViewById(R.id.butPlusMin);

        Button butDiv = (Button) findViewById(R.id.butDiv);
        Button butMulti = (Button) findViewById(R.id.butMulti);
        Button butPlus = (Button) findViewById(R.id.butPlus);
        Button butSub = (Button) findViewById(R.id.butSub);

        Button butEquals = (Button) findViewById(R.id.butEquals);


        Button butDot = (Button) findViewById(R.id.butDot);
        Button but0 = (Button) findViewById(R.id.but0);
        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button) findViewById(R.id.but2);
        Button but3 = (Button) findViewById(R.id.but3);
        Button but4 = (Button) findViewById(R.id.but4);
        Button but5 = (Button) findViewById(R.id.but5);
        Button but6 = (Button) findViewById(R.id.but6);
        Button but7 = (Button) findViewById(R.id.but7);
        Button but8 = (Button) findViewById(R.id.but8);
        Button but9 = (Button) findViewById(R.id.but9);














        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "C");
                currentEntry = "";
                totalEntry = "0 + ";
                PlusMin = "";

            }
        });

        butCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "CE");
                currentEntry = "";
                PlusMin = "";

            }
        });

        butPlusMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(PlusMin.equals("+")) {
                    PlusMin = "+";
                    totalEntry = addSymbol(totalEntry, " + ");
                }else if(PlusMin.equals("-")) {
                    PlusMin = "-";
                    totalEntry = addSymbol(totalEntry, " - ");
                } else {
                    PlusMin = "+";
                    totalEntry = addSymbol(totalEntry, " + ");
                }
            }
        });

        butDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalEntry += currentEntry;
                totalEntry = addSymbol(totalEntry, " / ");
                currentEntry = "";
                updateDisplay("");
            }
        });

        butMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalEntry += currentEntry;
                totalEntry = addSymbol(totalEntry, " * ");
                currentEntry = "";
                updateDisplay("");
            }
        });

        butPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalEntry += currentEntry;
                totalEntry = addSymbol(totalEntry, " + ");
                currentEntry = "";
                updateDisplay("");

            }
        });

        butSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalEntry += currentEntry;
                totalEntry = addSymbol(totalEntry, " - ");
                currentEntry = "";
                updateDisplay("");
            }
        });


        butEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("totalEntry: ", totalEntry);

                updateDisplay(calculate(totalEntry, currentEntry));
                currentEntry = "";
                totalEntry = "0 + ";
                PlusMin = "";
            }
        });








        butDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!currentEntry.contains(".")) {
                    currentEntry += ".";
                    updateDisplay(currentEntry);
                }

            }
        });

        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "0";
                updateDisplay(currentEntry);
            }
        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "1";
                updateDisplay(currentEntry);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "2";
                updateDisplay(currentEntry);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "3";
                updateDisplay(currentEntry);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "4";
                updateDisplay(currentEntry);
            }
        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "5";
                updateDisplay(currentEntry);
            }
        });

        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "6";
                updateDisplay(currentEntry);
            }
        });

        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "7";
                updateDisplay(currentEntry);
            }
        });


        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "8";
                updateDisplay(currentEntry);
            }
        });

        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentEntry += "9";
                updateDisplay(currentEntry);
            }
        });


    }


    private void updateDisplay(String value) {
        TextView display = (TextView) findViewById(R.id.textView);
        display.setText(value);
    }

    private void clearDisplay() {
        TextView display = (TextView) findViewById(R.id.textView);
        display.setText("");
    }

    private String calculate(String totalEntry, String currentEntry) {
        totalEntry += currentEntry;
        Log.i("addSymbol: ", "totalEntry: " + totalEntry + " currentEntry: " + currentEntry);

        String[] splitEntry = totalEntry.split(" ");


        float currentNumber = 0;
        String currentSymbol = "";
        float total = 0;

        for(int i = 2; i < splitEntry.length; i = i + 2) {
            Log.i("i: ", Integer.toString(i));
            currentSymbol = splitEntry[i - 1];

            currentNumber = Float.parseFloat(splitEntry[i]);

//            if(currItem.equals("+") || currItem.equals("-") || currItem.equals("/") || currItem.equals("*")) {
//                currentSymbol = currItem;
////                Log.i("Num: ", currentSymbol);
//
//            } else {
//                currentNumber = Float.parseFloat(currItem);
////                Log.i("Num: ", Float.toString(currentNumber));
//
//            }

            try {
                if (!currentSymbol.equals("") && currentSymbol.equals("+")) {
                    total = total + currentNumber;
                    Log.i("Add: ", total + " + " + Float.toString(currentNumber));
                } else if (!currentSymbol.equals("") && currentSymbol.equals("-")) {
                    total = total - currentNumber;
                    Log.i("Subtract: ", total + " - " + Float.toString(currentNumber));
                } else if (!currentSymbol.equals("") && currentSymbol.equals("*")) {
                    total = total * currentNumber;
                    Log.i("Multiplying: ", total + " * " + Float.toString(currentNumber));
                } else if (!currentSymbol.equals("") && currentSymbol.equals("/")) {
                    total = total / currentNumber;
                    Log.i("Dividing: ", total + " / " + Float.toString(currentNumber));
                } else {
                    updateDisplay("Error");
                }
            } catch(Exception e) {
                updateDisplay(e.getMessage());
            }




        }

        Log.i("Result: ", Float.toString(total));



        return Float.toString(total);
    }




    private String addSymbol(String Entry, String newSymbol) {
        int len = Entry.length();

        if(len >= 4) {
            String symbolVal = Entry.substring(len - 3,len);

            if(symbolVal.equals(" + ") || symbolVal.equals(" - ") || symbolVal.equals(" / ") || symbolVal.equals(" * ")) {
                Entry = Entry.substring(0, len-3);
                Log.i("addSymbol: ",symbolVal);
            } else {
                Log.i("addSymbol: ","no symbol found");
            }
        }


        Entry += newSymbol;

        return Entry;
    }





}
