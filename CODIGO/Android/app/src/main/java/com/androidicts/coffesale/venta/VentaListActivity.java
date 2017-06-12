package com.androidicts.coffesale.venta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.androidicts.coffesale.BaseActivity;
import com.androidicts.coffesale.R;
import com.androidicts.coffesale.di.HasComponent;
import com.androidicts.coffesale.di.componente.DaggerVentaComponente;
import com.androidicts.coffesale.di.componente.VentaComponente;

public class VentaListActivity extends BaseActivity
    implements HasComponent<VentaComponente>{

  private VentaComponente ventaComponente;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, VentaListActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    inicializarInyector();
    if(savedInstanceState == null) {
      addFragment(R.id.activity_main, new VentaListFragment());
    }
  }

  private void inicializarInyector() {
    ventaComponente = DaggerVentaComponente.builder()
        .aplicacionComponente(getAplicacionComponent())
        .activityModulo(getActivityModule())
        .build();
  }

  @Override public VentaComponente getComponent() {
    return ventaComponente;
  }
}