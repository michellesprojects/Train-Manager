
public class TrainCar {

	private double length, weight;
	
	private ProductLoad load;

	
	public TrainCar(double length, double weight, ProductLoad load) {
		super();
		this.length = length;
		this.weight = weight;
		this.load = load;
	}
	
	public TrainCar() {}
	
	public double getLength() {
		return length;
	}

	public double getWeight() {
		return weight;
	}

	public ProductLoad getLoad() {
		return load;
	}

	public void setLoad(ProductLoad load) {
		this.load = load;
	}
	
	public boolean isEmpty() {
		return this.load == null;
	}

	@Override
	public String toString() {
		if(load == null)
			return "TrainCar [length=" + length + ", weight=" + weight +  "]";
		return "TrainCar [length=" + length + ", weight=" + weight + ", load=" + load.toString() + "]\n";
	}
	
	
	
	
}
