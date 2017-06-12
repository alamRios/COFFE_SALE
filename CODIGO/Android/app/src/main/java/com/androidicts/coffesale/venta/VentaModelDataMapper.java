package com.androidicts.coffesale.venta;

import com.androidicts.coffesale.di.PerActivity;
import com.androidicts.coffesale.domain.venta.Venta;
import com.androidicts.coffesale.gaveta.GavetaModelDataMapper;
import com.androidicts.coffesale.producto.ProductoModelDataMapper;
import com.androidicts.coffesale.vendedor.VendedorModelDataMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@PerActivity
public class VentaModelDataMapper {

  @Inject
  public VentaModelDataMapper() {}

  public VentaModel transformar(Venta venta) {
    if(venta == null) {
      throw new IllegalArgumentException("Imposible transformar valor nulo");
    }

    final VentaModel ventaModel = new VentaModel();
    ventaModel.setMontoTotal(venta.getMontoTotal());
    ventaModel.setGaveta(GavetaModelDataMapper.transformar(venta.getGaveta()));
    ventaModel.setMomentoVenta(venta.getMomentoVenta());
    ventaModel.setProductos(ProductoModelDataMapper.transformar(venta.getProductos()));
    ventaModel.setVendedor(VendedorModelDataMapper.transformar(venta.getVendedor()));

    return ventaModel;
  }

  public List<VentaModel> transformar(List<Venta> ventaCollection) {
    List<VentaModel> ventaModels;

    if(ventaCollection != null && !ventaCollection.isEmpty()) {
      ventaModels = new ArrayList<>();
      for(Venta venta: ventaCollection) {
        ventaModels.add(transformar(venta));
      }
    } else {
      ventaModels = Collections.emptyList();
    }

    return ventaModels;
  }
}
