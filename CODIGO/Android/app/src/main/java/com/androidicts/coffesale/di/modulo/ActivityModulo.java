package com.androidicts.coffesale.di.modulo;

import android.support.v7.app.AppCompatActivity;
import com.androidicts.coffesale.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Module
public class ActivityModulo {

  private AppCompatActivity activity;

  public ActivityModulo(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity AppCompatActivity activity() {
    return this.activity;
  }
}
