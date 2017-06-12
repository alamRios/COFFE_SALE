package com.androidicts.coffesale;

import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.androidicts.coffesale.di.HasComponent;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

public class BaseFragment extends Fragment {

  protected void mostrarToast(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
