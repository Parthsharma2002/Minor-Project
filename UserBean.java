package in.co.omd.bean;

import java.util.Date;

public class UserBean extends BaseBean{
   
	
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String confirmPassword;
	private String mobileNo;
	private long   roleId;
	private String gender;
	private String uniqueId;
	private String roleName;
	private String status;
	private NGOBean ngoBean;
	private String ngoName;
	
	
	
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
	}
	public NGOBean getNgoBean() {
		return ngoBean;
	}
	public void setNgoBean(NGOBean ngoBean) {
		this.ngoBean = ngoBean;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String idProof) {
		this.uniqueId = idProof;
	}
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
	
	
	
	
}
