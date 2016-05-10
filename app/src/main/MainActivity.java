package com.actionbar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SearchView.OnQueryTextListener{
    private MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("标题");
//        bar.setDisplayHomeAsUpEnabled(true);
//        bar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
//        bar.setIcon(R.mipmap.ic_launcher);
//        bar.setLogo(R.mipmap.ic_launcher);
//        bar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.text).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        item = menu.findItem(R.id.main_menu);
        SearchView view = (SearchView) MenuItemCompat.getActionView(item);
        view.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                finish();
                break;
            case R.id.Setting:
                Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        boolean b = MenuItemCompat.expandActionView(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this,query,Toast.LENGTH_SHORT).show();
        MenuItemCompat.collapseActionView(item);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
