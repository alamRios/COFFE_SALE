package com.androidicts.coffesale.venta;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.androidicts.coffesale.BaseFragment;
import com.androidicts.coffesale.R;
import com.androidicts.coffesale.di.componente.VentaComponente;
import java.util.List;
import javax.inject.Inject;

public class VentaListFragment extends BaseFragment implements VentaListView {

  @Inject VentaListPresenter ventaListPresenter;
  @Inject VentasAdapter ventasAdapter;

  @BindView(R.id.btn_retry) Button btnRetry;
  @BindView(R.id.rv_ventas) RecyclerView rvVentas;
  @BindView(R.id.fl_progress) FrameLayout flProgress;
  @BindView(R.id.fl_retry) FrameLayout flRetry;

  private VentaListListener ventaListListener;
  private Unbinder unbinder;

  public VentaListFragment() {
      setRetainInstance(true);
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if(context instanceof VentaListListener) {
      ventaListListener = (VentaListListener) context;
    }
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getComponent(VentaComponente.class).inject(this);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_venta_list, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setRecyclerView();
    ventaListPresenter.setView(this);
    if(savedInstanceState == null) {
      cargarVentaList();
    }
  }

  @Override public void onResume() {
    super.onResume();
    ventaListPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    ventaListPresenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    rvVentas.setAdapter(null);
    unbinder.unbind();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    ventaListPresenter.destroy();
  }

  @Override public void onDetach() {
    super.onDetach();
    ventaListListener = null;
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

  @Override public void mostrarListaVentas(List<VentaModel> ventaModelList) {
    if(ventaModelList != null) {
      ventasAdapter.setVentaModelList(ventaModelList);
    }
  }

  @Override public void verVenta(VentaModel ventaModel) {
    if(ventaListListener != null) {
      ventaListListener.onVentaClicked(ventaModel);
    }
  }

  private void cargarVentaList() {
    ventaListPresenter.inicializar();
  }

  private void setRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(context());
    DividerItemDecoration dividerItemDecoration =
        new DividerItemDecoration(context(), layoutManager.getOrientation());


    ventasAdapter.setClickListener(clickListener);
    rvVentas.addItemDecoration(dividerItemDecoration);
    rvVentas.setLayoutManager(layoutManager);
    rvVentas.setAdapter(ventasAdapter);
  }

  public interface VentaListListener {
    void onVentaClicked(final VentaModel ventaModel);
  }

  private VentasAdapter.OnItemClickListener clickListener = new VentasAdapter.OnItemClickListener() {
    @Override public void onVentaItemClicked(VentaModel ventaModel) {
      mostrarToast("Holi");
    }
  };
}
