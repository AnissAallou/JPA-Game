package main;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Engin {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column( nullable=false, length = 50)
	private String coulour;
	@Column( nullable=false)
	private int vitesse_max =0;
	
	@ManyToOne
	@JoinColumn(name="id_avatar", nullable = true )
	private Avatar avatar;
	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getVitesse_max() {
		return vitesse_max;
	}

	public void setVitesse_max(int vitesse_max) {
		this.vitesse_max = vitesse_max;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Engin [id=" + id + ", colour =" + colour + ", vitesse_max=" + vitesse_max ;
	}
	
}
