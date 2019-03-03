package main;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column( nullable=false)
	private int niveau =0;
	@Column( nullable=false)
	private int score =0;
	@Column(name = "dateNaissance")
	private LocalDate dateNaissance;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDatedeNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString() {
		return "Game : id  = "  + id 
				+ ", niveau = " + niveau
			        + ", score = " + score 
				+ ", date de naissance = " + dateNaissance;
	}
	
	
	
	
	
}
