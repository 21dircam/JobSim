package org.pltw.examples.simjob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.security.Key;
import java.util.List;

public class ShopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Money money;
    private int cost;
    private Keyboard keyboard;
    private Suit suit;
    private Computer computer;
    private Promotion promotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.bt_KeyBoard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost = 4;
                Backendless.Data.of(Keyboard.class).find(new AsyncCallback<List<Keyboard>>() {
                    @Override
                    public void handleResponse(List<Keyboard> response) {
                        if(response != null && response.size() > 0){
                            keyboard = response.get(0);
                            keyboard.mulitplyKeyboard(4);
                            Backendless.Persistence.save(keyboard,  new AsyncCallback<Keyboard>() {
                                public void handleResponse(Keyboard response) {
                                    keyboard = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                        else{
                            keyboard = new Keyboard();
                            keyboard.mulitplyKeyboard(4);
                            Backendless.Persistence.save(keyboard,  new AsyncCallback<Keyboard>() {
                                public void handleResponse(Keyboard response) {
                                    keyboard = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                    }


                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });



            }
        });
        findViewById(R.id.bt_Suit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost = 10;
                Backendless.Data.of(Suit.class).find(new AsyncCallback<List<Suit>>() {
                    @Override
                    public void handleResponse(List<Suit> response) {
                        if(response != null && response.size() > 0){
                            suit = response.get(0);
                            suit.mulitplySuit(2);
                            Backendless.Persistence.save(suit,  new AsyncCallback<Suit>() {
                                public void handleResponse(Suit response) {
                                    suit = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                        else{
                            suit = new Suit();
                            suit.mulitplySuit(2);
                            Backendless.Persistence.save(suit,  new AsyncCallback<Suit>() {
                                public void handleResponse(Suit response) {
                                    suit = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                    }


                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });




            }
        });
        findViewById(R.id.bt_Computer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost = 100;
                Backendless.Data.of(Computer.class).find(new AsyncCallback<List<Computer>>() {
                    @Override
                    public void handleResponse(List<Computer> response) {
                        if(response != null && response.size() > 0){
                            computer = response.get(0);
                            computer.mulitplyComputer(4);
                            Backendless.Persistence.save(computer,  new AsyncCallback<Computer>() {
                                public void handleResponse(Computer response) {
                                    computer = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                        else{
                            computer = new Computer();
                            computer.mulitplyComputer(2);
                            Backendless.Persistence.save(computer,  new AsyncCallback<Computer>() {
                                public void handleResponse(Computer response) {
                                    computer = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                    }


                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });




            }
        });
        findViewById(R.id.bt_Promtion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost = 100000;
                Backendless.Data.of(Promotion.class).find(new AsyncCallback<List<Promotion>>() {
                    @Override
                    public void handleResponse(List<Promotion> response) {
                        if(response != null && response.size() > 0){
                            promotion = response.get(0);
                            promotion.mulitplyPromotion(100);
                            Backendless.Persistence.save(promotion,  new AsyncCallback<Promotion>() {
                                public void handleResponse(Promotion response) {
                                    promotion = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                        else{
                            promotion = new Promotion();
                            promotion.mulitplyPromotion(100);
                            Backendless.Persistence.save(promotion,  new AsyncCallback<Promotion>() {
                                public void handleResponse(Promotion response) {
                                    promotion = response;
                                }

                                public void handleFault(BackendlessFault fault) {

                                }

                                {

                                }
                            });
                            subtractMoney();
                        }
                    }


                    @Override
                    public void handleFault(BackendlessFault fault) {

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

    private void subtractMoney(){
        Backendless.Data.of(Money.class).find(new AsyncCallback<List<Money>>() {
            @Override
            public void handleResponse(List<Money> response) {
                money = response.get(0);
                money.subtractMoney(cost);
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
        getMenuInflater().inflate(R.menu.shop_page, menu);
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

        if (id == R.id.nav_home) {
            Intent intent = new Intent(ShopActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(ShopActivity.this, AboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
