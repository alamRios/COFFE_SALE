package com.androidicts.coffesale.venta;

import com.androidicts.coffesale.CargarDataView;
import java.util.List;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public interface VentaListView extends CargarDataView {

  void mostrarListaVentas(List<VentaModel> ventaModelList);

  void verVenta(VentaModel ventaModel);
}
