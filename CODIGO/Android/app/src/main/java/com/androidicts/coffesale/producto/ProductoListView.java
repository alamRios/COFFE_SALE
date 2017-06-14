package com.androidicts.coffesale.producto;

import com.androidicts.coffesale.CargarDataView;
import java.util.List;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public interface ProductoListView extends CargarDataView {

  void mostrarListaProductos(List<ProductoModel> productoModels);
  void verProducto(ProductoModel productoModel);
}
