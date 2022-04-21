package Q30;

public class Stocks {
	float stockRate;

	public Stocks(float stockRate) {
		super();
		this.stockRate = stockRate;
	}
	public String checkRate(float Rate) throws Exception{
		float tot=Rate*100/stockRate;
		
		if(tot==80.0f) {
			return "Hope to raise";
		}else if(tot<80.0f) {
			throw new StockLowException("Under loss");
		}else {
			throw new StockHighException("Under profit");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stocks stock = new Stocks(10.0f);
		
		try {
			System.out.println(stock.checkRate(5.0f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
