
public class TrainLinkedList {

	private TrainCarNode head, tail, cursor;
	private int size;
	private double totalLength, totalValue, totalWeight;
	
	TrainLinkedList() {
		size = 0;
		totalLength = 0;
		totalValue = 0;
		totalWeight = 0;
		
	}

	public TrainCarNode getCursor() {
		return cursor;
	}

	public void setCursor(TrainCarNode cursor) {
		this.cursor = cursor;
	}
	
	public TrainCar getCursorData() {
		
		return cursor.getCar();
	}
	
	public void setCursorData(TrainCar car) {
		
		this.cursor.setCar(car);
	}
	
	public void cursorForward() {
		
		
		if(cursor == tail) {
			System.out.println("Cursor at tail, cannot move forward");
			return;
		}
		
		if(cursor == null)
			return;
		
		
		this.cursor = this.cursor.getNext();
	}
	
	public void cursorBackward() {
		
		if(cursor == null)
			return;
		
		if(cursor == head) {
			System.out.println("Cursor at head, cannot move backward");
			return;
		}
		
		
		this.cursor = this.cursor.getPrev();
	}
	
	public void insertAfterCursor(TrainCar newCar) {
		
		TrainCarNode newCarNode = new TrainCarNode(newCar);
		
		if(cursor == null) {
			
			head = newCarNode;
			cursor = newCarNode;
			tail = newCarNode;
			
		} else {
			
			if(cursor.getNext() == null) {
				tail = newCarNode;
			} else {
				newCarNode.setNext(cursor.getNext());
			}
		
		newCarNode.setPrev(cursor);
		
		cursor.setNext(newCarNode);
		
		this.cursorForward();
		}
		
		
		this.totalLength += newCar.getLength();
		
		if(newCar.getLoad() != null) {
			this.totalWeight += newCar.getLoad().getWeight();
			this.totalValue += newCar.getLoad().getValue();
			
		}
		this.totalWeight += newCar.getWeight();
		
		this.size ++;
	}
	
	public TrainCar removeCursor() {
		
		
		this.size --;
		this.totalLength -= cursor.getCar().getLength();
		
		if(cursor.getCar().getLoad() != null) {
			
			this.totalWeight -= cursor.getCar().getLoad().getWeight();
			this.totalValue -= cursor.getCar().getLoad().getValue();
			
		}
		
		this.totalWeight -= cursor.getCar().getWeight();
		
		
		
		
		if(cursor == head) {
			
			if(cursor.getNext() != null) {
				
				head = cursor.getNext();
				cursor = head;
				return head.getCar();
				
			} else {
				
				cursor = null;
				head = null;
				tail = null;
				return null;
			}
		}
		
		//its the tail
		
		if(cursor.getNext() == null) {
			
			cursor.getPrev().setNext(null);
			tail = cursor.getPrev();
			
			cursor = tail;
			return tail.getCar();
		}
		
		cursor.getPrev().setNext(cursor.getNext());
		
		cursor.getNext().setPrev(cursor.getPrev());
		
		cursor = cursor.getNext();
		
		return cursor.getCar();
		
		
		
	}
	
	public boolean isDangerous() {
		
		TrainCarNode pointer = new TrainCarNode();
		pointer = head;
		
	//	this.setCursor(head);
	
		while(pointer != null) {
			if(pointer.getCar().getLoad().isDangerous())
				return true;
			
			pointer = pointer.getNext();
		}
		
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public double getLength() {
		return this.totalLength;
	}
	
	public double getValue() {
		return this.totalValue;
	}
	
	public double getWeight() {
		return this.totalWeight;
	}
	
	/*
	 * Searches the list for all ProductLoad objects with the indicated name 
	 * and sums together their weight and value (Also keeps track of whether 
	 * the product is dangerous or not), then prints a single ProductLoad record 
	 * to the console.
	 */
	public void findProduct(String name) {
		
		double localSumWeight = 0;
		double localSumValue = 0;
		boolean isDanger = false;
		
		
		TrainCarNode pointer = new TrainCarNode();
		pointer = head;
		
		while(pointer != null) {
			if(pointer.getCar().getLoad() != null) {
			if(pointer.getCar().getLoad().getName().equals(name)) {
				
				localSumWeight += pointer.getCar().getLoad().getWeight() + pointer.getCar().getWeight();
				localSumValue += pointer.getCar().getLoad().getValue();
				
				if(pointer.getCar().getLoad().isDangerous())
					isDanger = true;
			}
			}
			pointer = pointer.getNext();
		}
		
		if(localSumWeight == 0 && localSumValue == 0) {
			System.out.println("Product not found");
			return;
		}
			
		
		System.out.println(name+" total weight, value: "+localSumWeight+", "+localSumValue);
	
		
	}

	/*Prints a neatly formatted table of the car number, car length, car weight,
	 *  load name, load weight, load value, and load dangerousness for all of the car on the train.
	 */
	
	public void printManifest() {
		
		if(head == null)
			return;
		
		TrainCarNode pointer = new TrainCarNode(head.getCar());
		pointer.setNext(head.getNext());
		
		for(int i = 0; i<size(); i++){
			
			System.out.println(pointer.toString());
			
			pointer = pointer.getNext();
		}
		
		pointer = null;
	}

	/*
	 * Removes all dangerous cars from the train, maintaining the order of the cars in the train.
	 */
	public void removeDangerousCars() {
		
		TrainCarNode temp = cursor;
		
		
		this.setCursor(head);
		
		while(cursor != null) {
			
			if(cursor.getCar().getLoad().isDangerous())
				this.removeCursor();
			else
				this.cursorForward();
			
		}
		
		cursor = temp;
		
	}

	@Override
	public String toString() {
		return "TrainLinkedList [head=" + head + ", tail=" + tail + ", cursor=" + cursor + ", size=" + size
				+ ", totalLength=" + totalLength + ", totalValue=" + totalValue + ", totalWeight=" + totalWeight + "]";
	}
	
	
	
}
