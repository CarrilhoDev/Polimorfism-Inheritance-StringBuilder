package polimorfismAndInheritanceExerciseEntities;


public class ImportedProduct extends Product {

	private double customsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	public double totalPrice() {
		return getPrice() + this.customsFee;
	}
	
	
	@Override
	public String priceTag() {
		 
		 StringBuilder sb = new StringBuilder();
			sb.append(getName());
			sb.append(" $");
			sb.append(String.format("%.2f", totalPrice()));
			sb.append(" (Customs fee: $");
			sb.append(String.format("%.2f", getCustomsFee()));
			sb.append(")");
			
			return sb.toString();
		 
		 
	}

}
