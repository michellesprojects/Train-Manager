import java.util.Scanner;

public class TrainManager {

	
	public static void main(String []args) {
		
		TrainLinkedList train = new TrainLinkedList();
		
		boolean runProgram = true;
		
		Scanner input = new Scanner(System.in);
		
		while(runProgram) {
			
			System.out.println("Menu");
            System.out.println("F - Move Cursor Forward");
            System.out.println("B - Move Cursor Backward");
            System.out.println("I - Insert car after Cursor");
            System.out.println("R - Remove Car at Cursor");
            System.out.println("L - Set Load at Cursor");
            System.out.println("S - Search for Product");
            System.out.println("T - Print Train");
            System.out.println("M - Print Manifest");
            System.out.println("D - Remove Dangerous Cars");
            System.out.println("Q - Quit the program");
            System.out.print("\n Enter a selection:");
            
            String selection = input.next();
            
            selection = selection.toUpperCase();
            
            switch(selection) {
            
            case("F"):
            	train.cursorForward();
            	break;
            case("B"):
            	train.cursorBackward();
            	break;
            /*
             * I - Insert Car After Cursor <Length> <Weight>
			 * Inserts a new empty car after the cursor. If the cursor is null
			 * (i.e. the train is empty), the car is set as the head of the train. 
			 * After insertion, the cursor is set to the newly inserted car.
             */
            case("I"):
            	
            	System.out.print("Enter the length of the car: ");
            	double length = input.nextDouble();
            	System.out.print("Enter the weight of the car: ");
                double weight = input.nextDouble();
            	
            	TrainCar newCar = new TrainCar(length,weight,null);
            	
            	train.insertAfterCursor(newCar);
            	break;
            
            case("R"):
            	
            	train.removeCursor();
            	break;
            
            case("L"):
            	input.nextLine();
            	System.out.println("Enter product load name: ");
            	String name = input.nextLine();
            	System.out.println("Enter the product load weight: ");
            	double w = input.nextDouble();
            	System.out.println("Enter the product load value($): ");
            	double val = input.nextDouble();
            	System.out.println("Is the load dangerous Y/N?: ");
            	boolean isD = input.next().toUpperCase().contains("Y")? true: false;
            	ProductLoad load = new ProductLoad(name,w,val, isD);
            	
            	train.getCursor().getCar().setLoad(load);
            	
            	break;
            
            case("S"):
            	
            	input.nextLine();
            	System.out.println("Enter product name to search: ");
            	
            	
            	train.findProduct(input.nextLine());
            	
            	break;
            
            case("T"):
            	
            	System.out.println(train.toString());
            	break;
            
            case("M"):
            	train.printManifest();
            	break;
            	
            case("D"):
            	train.removeDangerousCars();
            	break;
            
            case("Q"):
            	System.out.println("Quiting program");
            	runProgram = false;
            	break;
            	
            default:
            	System.out.println("Menu option does not exist");
            	
            }
            
            
		}
		
	}
}
