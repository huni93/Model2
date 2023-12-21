package jumun;

public class Cart {

	private String ser;
    private String userid;
    private String itemid;
    private String qty;
    private String jname;
    private int price;
	public String getSer() {
		return ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
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
		return "Cart [ser=" + ser + ", userid=" + userid + ", itemid=" + itemid + ", qty=" + qty + ", jname=" + jname
				+ ", price=" + price + "]";
	}
    
}
