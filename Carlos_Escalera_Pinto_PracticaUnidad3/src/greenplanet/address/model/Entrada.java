package greenplanet.address.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * 
 * Clase auxiliar que se emplear� para el modelo de datos del TableView
 * 
 * @author CJEP DAM 2
 * 
 */
public class Entrada {
	private static final int PRECIO_ADULTOS = 25;
	private static final int PRECIO_NIÑOS = 13;
	private final SimpleStringProperty sspNombre;
	private final SimpleStringProperty sspApellido;
	private final ObjectProperty<LocalDate> sspFechaCompra;
	private final ObjectProperty<LocalDate> sspFechaEntrada;
	private final SimpleIntegerProperty sipNumEntradasAdulto;
	private final SimpleIntegerProperty sipNumEntradasInfantil;
	private final SimpleIntegerProperty sipDescuento;
	private final SimpleDoubleProperty sdpPrecioTotal;
	private final SimpleStringProperty sspFormaDePago;

	public Entrada(String sspNombre, String sspApellido, SimpleObjectProperty<LocalDate> sspFechaCompra, SimpleObjectProperty<LocalDate> sspFechaEntrada,
			Integer sipNumEntradasAdulto, Integer sipNumEntradasInfantil, Integer sipDescuento, Double sdpPrecioTotal,
			String sspFormaDePago) {
		this.sspNombre = new SimpleStringProperty(sspNombre);
		this.sspApellido = new SimpleStringProperty(sspApellido);
		this.sspFechaCompra =  new SimpleObjectProperty<LocalDate>(LocalDate.now());
		this.sspFechaEntrada = new SimpleObjectProperty<LocalDate>(sspFechaEntrada.get());
		this.sipNumEntradasAdulto = new SimpleIntegerProperty(sipNumEntradasAdulto);
		this.sipNumEntradasInfantil = new SimpleIntegerProperty(sipNumEntradasInfantil);
		this.sipDescuento = new SimpleIntegerProperty(sipDescuento);
		this.sdpPrecioTotal = new SimpleDoubleProperty(sdpPrecioTotal);
		this.sspFormaDePago = new SimpleStringProperty(sspFormaDePago);
	}
	

	public Entrada() {
		this.sspNombre = new SimpleStringProperty();
		this.sspApellido = new SimpleStringProperty();
		this.sspFechaCompra = new SimpleObjectProperty<LocalDate>(LocalDate.now());
		this.sspFechaEntrada = new SimpleObjectProperty<LocalDate>();
		this.sipNumEntradasAdulto = new SimpleIntegerProperty();
		this.sipNumEntradasInfantil = new SimpleIntegerProperty();
		this.sipDescuento = new SimpleIntegerProperty();
		this.sdpPrecioTotal = new SimpleDoubleProperty();
		this.sspFormaDePago = new SimpleStringProperty();

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

	public LocalDate getSspFechaCompra() {
		return sspFechaCompra.get();
	}

	public void setSspFechaCompra(LocalDate sFechaCompra) {
		sspFechaCompra.set(sFechaCompra);
	}

	public LocalDate getSspFechaEntrada() {
		return sspFechaEntrada.get();
	}

	public void setSspFechaEntrada(LocalDate sFechaEntrada) {
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
	public void calcularTotal(int adultos, int niños) {
		double total = (double)(adultos*PRECIO_ADULTOS)+(niños*PRECIO_NIÑOS);
		setSdpPrecioTotal(total);
	}
}