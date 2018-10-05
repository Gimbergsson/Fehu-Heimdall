package com.fehu.wallet.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.fehu.wallet.R;
import com.fehu.wallet.fragments.AccountFragment;
import com.fehu.wallet.fragments.CheckoutFragment;
import com.fehu.wallet.fragments.MainFragment;
import com.fehu.wallet.fragments.ScannerFragment;
import com.fehu.wallet.network.api.ApiManager;
import com.fehu.wallet.network.repositories.BlockchainCurrencyPriceRepo;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private ApiManager apiManager;
    private BlockchainCurrencyPriceRepo blockchainCurrencyPriceRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for (int i = 0; 5 > i; i++) {
            Log.d("DB Address", DebugDB.getAddressLog());
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_camera);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));

        apiManager = ApiManager.getInstance();


        blockchainCurrencyPriceRepo = apiManager.getBlockchainCurrencyPricesRepo(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (blockchainCurrencyPriceRepo != null) {
            blockchainCurrencyPriceRepo.truncateDb();
        }
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
        getMenuInflater().inflate(R.menu.main2, menu);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

        switch (item.getItemId()) {
            case R.id.nav_camera:
                transaction.replace(R.id.main_container, new MainFragment().getInstance());
                break;
            case R.id.nav_gallery:
                transaction.replace(R.id.main_container, new CheckoutFragment().getInstance());
                break;
            case R.id.nav_slideshow:
                transaction.replace(R.id.main_container, new ScannerFragment().getInstance());
                break;
            case R.id.nav_manage:
                transaction.replace(R.id.main_container, new AccountFragment().getInstance());
                break;
            case R.id.nav_share:
                Toast.makeText(this, "nav_share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "nav_send", Toast.LENGTH_SHORT).show();
                break;
        }

        transaction.commit();
        return true;
    }
}
