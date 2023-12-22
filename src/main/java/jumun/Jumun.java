package jumun;

public class Jumun {

	private String jno;
    private String jname;
    private int price;
	
    
    public String getJno() {
		return jno;
	}
	public void setJno(String jno) {
		this.jno = jno;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Jumun [jno=" + jno + ", jname=" + jname + ", price=" + price + "]";
	}

}
