package com.androidicts.coffesale.di.componente;

import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.di.modulo.ActivityModulo;
import com.androidicts.coffesale.di.modulo.VentaModulo;
import com.androidicts.coffesale.venta.VentaListFragment;
import dagger.Component;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@PerActivity
@Component(dependencies = AplicacionComponente.class,
            modules = { ActivityModulo.class, VentaModulo.class})
public interface VentaComponente extends ActivityComponente{

  void inject(VentaListFragment ventaListFragment);
}
