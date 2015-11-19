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
public abstract class ShapeDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("shape");
	
	/**
	 * Maak een nieuwe Rit aan en sla die op in de database
	 */
	public static Shape create(int x, int y, int w, int h, FillStyle fillStyle, Color color, String type){
		Shape shape;
		
		if (type.equalsIgnoreCase("Circle")){
			 shape = new Circle();
		}
		else shape = new Square();
		
		shape.setColor(color);
		shape.setX(x);
		shape.setY(y);
		shape.setWidth(w);
		shape.setHeight(h);
		shape.setFillStyle(fillStyle);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist( shape );
		t.commit();
		em.close();
		
		return shape;
	}
	
	/**
	 * Verwijder een rit uit de database
	 */
	public static void remove(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Shape shape = em.find(Shape.class, id);
		if(shape != null){
			em.remove( shape );
		}
		t.commit();
		em.close();
	}
	
	/**
	 * Haal een rit op a.d.h.v. zijn id
	 */
	public static Shape find(Long id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Shape shape = em.find(Shape.class, id);
		t.commit();
		em.close();
		return shape;
	}
	
	/**
	 * Haal alle ritten op uit de database
	 */
	public static List<Shape> all(){
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<Shape> ritten = em.createQuery("from Rit", Shape.class).getResultList();
		t.commit();
		em.close();
		return ritten;
	}
}
