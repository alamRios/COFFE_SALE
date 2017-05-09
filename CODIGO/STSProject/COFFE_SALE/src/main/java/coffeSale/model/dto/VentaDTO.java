package coffeSale.model.dto;

import java.util.ArrayList;

public interface VentaDTO {
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos);
	public void registrarVenta(double montoTotal, ArrayList<ProductoDTO> productos, MembresiaClienteDTO membresia);
}
