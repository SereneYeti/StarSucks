package za.ac.iie.opsc.starsucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private ImageView img_sb1;
    private ImageView img_sb2;
    private ImageView img_sb3;
    private ImageView img_sb4;
    private ImageView img_sb5;
    private ImageView img_sb6;
    private Order order;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleOnOff;
    private  NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_nav_drawer);

        toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggleOnOff = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggleOnOff);
        toggleOnOff.syncState();

        navigationView = findViewById(R.id.nav_View);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        order = new Order();

        img_sb1 = findViewById(R.id.img_SB1);
        img_sb2 = findViewById(R.id.img_SB2);
        img_sb3 = findViewById(R.id.img_SB3);
        img_sb4 = findViewById(R.id.img_SB4);
        img_sb5 = findViewById(R.id.img_SB5);
        img_sb6 = findViewById(R.id.img_SB6);

        img_sb1.setOnClickListener(this);
        img_sb2.setOnClickListener(this);
        img_sb3.setOnClickListener(this);
        img_sb4.setOnClickListener(this);
        img_sb5.setOnClickListener(this);
        img_sb6.setOnClickListener(this);

        /*img_sb1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(MainActivity.this, "Coffee 1",Toast.LENGTH_SHORT).show();
         }
         });
        img_sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee 2",Toast.LENGTH_SHORT).show();
            }
        });
        img_sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee 3",Toast.LENGTH_SHORT).show();
            }
        });
        img_sb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee 4",Toast.LENGTH_SHORT).show();
            }
        });
        img_sb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee 5",Toast.LENGTH_SHORT).show();
            }
        });
        img_sb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Coffee 6",Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_SB1:
                Toast.makeText(MainActivity.this, "Soy Latte", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_SB2:
                Toast.makeText(MainActivity.this, "Chocco Frappe", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_SB3:
                Toast.makeText(MainActivity.this, "Bottled Americano", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_SB4:
                Toast.makeText(MainActivity.this, "Rainbow Frapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_SB5:
                Toast.makeText(MainActivity.this, "Caramel Frapp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_SB6:
                Toast.makeText(MainActivity.this, "Black Forest Frapp", Toast.LENGTH_SHORT).show();
                break;
        }
        Toast.makeText(MainActivity.this, "MMM " +
                order.getProductName(),Toast.LENGTH_SHORT).show();
        order.intentHelper.openIntent(this,
                order.getCustomerName(),OrderDetailsActivity.class);
    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START))
       {
           drawerLayout.closeDrawer(GravityCompat.START);
       }
       else
       {
           super.onBackPressed();
       }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId()))
        {
            case R.id.nav_Photo:
                IntentHelper.openIntent(this, "", CoffeeSnapsActivity.class);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return  true;
    }
}
