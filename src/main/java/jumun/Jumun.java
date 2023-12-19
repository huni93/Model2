package jumun;

public class Jumun {

	private String jno;
    private String jname;
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
	@Override
	public String toString() {
		return "jumunList [jno=" + jno + ", jname=" + jname + "]";
	}
    
}
