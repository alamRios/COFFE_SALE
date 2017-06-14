package com.androidicts.coffesale.producto;

import android.support.annotation.NonNull;
import com.androidicts.coffesale.MensajeErrorFactory;
import com.androidicts.coffesale.Presenter;
import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.domain.DefaultObserver;
import com.androidicts.coffesale.domain.exception.DefaultErrorBundle;
import com.androidicts.coffesale.domain.exception.ErrorBundle;
import com.androidicts.coffesale.domain.producto.ObtenerProductosCasoUso;
import com.androidicts.coffesale.domain.producto.Producto;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

@PerActivity
public class ProductoListPresenter implements Presenter {

  private ProductoListView productoListView;


  private final ObtenerProductosCasoUso obtenerProductosCasoUso;
  private final ProductoModelDataMapper productoModelDataMapper;

  @Inject
  public ProductoListPresenter(ObtenerProductosCasoUso obtenerProductosCasoUso,
      ProductoModelDataMapper productoModelDataMapper) {
    this.obtenerProductosCasoUso = obtenerProductosCasoUso;
    this.productoModelDataMapper = productoModelDataMapper;
  }

  public void setProductoListView(@NonNull ProductoListView productoListView) {
    this.productoListView = productoListView;
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  @Override public void destroy() {
    obtenerProductosCasoUso.disponer();
    productoListView = null;
  }

  public void inicializar() {
    cargarListaVenta();
  }

  public void onProductoClicked(ProductoModel productoModel) {
    productoListView.verProducto(productoModel);
  }

  private void cargarListaVenta() {
    ocultarReintentar();
    mostrarCargando();
    getListaProductos();
  }

  private void getListaProductos() {
    obtenerProductosCasoUso.ejecutar(new ProductoListObservable(), null);
  }

  private void mostrarCargando() {
    productoListView.mostrarCargando();
  }

  private void ocultarCargando() {
    productoListView.ocultarCargando();
  }

  private void mostrarReintentar() {
    productoListView.mostrarReintentar();
  }

  private void ocultarReintentar() {
    productoListView.ocultarReintentar();
  }

  private void mostrarListaProductosEnVista(List<Producto> productoList) {
    final List<ProductoModel> productoModelList =
        ProductoModelDataMapper.transformar(productoList);
    productoListView.mostrarListaProductos(productoModelList);
  }

  private void mostrarMensajeError(ErrorBundle errorBundle) {
    String mensajeError = MensajeErrorFactory.crear(productoListView.context(),
        errorBundle.getException());

    productoListView.mostrarError(mensajeError);
  }

  private final class ProductoListObservable extends DefaultObserver<List<Producto>> {

    @Override public void onNext(List<Producto> productos) {
      mostrarListaProductosEnVista(productos);
    }

    @Override public void onError(Throwable e) {
      ocultarCargando();
      mostrarMensajeError(new DefaultErrorBundle((Exception)e));
      Timber.d(e);
      mostrarReintentar();
    }

    @Override public void onComplete() {
      ocultarCargando();
    }

  }
}
