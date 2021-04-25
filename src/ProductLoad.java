
public class ProductLoad {

	private String name;
	private double weight, value;
	private boolean isDangerous;
	
	public ProductLoad() { }
	
	
	public ProductLoad(String name, double weight, double value, boolean isDangerous) {
		super();
		this.name = name; 
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) throws ProductLoadException {
		
		if(weight < 0)
			throw new ProductLoadException("Illegal weight value");
		this.weight = weight;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) throws ProductLoadException {
		
		if(value < 0)
			throw new ProductLoadException("Illegal product load value");
		this.value = value;
	}
	public boolean isDangerous() {
		return isDangerous;
	}
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ProductLoad [name=" + name + ", weight=" + weight + ", value=" + value + ", isDangerous=" + isDangerous
				+ "]";
	}
	
	
	
	
}
