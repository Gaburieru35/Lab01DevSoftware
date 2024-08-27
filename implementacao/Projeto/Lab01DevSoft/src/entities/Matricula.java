package entities;

import java.util.Date;

public class Matricula {

	private Date data;
	private String status;
	private String tipo;

	public Matricula() {
	}

	private void notificarCobranca() {
	}

	private void encerrarMatricula() {
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
