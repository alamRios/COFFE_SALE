package com.androidicts.coffesale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.androidicts.coffesale.di.componente.AplicacionComponente;
import com.androidicts.coffesale.di.modulo.ActivityModulo;
import javax.inject.Inject;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public abstract class BaseActivity extends AppCompatActivity{

  @Inject Navegador navegador;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getAplicacionComponent().inject(this);
  }

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
