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

import Server.Shape;

/**
 * This is a class for the square shape
 * 
 * @author Jan Jaap Zoutendijk
 */
@Entity
@DiscriminatorValue("Square")
public class Square extends Shape implements Serializable{
	/* ------------------------------------------------------------------------------------------------------
	 * The Constructors
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Square() {
		super();
		this.setType("Square");
	}

	
	
}
