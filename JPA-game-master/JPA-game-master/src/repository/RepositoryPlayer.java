package repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.Player;


public class RepositoryPlayer {

	static EntityManager em = main.DatabaseHandle.getEntityManagerFactory();
	
	public static Player getPlayerByname(String value) {
		
		TypedQuery<Player> QueryOne = em.createQuery("Select p from Player p where nom =:nom",Player.class);
		QueryOne.setParameter("nom", value );

		return QueryOne.getSingleResult();
		
	}
	
	public static List <Joueur> getAllPlayers() {
		
		TypedQuery<Player> QueryOne = em.createQuery("Select p from Player p" ,Player.class);
	

		return QueryOne.getResultList();
		
	}
	public static List <Player> getPlayersByDatePartie(LocalDate date) {

//		
//		Select p FROM Player AS p JOIN Joueur_partie as jp ON jp.Joueur_id=j.id JOIN Partie as p ON jp.Partie_id=p.id where p.date =:date
		TypedQuery<Player> QueryOne = em.createQuery("SELECT DISTINCT p FROM Player p JOIN p.parties p JOIN p.players players WHERE p.date=:date ",Player.class);
	
		QueryOne.setParameter("date", date );
		return QueryOne.getResultList();
		
	}
//	Pour un joueur, afficher les informations de l’engin utilisé dans sa dernière partie
//	ainsi que son score et le niveau du jeu atteint ;
	public static  Player getPlayerLastPartieByPlayerId(int id) {

//		
//		Select p from Player as p JOIN Joueur_partie as jp ON jp.Joueur_id=j.id JOIN Partie as p ON jp.Partie_id=p.id where p.date =:date
		TypedQuery<Player> QueryOne = em.createQuery("SELECT p FROM Player p JOIN p.avatar a JOIN a.engins e JOIN p.parties p Where p.id=:id ORDER BY p.date ",Player.class);
		QueryOne.setMaxResults(1);
		QueryOne.setParameter("id", id );
		return QueryOne.getSingleResult();
		
	}
	
}
