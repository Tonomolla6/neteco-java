package modules.orders;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class date {
	private String dia;
	private String mes;
	private String anyo;
	private String fecha;

	public date(String dia, String mes, String anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
		this.fecha = dia + "/" + mes + "/" + anyo;
	}

	public static void resta_fecha(Calendar c, int mes_suma) {
		c.add(Calendar.MONTH, +mes_suma);
	}

	public static String formatearCalendar(Calendar c) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
		return df.format(c.getTime());
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "date [dia=" + dia + ", mes=" + mes + ", anyo=" + anyo + ", fecha=" + fecha + "]";
	}

}
