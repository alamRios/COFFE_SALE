package com.androidicts.coffesale.venta;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.androidicts.coffesale.R;
import com.androidicts.coffesale.producto.ProductoModel;
import com.androidicts.coffesale.vendedor.VendedorModel;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class VentasAdapter extends
    RecyclerView.Adapter<VentasAdapter.VentasViewHolder>{

  private List<VentaModel> ventaModelList;

  private OnItemClickListener clickListener;

  @Inject
  public VentasAdapter() {
    this.ventaModelList = Collections.emptyList();
  }

  @Override
  public VentasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater
        .from(parent.getContext())
        .inflate(R.layout.item_venta, parent, false);
    return new VentasViewHolder(view);
  }

  @Override public void onBindViewHolder(VentasViewHolder holder, int position) {
    final VentaModel ventaModel = ventaModelList.get(position);
    VendedorModel vendedorModel = ventaModel.getVendedor();
    List<ProductoModel> productoModels = ventaModel.getProductos();

    String vendedor =  String.format(
            "%s %s",
            vendedorModel.getNombre(),
            vendedorModel.getApellidoPaterno()
    );
    String productos = "";
    for(ProductoModel productoModel: productoModels) {
      productos += " " + productoModel.getNombre() + ",";
    }
    productos = productos.substring(0, productos.length() -1);
    holder.txtFecha.setText(ventaModel.getMomentoVenta());
    holder.txtPrecio.setText(String.valueOf(ventaModel.getMontoTotal()));
    holder.txtVendedor.setText(vendedor);
    holder.txtProductos.setText(productos);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if(clickListener != null) {
          clickListener.onVentaItemClicked(ventaModel);
        }
      }
    });
  }

  @Override public int getItemCount() {
    return ventaModelList.size();
  }

  public void setVentaModelList(List<VentaModel> ventaModelList) {
    if(ventaModelList == null) {
      throw new IllegalArgumentException("La lista no puede ser null");
    }
    this.ventaModelList = ventaModelList;
    notifyDataSetChanged();
  }

  public void setClickListener(OnItemClickListener clickListener) {
    this.clickListener = clickListener;
  }

  class VentasViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_fecha) TextView txtFecha;
    @BindView(R.id.txt_precio) TextView txtPrecio;
    @BindView(R.id.txt_productos) TextView txtProductos;
    @BindView(R.id.txt_vendedor) TextView txtVendedor;

    public VentasViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public interface OnItemClickListener {
    void onVentaItemClicked(VentaModel ventaModel);
  }
}
