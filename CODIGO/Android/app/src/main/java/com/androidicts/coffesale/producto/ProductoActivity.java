package com.androidicts.coffesale.producto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.androidicts.coffesale.BaseActivity;
import com.androidicts.coffesale.R;
import com.androidicts.coffesale.di.HasComponent;
import com.androidicts.coffesale.di.componente.DaggerProductoComponente;
import com.androidicts.coffesale.di.componente.ProductoComponente;

public class ProductoActivity extends BaseActivity
    implements HasComponent<ProductoComponente>{

  private ProductoComponente productoComponente;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    inicializarInyector();
    if(savedInstanceState == null) {
      addFragment(R.id.activity_producto, new ProductoListFragment());
    }

  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_producto_list, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override public int getContentViewId() {
    return R.layout.activity_producto;
  }

  @Override protected int getNavigationMenuItemId() {
    return R.id.action_productos;
  }

  @Override public ProductoComponente getComponent() {
    return productoComponente;
  }

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ProductoActivity.class);
  }

  private void inicializarInyector() {
    productoComponente = DaggerProductoComponente.builder()
        .aplicacionComponente(getAplicacionComponent())
        .activityModulo(getActivityModule())
        .build();
  }
}
