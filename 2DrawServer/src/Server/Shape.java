package Server;

import java.awt.Color;
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


/**
 * This is an abstract superclass of the drawing shapes program
 * 
 * @author Jan Jaap Zoutendijk
 * @version 1.0
 * 
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="field",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("dummy")
public abstract class Shape implements Serializable {
	/* ------------------------------------------------------------------------------------------------------
	 * Class Variables
	 * ------------------------------------------------------------------------------------------------------
	 */
	private int x,y;
	private Color color;
	private FillStyle fillStyle;
	private String type;
	private int height;
	private int width;
	private Long id;
	


	/* ------------------------------------------------------------------------------------------------------
	 * The Constructors
	 * ------------------------------------------------------------------------------------------------------
	 */
	public Shape(){
		this.x = 10;
		this.y = 10;
		
		// Set the standard style, color and size
		fillStyle = FillStyle.EMPTY;
		color = Color.BLACK;
		height = 50;
		width = 50;
	}
	
	
	/* ------------------------------------------------------------------------------------------------------
	 * Getters and setters
	 * ------------------------------------------------------------------------------------------------------
	 */

	
	public void setId(Long id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public FillStyle getFillStyle() {
		return fillStyle;
	}
	public void setFillStyle(FillStyle fillStyle) {
		this.fillStyle = fillStyle;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
	
	/* ------------------------------------------------------------------------------------------------------
	 * Class Methods
	 * ------------------------------------------------------------------------------------------------------
	 */

	
	public String printShape(){
		return new String("x: " + this.x + "y: " + this.y + "style: " + this.fillStyle); 
	}
	
	public void increaseWidth(){
		this.width += 2;
	}
	
	public void increaseHeight(){
		this.height += 2;
	}

	public void decreaseWidth(){
		if (this.width > 10){
			this.width -= 2;
		}
	}
	public void decreaseHeight(){
		if (this.height > 10){
			this.height -= 2;
		}
	}
	
	public String toString(){
		return "This shape is a: " + this.getType() + " at: " + this.getX() + "," +this.getY()+ " Color & fill style: " + this.getColor() + " " + this.getFillStyle();
	}
	
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }
	
	
}
