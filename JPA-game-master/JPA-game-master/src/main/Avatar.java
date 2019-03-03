package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table
@Entity
public class Avatar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50, nullable=false)
	private String nom;
	@Column(nullable=false)
	private int puissance;
	
	@OneToOne(optional = true)
	private Joueur joueur;
	
	public int getId() {
		return id;
	}
	
	@OneToMany(mappedBy="avatar")
	private List<Engin> engins = new ArrayList<>();
	
	public List<Engin> getEngins() {
		return engins;
	}
	public void setEngins(List<Engin> engins) {
		this.engins = engins;
	}

	public void addEngin(Engin engin) {
		this.engins.add(engin);
	}
	
	public void removeEngin(int id) {
		this.engins.remove(id);
	}
  
  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.palyer = palyer;
	}
	
	
}
