package jumun;

public class cart {

	private String ser;
    private String userid;
    private String itemid;
    private String qty;
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
	@Override
	public String toString() {
		return "cart [ser=" + ser + ", userid=" + userid + ", itemid=" + itemid + ", qty=" + qty + "]";
	}
    
}
