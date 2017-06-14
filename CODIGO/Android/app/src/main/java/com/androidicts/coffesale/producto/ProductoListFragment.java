package com.androidicts.coffesale.producto;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.androidicts.coffesale.BaseFragment;
import com.androidicts.coffesale.R;
import com.androidicts.coffesale.di.componente.ProductoComponente;
import java.util.List;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoListFragment extends BaseFragment implements ProductoListView {

  @Inject ProductoListPresenter productoListPresenter;
  @Inject ProductosAdapter productosAdapter;

  @BindView(R.id.btn_retry) Button btnRetry;
  @BindView(R.id.rv_productos) RecyclerView rvProductos;
  @BindView(R.id.fl_progress) FrameLayout flProgress;
  @BindView(R.id.fl_retry) FrameLayout flRetry;

  private ProductoListListener productoListListener;
  private Unbinder unbinder;

  public ProductoListFragment() {
    setRetainInstance(true);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if(context instanceof ProductoListListener) {
      productoListListener = (ProductoListListener) context;
    }
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(ProductoComponente.class).inject(this);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    final View view = inflater.inflate(R.layout.fragment_producto_list, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setRecyclerView();
    productoListPresenter.setProductoListView(this);
    if(savedInstanceState == null) {
      cargarProductoList();
    }
  }

  @Override public void onResume() {
    super.onResume();
    productoListPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    productoListPresenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    rvProductos.setAdapter(null);
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    productoListPresenter.destroy();
  }

  @Override public void onDetach() {
    super.onDetach();
    productoListListener = null;
  }

  @Override public void mostrarCargando() {
    flProgress.setVisibility(View.VISIBLE);
  }

  @Override public void ocultarCargando() {
    flProgress.setVisibility(View.INVISIBLE);
  }

  @Override public void mostrarReintentar() {
    flRetry.setVisibility(View.VISIBLE);
  }

  @Override public void ocultarReintentar() {
    flRetry.setVisibility(View.INVISIBLE);
  }

  @Override public void mostrarError(String mensaje) {
    mostrarToast(mensaje);
  }

  @Override public Context context() {
    return getActivity().getApplicationContext();
  }

  @Override public void mostrarListaProductos(List<ProductoModel> productoModels) {
    if(productoModels != null) {
      productosAdapter.setProductoModelList(productoModels);
    }
  }

  @Override public void verProducto(ProductoModel productoModel) {
    if(productoListListener != null) {
      productoListListener.onProductoClicked(productoModel);
    }
  }

  private void cargarProductoList() {
    productoListPresenter.inicializar();
  }

  private void setRecyclerView() {


    productosAdapter.setClickListener(clickListener);
    rvProductos.setLayoutManager(new GridLayoutManager(context(), 2));
    rvProductos.setAdapter(productosAdapter);
  }

  @OnClick(R.id.btn_retry) void onButtonRetryClick() {
    cargarProductoList();
  }

  @OnClick(R.id.btn_add_producto) void onButtonAddClick() {
    mostrarToast("Agregar Producto");
  }

  private ProductosAdapter.OnItemClickListener clickListener = new ProductosAdapter.OnItemClickListener() {
    @Override public void onProductoClicked(ProductoModel productoModel) {
      mostrarToast(productoModel.getNombre());
    }
  };

  interface ProductoListListener {
    void onProductoClicked(final ProductoModel productoModel);
  }
}
