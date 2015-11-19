package Server;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@DiscriminatorValue("Circle")
public class Circle extends Shape implements Serializable{

	/* ------------------------------------------------------------------------------------------------------
	 * The Constructors
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Circle() {
		super();
		this.setType("Circle");
	}

}
