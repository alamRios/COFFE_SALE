package com.androidicts.coffesale.producto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.androidicts.coffesale.R;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by alejandro on 12/06/17.
 * Androidicts.com
 */

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder> {

  private List<ProductoModel> productoModelList;
  private OnItemClickListener clickListener;

  @Inject
  public ProductosAdapter() {
    productoModelList = Collections.emptyList();
  }

  @Override
  public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_producto, parent, false);
    return new ProductosViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ProductosViewHolder holder, int position) {
    final ProductoModel productoModel = productoModelList.get(position);
    holder.txtProductoNombre.setText(productoModel.getNombre());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        clickListener.onProductoClicked(productoModel);
      }
    });
  }

  @Override public int getItemCount() {
    return productoModelList.size();
  }

  public void setProductoModelList(List<ProductoModel> productoModelList) {
    if(productoModelList == null) {
      throw new IllegalArgumentException("La lista de productos no pueden ser null");
    }
    this.productoModelList = productoModelList;
    notifyDataSetChanged();
  }

  public void setClickListener(OnItemClickListener clickListener) {
    this.clickListener = clickListener;
  }

  interface OnItemClickListener {
    void onProductoClicked(ProductoModel productoModel);
  }

  class ProductosViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_producto_nombre) TextView txtProductoNombre;

    public ProductosViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
