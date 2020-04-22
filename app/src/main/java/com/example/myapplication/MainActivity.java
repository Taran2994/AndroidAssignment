package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spin1;
    EditText edit1;
    EditText edit2;
    RadioGroup rg;
    String meal;
    Button order;
    Double price = 0.0;
    int quantity= 1;
    int tippp=10;
    double totalPrice;
    SeekBar sb;
    ImageView img;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1=findViewById(R.id.spinner);
        edit1=findViewById(R.id.editText);
        edit2=findViewById(R.id.editText2);
        sb= findViewById(R.id.seekBar);
        rg=findViewById(R.id.radioGroup);
        img=findViewById(R.id.imageView);
        order=findViewById(R.id.button);
        cb= findViewById(R.id.checkBox);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton10)
                {
                    tippp=10;

                } else if (checkedId == R.id.radioButton15)
                {
                    tippp=15;

                }
                else if (checkedId == R.id.radioButton20)
                {
                    tippp=20;

                }
                calPrice(tippp,quantity,price);
            }
        });
        spin1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                meal= spin1.getSelectedItem().toString();
                if(meal.equals("Burrito"))
                {
                    price=10.00;
                    edit1.setText("$10");
                    img.setImageResource(R.drawable.burrito);




                }
                else if(meal.equals("Pizza"))
                {
                    edit1.setText("$11");
                    price=11.00;
                    img.setImageResource(R.drawable.pizza);
                }
                else if(meal.equals("Chicken wings"))
                {
                    edit1.setText("$12");
                    price=12.00;
                    img.setImageResource(R.drawable.chicken);
                }
                else if(meal.equals("Burger"))
                {
                    edit1.setText("$13");
                    price=13.00;
                    img.setImageResource(R.drawable.burger);
                }
                else if(meal.equals("Fries"))
                {
                    edit1.setText("$14");
                    price=14.00;
                    img.setImageResource(R.drawable.fries);
                }
                else if(meal.equals("Steak"))
                {
                    edit1.setText("$15");
                    price=15.00;
                    img.setImageResource(R.drawable.steak);
                }
                else if(meal.equals("Butter Chicken"))
                {
                    edit1.setText("$16");
                    price=16.00;
                    img.setImageResource(R.drawable.butter);
                }
                else if(meal.equals("Pancakes"))
                {
                    edit1.setText("$17");
                    price=17.00;
                    img.setImageResource(R.drawable.pancakes);
                }
                else if(meal.equals("Salad"))
                {
                    edit1.setText("$18");
                    price=18.00;
                    img.setImageResource(R.drawable.salad);
                }
                else if(meal.equals("Coffee"))
                {
                    edit1.setText("$19");
                    price=19.00;
                    img.setImageResource(R.drawable.coffee);
                }
                calPrice(tippp,quantity,price);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }




        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantity= progress;
                calPrice(tippp,quantity,price);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked() &&
                        !(edit1.getText().toString().equalsIgnoreCase(""))&&!(edit2.getText().toString().equalsIgnoreCase("")))
                {
                    Orders order= new Orders(meal,totalPrice);
                    SingletonClass.getInstance().orderList.add(order);


                    Intent intent= new Intent(getApplicationContext(),Display.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter all values and Checkbox",
                            Toast.LENGTH_LONG).show();
                }
            }
        });





    }
    public void calPrice(double tip, int quantity, double price)
    {
        double tipp= (price*quantity*tip) / 100;
        double tax=(price*quantity)*0.13;
        totalPrice= (price*quantity)+tipp+tax;
        edit2.setText(""+totalPrice);
    }
}













