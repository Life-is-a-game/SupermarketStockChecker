/**
 * 
 */
package supermarketStockCheck;

/**
 * @author NathanClarke
 *
 */
public class Stock {
	
	private int id;
	private String name;
	private int initAm;
	private int updatedAm;
	private int refillAm;
	
	/**
	 * Constructs a Stock object with the following parameters
	 * @param id
	 * @param name
	 * @param initAm
	 * @param updatedAm
	 * @param refillAm
	 */
	
	public Stock(int id, String name, int initAm, int updatedAm, int refillAm) {
		super();
		this.id = id;
		this.name = name;
		this.initAm = initAm;
		this.updatedAm = updatedAm;
		this.refillAm = refillAm;
	}

	/**
	 * @return the updatedAm
	 */
	public int getUpdatedAm() {
		return updatedAm;
	}

	/**
	 * @param updatedAm the updatedAm to set
	 */
	public void setUpdatedAm(int updatedAm) {
		this.updatedAm = updatedAm;
	}

	/**
	 * @return the refillAm
	 */
	public int getRefillAm() {
		return refillAm;
	}

	/**
	 * @param refillAm the refillAm to set
	 */
	public void setRefillAm(int refillAm) {
		this.refillAm = refillAm;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the initAm
	 */
	public int getInitAm() {
		return initAm;
	}

}
