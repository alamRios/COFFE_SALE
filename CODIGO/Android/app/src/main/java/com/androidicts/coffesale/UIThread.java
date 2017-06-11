package com.androidicts.coffesale;

import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Singleton
public class UIThread implements PostExecutionThread {

  @Inject
  public UIThread() {}

  @Override public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
