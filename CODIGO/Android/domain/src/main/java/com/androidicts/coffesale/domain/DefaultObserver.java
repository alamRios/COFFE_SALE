package com.androidicts.coffesale.domain;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class DefaultObserver<T> extends DisposableObserver<T> {

  @Override public void onNext(@NonNull T t) {

  }

  @Override public void onError(@NonNull Throwable e) {

  }

  @Override public void onComplete() {

  }
}
