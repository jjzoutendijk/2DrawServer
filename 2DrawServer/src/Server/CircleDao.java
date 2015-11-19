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
public abstract class CircleDao {
	private static EntityManagerFactory emf;
	
	private static EntityManagerFactory getFactory(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("shape");
		}
		return emf;
	}
	
	/**
	 * Maak een nieuwe Rit aan en sla die op in de database
	 */
	public static Shape create(int x, int y, int w, int h, FillStyle fillStyle, Color color, String type){
		Circle circle = new Circle();
		
		circle.setType(type);
		circle.setColor(color);
		circle.setX(x);
		circle.setY(y);
		circle.setWidth(w);
		circle.setHeight(h);
		circle.setFillStyle(fillStyle);
		
		EntityManager em = getFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist( circle );
		t.commit();
		em.close();
		
		return circle;
	}
	
	/**
	 * Verwijder een rit uit de database
	 */
	public static void remove(Long id){
		EntityManager em = getFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Circle circle = em.find(Circle.class, id);
		if(circle != null){
			em.remove( circle );
		}
		t.commit();
		em.close();
	}
	
	/**
	 * Haal een rit op a.d.h.v. zijn id
	 */
	public static Shape find(Long id){
		EntityManager em = getFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Circle shape = em.find(Circle.class, id);
		t.commit();
		em.close();
		return shape;
	}
	
	/**
	 * Haal alle ritten op uit de database
	 */
	public static List<Circle> all(){
		EntityManager em = getFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Circle> ritten = em.createQuery("from circle", Circle.class).getResultList();
		t.commit();
		em.close();
		return ritten;
	}
}
