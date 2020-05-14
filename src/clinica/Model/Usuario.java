package clinica.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_USUARIO;
	@Column
	private String USERNAME;
	@Column
	private String PASSWORD;
	@Column
	private boolean FL_ADM;
	@Column
	private boolean FL_DENTISTA;
	
	
	public int getID_USUARIO() {
		return ID_USUARIO;
	}
	public void setID_USUARIO(int iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public boolean isFL_ADM() {
		return FL_ADM;
	}
	public void setFL_ADM(boolean fL_ADM) {
		FL_ADM = fL_ADM;
	}
	public boolean isFL_DENTISTA() {
		return FL_DENTISTA;
	}
	public void setFL_DENTISTA(boolean fL_DENTISTA) {
		FL_DENTISTA = fL_DENTISTA;
	}
	public Date getDT_INCLUSAO() {
		return DT_INCLUSAO;
	}
	public void setDT_INCLUSAO(Date dT_INCLUSAO) {
		DT_INCLUSAO = dT_INCLUSAO;
	}
	@Column
	private Date DT_INCLUSAO;	
}
