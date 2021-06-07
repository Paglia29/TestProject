package entity;

import java.time.LocalDate; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="automobile")
public class Automobile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String marca, modello;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_immatricolazione")
	private LocalDate dataImmatricolazione;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona proprietario;
	
	public Automobile() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public LocalDate getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(LocalDate dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}

	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + marca + ", modello=" + modello + ", dataImmatricolazione="
				+ dataImmatricolazione + "]";
	}
	
}
