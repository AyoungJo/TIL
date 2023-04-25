package sample05;

public class OrderMessageImpl implements OrderMessage {
	private int orderId; //value
	private String message;//value
	
	private UserBean userBean;//ref
	private ProductBean proudctBean;//ref
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		System.out.println("setOrderId....");
		this.orderId = orderId;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("setMessage......");
		this.message = message;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		System.out.println("setUserBean....");
		this.userBean = userBean;
	}
	public ProductBean getProudctBean() {
		return proudctBean;
	}

	public void setProudctBean(ProductBean proudctBean) {
		System.out.println("setProductBean......");
		this.proudctBean = proudctBean;
	}

	
	@Override
	public void getOrderMessage() {
        System.out.println("orderId : " + orderId);
        
        System.out.println("name : " + userBean.getName());
        System.out.println("phone : " + userBean.getPhone());
        
        System.out.println("상품명 : " + proudctBean.getPname());
        System.out.println("상품가격 : " + proudctBean.getPrice());  
        
        System.out.println("메시지 : " + message);
		
	}
	
}
