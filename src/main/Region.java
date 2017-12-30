package main;

import java.util.ArrayList;
import java.util.List;
/**
 * POJO for Region
 * @author Siddhant
 *
 */
public class Region {

	int id;
	String color= "";
	List<Integer>neighbors= new ArrayList<>();
	boolean isColored = false;
	int numberOfPossibleColors;
	List<String>permissibleColors = new ArrayList<>();
	boolean isChecked=false;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<Integer> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(int id, List<Integer> neighbors) {
		this.neighbors = neighbors;
	}
	public Region(int id) {
		super();
		this.id = id;
	}
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isColored() {
		return isColored;
	}
	public void setColored(boolean isColored) {
		this.isColored = isColored;
	}
	public int getNumberOfPossibleColors() {
		return numberOfPossibleColors;
	}
	public void setNumberOfPossibleColors(int numberOfPossibleColors) {
		this.numberOfPossibleColors = numberOfPossibleColors;
	}
	public List<String> getPermissibleColors() {
		return permissibleColors;
	}
	public void setPermissibleColors(List<String> permissibleColors) {
		this.permissibleColors = permissibleColors;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
	
	
}
