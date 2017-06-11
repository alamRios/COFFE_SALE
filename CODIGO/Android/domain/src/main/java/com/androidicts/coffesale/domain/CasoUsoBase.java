package com.androidicts.coffesale.domain;

import com.androidicts.coffesale.domain.executor.PostExecutionThread;
import com.androidicts.coffesale.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public abstract class CasoUsoBase<T, Parametros> {

  private final ThreadExecutor threadExecutor;
  private final PostExecutionThread postExecutionThread;
  private final CompositeDisposable disposables;

  protected CasoUsoBase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
    this.threadExecutor = threadExecutor;
    this.postExecutionThread = postExecutionThread;
    this.disposables = new CompositeDisposable();
  }

  public abstract Observable<T> construirObservableCasoUso(Parametros parametros);

  public void ejecutar(DisposableObserver<T>observador, Parametros parametros) {
    final Observable<T> observable = this.construirObservableCasoUso(parametros)
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.getScheduler());

    agregarDisposable(observable.subscribeWith(observador));
  }

  public void disponer() {
    if(!disposables.isDisposed()) {
      disposables.dispose();
    }
  }

  private void agregarDisposable(Disposable disposable) {
    disposables.add(disposable);
  }
}
