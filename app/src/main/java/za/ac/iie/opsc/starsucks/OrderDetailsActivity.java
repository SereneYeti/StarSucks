package za.ac.iie.opsc.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderDetailsActivity extends AppCompatActivity {

    private EditText etCustomerName;
    private EditText etCustomerCell;
    private TextView placedOrder;
    private String orderedValue;
    private ImageView imgOrderedBevarage;
    private FloatingActionButton fab;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        //initialise the fields
        order = new Order();
        fab = findViewById(R.id.fab_order);
        placedOrder = findViewById(R.id.tv_Drink);
        etCustomerName = findViewById(R.id.et_CustomerName);
        etCustomerCell = findViewById(R.id.et_CustomerNumber);
        imgOrderedBevarage = findViewById(R.id.img_orderedBeverage);

        //get the ordered value from the intent
        orderedValue = getIntent().getStringExtra("order");

        //set the ordered value on the text view
        placedOrder.setText(orderedValue);



        switch(orderedValue){
            case "Soy Latte":
                imgOrderedBevarage.setImageResource(R.drawable.sb1);
                break;
            case "Chocco Frappe":
                imgOrderedBevarage.setImageResource(R.drawable.sb2);
                break;
            case "Bottled Americano":
                imgOrderedBevarage.setImageResource(R.drawable.sb3);
                break;
            case "Rainbow Frapp":
                imgOrderedBevarage.setImageResource(R.drawable.sb4);
                break;
            case "Caramel Frapp ":
                imgOrderedBevarage.setImageResource(R.drawable.sb5);
                break;
            case "Black Forest Frapp":
                imgOrderedBevarage.setImageResource(R.drawable.sb6);
                break;
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentHelper.shareIntent(OrderDetailsActivity.this, orderedValue);
            }
        });
    }
}