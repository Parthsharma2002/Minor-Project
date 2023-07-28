package in.co.omd.bean;

public class RequestMedBean extends BaseBean{

	private String ngoName;
	private String brandName;
	private String genericName;
	private long ngoId;
	private String deliveryAddress;
	private long quantity;
	private String senderContact;
	private String senderName;
	
	
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderContact() {
		return senderContact;
	}

	public void setSenderContact(String senderContact) {
		this.senderContact = senderContact;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public long getNgoId() {
		return ngoId;
	}

	public void setNgoId(long ngoId) {
		this.ngoId = ngoId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
