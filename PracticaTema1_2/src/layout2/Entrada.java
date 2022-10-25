package layout2;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se emplear� para el modelo de datos del TableView
 * 
 * @author SBF
 * 
 */
public class Entrada {
	private final SimpleStringProperty sspNombre;
	private final SimpleStringProperty sspApellido;
	private final SimpleStringProperty sspFechaCompra;
	private final SimpleStringProperty sspFechaEntrada;
	private final SimpleIntegerProperty sipNumEntradasAdulto;
	private final SimpleIntegerProperty sipNumEntradasInfantil;
	private final SimpleIntegerProperty sipDescuento;
	private final SimpleDoubleProperty sdpPrecioTotal;
	private final SimpleStringProperty sspFormaDePago;

	public Entrada(String sspNombre, String sspApellido, String sspFechaCompra, String sspFechaEntrada,
			Integer sipNumEntradasAdulto, Integer sipNumEntradasInfantil, Integer sipDescuento, Double sdpPrecioTotal,
			String sspFormaDePago) {
		this.sspNombre = new SimpleStringProperty(sspNombre);
		this.sspApellido = new SimpleStringProperty(sspApellido);
		this.sspFechaCompra = new SimpleStringProperty(sspFechaCompra);
		this.sspFechaEntrada = new SimpleStringProperty(sspFechaEntrada);
		this.sipNumEntradasAdulto = new SimpleIntegerProperty(sipNumEntradasAdulto);
		this.sipNumEntradasInfantil = new SimpleIntegerProperty(sipNumEntradasInfantil);
		this.sipDescuento = new SimpleIntegerProperty(sipDescuento);
		this.sdpPrecioTotal = new SimpleDoubleProperty(sdpPrecioTotal);
		this.sspFormaDePago = new SimpleStringProperty(sspFormaDePago);
	}

	public String getSspNombre() {
		return sspNombre.get();
	}

	public void setSspNombre(String sNombre) {
		sspNombre.set(sNombre);
	}

	public String getSspApellido() {
		return sspApellido.get();
	}

	public void setSspApellido(String sApellido) {
		sspApellido.set(sApellido);
	}

	public String getSspFechaCompra() {
		return sspFechaCompra.get();
	}

	public void setSspFechaCompra(String sFechaCompra) {
		sspFechaCompra.set(sFechaCompra);
	}

	public String getSspFechaEntrada() {
		return sspFechaEntrada.get();
	}

	public void setSspFechaEntrada(String sFechaEntrada) {
		sspFechaEntrada.set(sFechaEntrada);
	}

	public Integer getSipNumEntradasAdulto() {
		return sipNumEntradasAdulto.get();
	}

	public void setSipNumEntradasAdulto(Integer iNumEntradasAdulto) {
		sipNumEntradasAdulto.set(iNumEntradasAdulto);
	}

	public Integer getSipNumEntradasInfantil() {
		return sipNumEntradasInfantil.get();
	}

	public void setSipNumEntradasInfantil(Integer iNumEntradasInfantil) {
		sipNumEntradasInfantil.set(iNumEntradasInfantil);
	}

	public Integer getSipDescuento() {
		return sipDescuento.get();
	}

	public void setSipDescuento(Integer iDescuento) {
		sipDescuento.set(iDescuento);
	}

	public Double getSdpPrecioTotal() {
		return sdpPrecioTotal.get();
	}

	public void setSdpPrecioTotal(Double dPrecioTotal) {
		sdpPrecioTotal.set(dPrecioTotal);
	}
	public String getSspFormaDePago() {
		return sspFormaDePago.get();
	}
	public void setSspFormaDePago(String sFormaDePago) {
		sspFormaDePago.set(sFormaDePago);
	}
}