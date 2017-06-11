package com.androidicts.coffesale.di.componente;

import android.support.v7.app.AppCompatActivity;
import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.di.modulo.ActivityModulo;
import dagger.Component;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@PerActivity
@Component(dependencies = AplicacionComponente.class, modules = ActivityModulo.class)
public interface ActivityComponente {

  AppCompatActivity activity();
}
