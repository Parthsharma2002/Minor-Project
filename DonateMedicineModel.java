
package in.co.omd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.omd.bean.DonateMedicineBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DatabaseException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.exception.RecordNotFoundException;
import in.co.omd.util.JDBCDataSource;







public class DonateMedicineModel {
	private static Logger log = Logger.getLogger(DonateMedicineModel.class);
	

	public Integer nextPK() throws DatabaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM DONATEMEDICINE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk + 1;
	}

	/**
	 * Add a User
	 * 
	 * @param bean
	 * @throws DatabaseException
	 * 
	 */
	public long add(DonateMedicineBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;
		//System.out.println("bean ===> "+bean.getFirstName()+bean.getLastName()+bean.getMobileNo()+bean.getLogin()+bean.getPassword()+bean.getGender());
		

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			System.out.println("error----");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DONATEMEDICINE VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getMedicineBrand());
			pstmt.setString(3, bean.getMedicineGeneric());
			pstmt.setDate(4, new java.sql.Date(bean.getMedicineManufacturerDate().getTime()));
			pstmt.setDate(5, new java.sql.Date(bean.getMedicineExpiryDate().getTime()));
			pstmt.setLong(6, bean.getQuantity());
			pstmt.setLong(7, bean.getUserid() );
			pstmt.setLong(8, bean.getNgoId());
			pstmt.setBlob(9, bean.getMedicinePacket());
            pstmt.setString(10, bean.getCreatedBy());		
            pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());						
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			
			
			
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
		
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add User"+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk;
	}

	/**
	 * Delete a User
	 * 
	 * @param bean
	 * @throws DatabaseException
	 */
	public void delete(UserBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM DONATEMEDICINE WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();

		} catch (Exception e) {
		
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}
	
	/*
	 * ACCEPT user
	 */
public void accept(UserBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE DONATEMEDICINE SET STATUS = '"+1+"' WHERE ID = ? ");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();

		} catch (Exception e) {
		
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}
	/**
	 * Find User by Login
	 * 
	 * @param login
	 *            : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */

	public UserBean findByLogin(String login) throws ApplicationException {
		log.debug("Model findByLogin Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM DONATEMEDICINE WHERE LOGINID=?");
		UserBean bean = null;
		Connection conn = null;
		System.out.println("sql" + sql);

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setRoleId(rs.getLong(6));
				bean.setRoleName(rs.getString(7));
				bean.setMobileNo(rs.getString(8));				
				bean.setGender(rs.getString(9));
				bean.setUniqueId(rs.getString(10));	
				bean.setCreatedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedBy(rs.getString(13));				
				bean.setModifiedDatetime(rs.getTimestamp(14));
				bean.setStatus(rs.getString(15));				

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByLogin End");
		return bean;
	}

	/**
	 * Find User by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */

	public UserBean findByPK(long pk) throws ApplicationException {
		log.debug("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM DONATEMEDICINE WHERE ID=?");
		UserBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setRoleId(rs.getLong(6));
				bean.setRoleName(rs.getString(7));
				bean.setMobileNo(rs.getString(8));				
				bean.setGender(rs.getString(9));
				bean.setUniqueId(rs.getString(10));	
				bean.setCreatedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedBy(rs.getString(13));				
				bean.setModifiedDatetime(rs.getTimestamp(14));
				bean.setStatus(rs.getString(15));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByPK End");
		return bean;
	}

	/**
	 * Update a user
	 * 
	 * @param bean
	 * @throws DatabaseException
	 */

	public void update(UserBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

		UserBean beanExist = findByLogin(bean.getLogin());
		// Check if updated LoginId already exist
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("LoginId is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE USER SET FIRSTNAME=?,LASTNAME=?,LOGIN=?,PASSWORD=?,DOB=?,MOBILENO=?,ROLEID=?,"
					+ "GENDER=?,UNIQUEId=?,"
					+ "CREATEDBY=?,MODIFIEDBY=?,CREATEDDATETIME=?,MODIFIEDDATETIME=?,STATUS=? WHERE ID=?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setLong(5, bean.getRoleId());
			pstmt.setString(6, bean.getRoleName() );
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setString(8,bean.getGender());
			pstmt.setString(9, bean.getUniqueId());		
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setString(12, bean.getModifiedBy());			
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.setString(14, bean.getStatus());
			pstmt.setLong(15, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	/**
	 * Search User
	 * 
	 * @param bean
	 *            : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(DonateMedicineBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/**
	 * Search User with pagination
	 * 
	 * @return list : List of Users
	 * @param bean
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 * @throws DatabaseException
	 */

	public List search(DonateMedicineBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model search Started");
		//StringBuffer sql = new StringBuffer("SELECT * FROM USER WHERE 1=1");
		StringBuffer sql = new StringBuffer("select * from donatemedicine inner join user on donatemedicine.userid = user.id where 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getMedicineBrand() != null && bean.getMedicineBrand().length() > 0) {
				sql.append(" AND MEDICINEBRAND like '" + bean.getMedicineBrand() + "%'");
			}
			if (bean.getMedicineGeneric() != null && bean.getMedicineGeneric().length() > 0) {
				sql.append(" AND MEDICINEGENERIC like '" + bean.getMedicineGeneric() + "%'");
			}
			

		}

		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
			// sql.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println("user model search  :"+sql);
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DonateMedicineBean();
				bean.setId(rs.getLong(1));
				bean.setMedicineBrand(rs.getString(2));
				bean.setMedicineGeneric(rs.getString(3));
				bean.setMedicineManufacturerDate(rs.getDate(4));
				bean.setMedicineExpiryDate(rs.getDate(5));
				bean.setQuantity(rs.getLong(6));
				bean.setUserid(rs.getLong(7));
				bean.setNgoId(rs.getLong(8));
				bean.setMedicinePacket(rs.getBlob(9));				
				bean.setCreatedBy(rs.getString(10));
				bean.setModifiedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));								
				bean.setModifiedDatetime(rs.getTimestamp(13));
				bean.setDonarName(rs.getString(15)+" "+rs.getString(16));	
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in search user"+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model search End");
		return list;
	}

	/**
	 * Get List of User
	 * 
	 * @return list : List of User
	 * @throws DatabaseException
	 */

	public List list() throws ApplicationException {
		return list(0, 0);
	}

	/**
	 * Get List of User with pagination
	 * 
	 * @return list : List of users
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */

	public List list(int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from USER");
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		
		System.out.println("sql in list user :"+sql);
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setRoleId(rs.getLong(6));
				bean.setRoleName(rs.getString(7));
				bean.setMobileNo(rs.getString(8));				
				bean.setGender(rs.getString(9));
				bean.setUniqueId(rs.getString(10));	
				bean.setCreatedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedBy(rs.getString(13));				
				bean.setModifiedDatetime(rs.getTimestamp(14));
				bean.setStatus(rs.getString(15));	
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of users");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model list End");
		return list;

	}

	/**
	 * @param id
	 *            : long id
	 * @param old
	 *            password : String oldPassword
	 * @param new
	 *            password : String newPassword
	 * @throws DatabaseException
	 */

	public UserBean authenticate(String login, String password) throws ApplicationException {
		log.debug("Model authenticate Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM USER WHERE LOGINID = ? AND PASSWORD = ?");
		UserBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setRoleId(rs.getLong(6));
				bean.setRoleName(rs.getString(7));
				bean.setMobileNo(rs.getString(8));				
				bean.setGender(rs.getString(9));
				bean.setUniqueId(rs.getString(10));	
				bean.setCreatedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedBy(rs.getString(13));				
				bean.setModifiedDatetime(rs.getTimestamp(14));
				bean.setStatus(rs.getString(15));	
				System.out.println("Usermodel here");
			}
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in get roles"+e.getMessage());

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model authenticate End");
		return bean;
	}

	

	/**
	 * Get User Roles
	 * 
	 * @return List : User Role List
	 * @param bean
	 * @throws ApplicationException
	 */

	public List getRoles(UserBean bean) throws ApplicationException {
		log.debug("Model get roles Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM USER WHERE roleId=?");
		Connection conn = null;
		List list = new ArrayList();
		try {

			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, bean.getRoleId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setRoleId(rs.getLong(6));
				bean.setRoleName(rs.getString(7));
				bean.setMobileNo(rs.getString(8));				
				bean.setGender(rs.getString(9));
				bean.setUniqueId(rs.getString(10));	
				bean.setCreatedBy(rs.getString(11));
				bean.setCreatedDatetime(rs.getTimestamp(12));
				bean.setModifiedBy(rs.getString(13));				
				bean.setModifiedDatetime(rs.getTimestamp(14));
				bean.setStatus(rs.getString(15));	
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in get roles");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model get roles End");
		return list;
	}

	/**
	 * @param id
	 *            : long id
	 * @param old
	 *            password : String oldPassword
	 * @param newpassword
	 *            : String newPassword
	 * @throws org.omg.CORBA.portable.ApplicationException
	 * @throws DatabaseException
	 */

		public boolean changePassword(Long id, String oldPassword, String newPassword)
				throws RecordNotFoundException, ApplicationException {

			log.debug("model changePassword Started");
			
			boolean flag = false;
			
			UserBean beanExist = null;

			beanExist = findByPK(id);
			
			if (beanExist != null && beanExist.getPassword().equals(oldPassword)) {
				beanExist.setPassword(newPassword);
				try {
					update(beanExist);
				} catch (DuplicateRecordException e) {
					log.error(e);
					throw new ApplicationException("LoginId is already exist");
				}
				flag = true;
			} else {
				throw new RecordNotFoundException("Old password is Invalid");
			}

			

			

			log.debug("Model changePassword End");
			return flag;

		}

	

	/**
	 * Register a user
	 * 
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when user already exists
	 * @throws org.omg.CORBA.portable.ApplicationException
	 */

	public long registerUser(DonateMedicineBean bean)
			throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");

		long pk = add(bean);

		
		return pk;
	}

	/**
	 * Reset Password of User with auto generated Password
	 * 
	 * @return boolean : true if success otherwise false
	 * @param login
	 *            : User Login
	 * @throws ApplicationException
	 * @throws org.omg.CORBA.portable.ApplicationException
	 * @throws RecordNotFoundException
	 *             : if user not found
	 */

	/*public boolean resetPassword(UserBean bean)
			throws ApplicationException, org.omg.CORBA.portable.ApplicationException {

		String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
		UserBean userData = findByPK(bean.getId());
		userData.setPassword(newPassword);

		try {
			update(userData);
		} catch (DuplicateRecordException e) {
			return false;
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", bean.getLogin());
		map.put("password", bean.getPassword());
		map.put("firstName", bean.getFirstName());
		map.put("lastName", bean.getLastName());

		String message = EmailBuilder.getForgetPasswordMessage(map);

		EmailMessage msg = new EmailMessage();

		msg.setTo(bean.getLogin());
		msg.setSubject("Password has been reset");
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		return true;
	}*/

	/**
	 * Send the password of User to his Email
	 * 
	 * @return boolean : true if success otherwise false
	 * @param login
	 *            : User Login
	 * @throws ApplicationException
	 * @throws RecordNotFoundException
	 *             : if user not found
	 * 
	 */

	public boolean forgetPassword(String login)
			throws ApplicationException, RecordNotFoundException, ApplicationException {
		UserBean userData = findByLogin(login);
		
		boolean flag = false;

		if (userData == null) {
			throw new RecordNotFoundException("Email ID does not exists !");

		}

		
		flag = true;

		return flag;
	}
}
