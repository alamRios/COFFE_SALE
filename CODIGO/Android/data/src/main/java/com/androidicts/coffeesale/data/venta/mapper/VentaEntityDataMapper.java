package com.androidicts.coffeesale.data.venta.mapper;

import com.androidicts.coffeesale.data.gaveta.mapper.GavetaEntityDataMapper;
import com.androidicts.coffeesale.data.producto.mapper.ProductoEntityDataMapper;
import com.androidicts.coffeesale.data.vendedor.mapper.VendedorEntityDataMapper;
import com.androidicts.coffeesale.data.venta.VentaEntity;
import com.androidicts.coffesale.domain.venta.Venta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

@Singleton
public class VentaEntityDataMapper {

  //TODO: Refactor to non-static methods

  @Inject
  public VentaEntityDataMapper() {}

  public static Venta transformar(VentaEntity ventaEntity) {
    Venta venta = null;
    if(ventaEntity != null) {
      venta = new Venta();
      venta.setGaveta(GavetaEntityDataMapper.transformar(ventaEntity.getGaveta()));
      venta.setMomentoVenta(ventaEntity.getMomentoVenta());
      venta.setMontoTotal(ventaEntity.getMontoTotal());
      venta.setVendedor(VendedorEntityDataMapper.transformar(ventaEntity.getVendedor()));
      venta.setProductos(ProductoEntityDataMapper.transformar(ventaEntity.getProductos()));
    }
    return venta;
  }

  public static List<Venta> transformar(Collection<VentaEntity> ventaEntityCollection) {
    final List<Venta> ventaList = new ArrayList<>();
    for(VentaEntity ventaEntity: ventaEntityCollection) {
      final Venta venta = transformar(ventaEntity);
      if(venta != null) {
        ventaList.add(venta);
      }
    }
    return ventaList;
  }
}
