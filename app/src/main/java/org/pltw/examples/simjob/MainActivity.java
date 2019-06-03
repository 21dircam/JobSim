package org.pltw.examples.simjob;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity 
        implements NavigationView.OnNavigationItemSelectedListener {

    private Money money;
    private TextView etMoneyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // I changed this
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMoneyCount = findViewById(R.id.et_moneyCount);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createMoney();





        findViewById(R.id.bt_makeMoney).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money.addMoney(1);
                etMoneyCount.setText(Double.toString(money.getMoney()));
                Backendless.Persistence.save(money, new AsyncCallback<Money>() {
                    public void handleResponse(Money response) {
                        money = response;
                    }

                    public void handleFault(BackendlessFault fault) {

                    }

                    {

                    }
                });


            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void createMoney(){

        Backendless.Data.of(Money.class).find(new AsyncCallback<List<Money>>() {
            @Override
            public void handleResponse(List<Money> response) {
                if(response != null && response.size() > 0){
                    money = response.get(0);
                    etMoneyCount.setText(Double.toString(money.getMoney()));
                }else{
                    money = new Money();
                    money.setMoney(Double.parseDouble(etMoneyCount.getText().toString()));
                    money.addMoney(1);
                    etMoneyCount.setText(Double.toString(money.getMoney()));
                    Backendless.Persistence.save(money, new AsyncCallback<Money>() {
                        public void handleResponse(Money response) {
                            money = response;
                        }

                        public void handleFault(BackendlessFault fault) {

                        }

                        {

                        }
                    });
                }

            }


            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });


    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_shop) {
            Intent intent = new Intent(MainActivity.this, ShopActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
