package dk.itu.ws.pizzeria.model;

public abstract class Pizza {
	
	private Long id;
	private String name;
	private String description;
	private double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Validate all the field of the current entity
	 * @return true if valid
	 */
	public abstract boolean validate();
	/**
	 * Get specific error messages for each field from the last validation
	 * 
	 * @param s
	 * @return
	 */
	public abstract String getErrorMsg(String s);	

}
