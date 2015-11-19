package Server;

import java.awt.Color;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Deze class implementeert data-operaties voor de shape entiteit
 * 
 * @Author Jan Jaap
 */
public abstract class SquareDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("shape");
	
	/**
	 * Maak een nieuwe Rit aan en sla die op in de database
	 */
	public static Shape create(int x, int y, int w, int h, FillStyle fillStyle, Color color, String type){
		Square sqaure = new Square();
		
		sqaure.setType(type);
		sqaure.setColor(color);
		sqaure.setX(x);
		sqaure.setY(y);
		sqaure.setWidth(w);
		sqaure.setHeight(h);
		sqaure.setFillStyle(fillStyle);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist( sqaure );
		t.commit();
		em.close();
		
		return sqaure;
	}
	
	/**
	 * Verwijder een rit uit de database
	 */
	public static void remove(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Square square = em.find(Square.class, id);
		if(square != null){
			em.remove( square );
		}
		t.commit();
		em.close();
	}
	
	/**
	 * Haal een rit op a.d.h.v. zijn id
	 */
	public static Square find(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Square square = em.find(Square.class, id);
		t.commit();
		em.close();
		return square;
	}
	
	/**
	 * Haal alle ritten op uit de database
	 */
	public static List<Square> all(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Square> squares = em.createQuery("from square", Square.class).getResultList();
		t.commit();
		em.close();
		return squares;
	}
}
