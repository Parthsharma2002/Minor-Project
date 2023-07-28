package in.co.omd.bean;

import java.sql.Blob;
import java.util.Date;



public class DonateMedicineBean extends BaseBean {

	private String medicineBrand;
	private String medicineGeneric;
	private Date medicineManufacturerDate;
	private Date medicineExpiryDate;
	private Blob medicinePacket;
	private long quantity;
	private long userid;
	private String ngoName;
	private String donarName;
	private long ngoId;
	
	
	
	public long getNgoId() {
		return ngoId;
	}

	public void setNgoId(long ngoId) {
		this.ngoId = ngoId;
	}

	public String getDonarName() {
		return donarName;
	}

	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}

	public String getMedicineBrand() {
		return medicineBrand;
	}

	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}

	public String getMedicineGeneric() {
		return medicineGeneric;
	}

	public void setMedicineGeneric(String medicineGeneric) {
		this.medicineGeneric = medicineGeneric;
	}

	public Date getMedicineManufacturerDate() {
		return medicineManufacturerDate;
	}

	public void setMedicineManufacturerDate(Date medicineManufacturerDate) {
		this.medicineManufacturerDate = medicineManufacturerDate;
	}

	public Date getMedicineExpiryDate() {
		return medicineExpiryDate;
	}

	public void setMedicineExpiryDate(Date medicineExpiryDate) {
		this.medicineExpiryDate = medicineExpiryDate;
	}

	public Blob getMedicinePacket() {
		return medicinePacket;
	}

	public void setMedicinePacket(Blob medicinePacket) {
		this.medicinePacket = medicinePacket;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getNgoName() {
		return ngoName;
	}

	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
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
