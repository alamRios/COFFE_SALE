package com.androidicts.coffesale.venta;

import android.support.annotation.NonNull;
import com.androidicts.coffesale.MensajeErrorFactory;
import com.androidicts.coffesale.Presenter;
import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.domain.DefaultObserver;
import com.androidicts.coffesale.domain.exception.DefaultErrorBundle;
import com.androidicts.coffesale.domain.exception.ErrorBundle;
import com.androidicts.coffesale.domain.venta.ObtenerVentasCasoUso;
import com.androidicts.coffesale.domain.venta.Venta;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@PerActivity
public class VentaListPresenter implements Presenter {

  private VentaListView ventaListView;

  private final ObtenerVentasCasoUso ventasCasoUso;
  private final VentaModelDataMapper ventaModelDataMapper;

  @Inject
  public VentaListPresenter(ObtenerVentasCasoUso ventasCasoUso,
      VentaModelDataMapper ventaModelDataMapper) {
    this.ventasCasoUso = ventasCasoUso;
    this.ventaModelDataMapper = ventaModelDataMapper;
  }

  public void setView(@NonNull VentaListView ventaListView) {
    this.ventaListView = ventaListView;
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  @Override public void destroy() {
    ventasCasoUso.disponer();
    ventaListView = null;
  }

  public void inicializar() {
    cargarListaVenta();
  }

  public void onVentaClicked(VentaModel ventaModel) {
    ventaListView.verVenta(ventaModel);
  }

  private void cargarListaVenta() {
    ocultarReintentar();
    mostrarCargando();
    getListaVentas();
  }

  private void getListaVentas() {
    ventasCasoUso.ejecutar(new VentaListObservable(), null);
  }

  private void mostrarCargando() {
    ventaListView.mostrarCargando();
  }

  private void ocultarCargando() {
    ventaListView.ocultarCargando();
  }

  private void mostrarReintentar() {
    ventaListView.mostrarReintentar();
  }

  private void ocultarReintentar() {
    ventaListView.ocultarReintentar();
  }

  private void mostrarListaVentasEnVista(List<Venta> ventaLista) {
    final List<VentaModel> ventaList =
        ventaModelDataMapper.transformar(ventaLista);
    ventaListView.mostrarListaVentas(ventaList);
  }

  private void mostrarMensajeError(ErrorBundle errorBundle) {
    String mensajeError = MensajeErrorFactory.crear(ventaListView.context(),
        errorBundle.getException());

    ventaListView.mostrarError(mensajeError);
    Timber.d("hola");
    Timber.d(errorBundle.getException().getMessage());
  }

  private final class VentaListObservable extends DefaultObserver<List<Venta>> {

    @Override public void onNext(List<Venta> ventas) {
      mostrarListaVentasEnVista(ventas);
    }

    @Override public void onError(Throwable e) {
      ocultarCargando();
      mostrarMensajeError(new DefaultErrorBundle((Exception)e));
      mostrarReintentar();
    }

    @Override public void onComplete() {
      ocultarCargando();
    }

  }
}
