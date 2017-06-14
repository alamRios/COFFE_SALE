package com.androidicts.coffesale;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.androidicts.coffesale.di.componente.AplicacionComponente;
import com.androidicts.coffesale.di.modulo.ActivityModulo;
import javax.inject.Inject;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public abstract class BaseActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener{

  @Inject Navegador navegador;
  @BindView(R.id.bottom_navigation) protected BottomNavigationView navigationView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getContentViewId());
    ButterKnife.bind(this);
    this.getAplicacionComponent().inject(this);
    navigationView.setOnNavigationItemSelectedListener(this);
  }

  @Override
  public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
    navigationView.postDelayed(new Runnable() {
      @Override public void run() {
        int itemId = item.getItemId();
        if (itemId == R.id.action_ventas) {
          navegador.navegarAListaVentas(BaseActivity.this);
        } else if(itemId == R.id.action_productos) {
          navegador.navegarAListaProductos(BaseActivity.this);
        } else if(itemId == R.id.action_cafeterias) {

        }
        finish();
      }
    }, 300);
    return true;
  }

  @Override
  protected void onStart() {
    super.onStart();
    updateNavigationBarState();
  }

  @Override
  public void onPause() {
    super.onPause();
    overridePendingTransition(0, 0);
  }

  private void updateNavigationBarState(){
    int actionId = getNavigationMenuItemId();
    selectBottomNavigationBarItem(actionId);
  }

  void selectBottomNavigationBarItem(int itemId) {
    Menu menu = navigationView.getMenu();
    for (int i = 0, size = menu.size(); i < size; i++) {
      MenuItem item = menu.getItem(i);
      boolean shouldBeChecked = item.getItemId() == itemId;
      if (shouldBeChecked) {
        item.setChecked(true);
        break;
      }
    }
  }

  public abstract int getContentViewId();

  protected abstract int getNavigationMenuItemId();

  protected void addFragment(int containerViewId, Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .add(containerViewId, fragment)
        .commit();
  }


  protected AplicacionComponente getAplicacionComponent() {
    return ((CoffeApplication) getApplication()).getAplicacionComponente();
  }

  protected ActivityModulo getActivityModule() {
    return new ActivityModulo(this);
  }

}
