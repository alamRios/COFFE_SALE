package com.androidicts.coffesale.di.componente;

import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.di.modulo.ActivityModulo;
import com.androidicts.coffesale.di.modulo.ProductoModulo;
import com.androidicts.coffesale.producto.ProductoListFragment;
import dagger.Component;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

@PerActivity
@Component(dependencies = AplicacionComponente.class,
    modules = { ActivityModulo.class, ProductoModulo.class})
public interface ProductoComponente  extends ActivityComponente{
  void inject(ProductoListFragment productoListFragment);
}
