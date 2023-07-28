
package in.co.omd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.omd.bean.RequestMedBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DatabaseException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.exception.RecordNotFoundException;
import in.co.omd.util.JDBCDataSource;







public class RequestMedModel {
	private static Logger log = Logger.getLogger(RequestMedModel.class);
	

	public Integer nextPK() throws DatabaseException {
		log.debug("Model nextPK Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM REQUESTMED");
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
	 * Add a REQUESTMED
	 * 
	 * @param bean
	 * @throws DatabaseException
	 * 
	 */
	public long add(RequestMedBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;
		//System.out.println("bean ===> "+bean.getFirstName()+bean.getLastName()+bean.getMobileNo()+bean.getLogin()+bean.getPassword()+bean.getGender());
//		RequestMedBean existbean = findByLogin(bean.getLogin());
//
//		if (existbean != null) {
//			throw new DuplicateRecordException("Login Id already exists");
//		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			// Get auto-generated next primary key
			System.out.println(pk + " in ModelJDBC");
			conn.setAutoCommit(false); // Begin transaction
			System.out.println("error----"+bean.getNgoId()+bean.getQuantity());
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO REQUESTMED VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getNgoName());
			pstmt.setString(3, bean.getBrandName());
			pstmt.setString(4, bean.getGenericName());
			//pstmt.setLong(5, bean.getNgoId());
			pstmt.setString(5, bean.getDeliveryAddress() );		
			pstmt.setString(6, bean.getCreatedBy());			
			pstmt.setString(7, bean.getModifiedBy());
			pstmt.setTimestamp(8, bean.getCreatedDatetime());
			pstmt.setTimestamp(9, bean.getModifiedDatetime());
			
			pstmt.setLong(10, bean.getQuantity());
			pstmt.setString(11, null);
			pstmt.setString(12, null);
			pstmt.setLong(13, bean.getNgoId());
			
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
			throw new ApplicationException("Exception : Exception in add REQUESTMED"+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk;
	}

	/**
	 * Delete a REQUESTMED
	 * 
	 * @param bean
	 * @throws DatabaseException
	 */
	public void delete(RequestMedBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM REQUESTMED WHERE ID=?");
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
			throw new ApplicationException("Exception : Exception in delete REQUESTMED");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}
	
	/*
	 * ACCEPT REQUESTMED
	 */
public void accept(RequestMedBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("UPDATE REQUESTMED SET STATUS = '"+1+"' WHERE ID = ? ");
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
			throw new ApplicationException("Exception : Exception in delete REQUESTMED");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}
	/**
	 * Find REQUESTMED by Login
	 * 
	 * @param login
	 *            : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */

	public RequestMedBean findByLogin(String login) throws ApplicationException {
		log.debug("Model findByLogin Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM REQUESTMED WHERE LOGINID=?");
		RequestMedBean bean = null;
		Connection conn = null;
		System.out.println("sql" + sql);

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RequestMedBean();
				bean.setId(rs.getLong(1));
				bean.setNgoName(rs.getString(2));
				bean.setBrandName(rs.getString(3));
				bean.setGenericName(rs.getString(4));
				bean.setNgoId(rs.getLong(5));
				bean.setDeliveryAddress(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDatetime(rs.getTimestamp(9));								
				bean.setModifiedDatetime(rs.getTimestamp(10));							
				bean.setQuantity(rs.getLong(11));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting REQUESTMED by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByLogin End");
		return bean;
	}

	/**
	 * Find REQUESTMED by PK
	 * 
	 * @param pk
	 *            : get parameter
	 * @return bean
	 * @throws DatabaseException
	 */

	public RequestMedBean findByPK(long pk) throws ApplicationException {
		log.debug("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM REQUESTMED WHERE ID=?");
		RequestMedBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RequestMedBean();
				bean.setId(rs.getLong(1));
				bean.setNgoName(rs.getString(2));
				bean.setBrandName(rs.getString(3));
				bean.setGenericName(rs.getString(4));
			//	bean.setNgoId(rs.getLong(5));
				bean.setDeliveryAddress(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));								
				bean.setModifiedDatetime(rs.getTimestamp(9));
				bean.setQuantity(rs.getLong(10));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting REQUESTMED by pk"+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByPK End");
		return bean;
	}

	/**
	 * Update a REQUESTMED
	 * 
	 * @param bean
	 * @throws DatabaseException
	 */

	public void update(RequestMedBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model update Started");
		Connection conn = null;

//		RequestMedBean beanExist = findByLogin(bean.getLogin());
//		// Check if updated LoginId already exist
//		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
//			throw new DuplicateRecordException("LoginId is already exist");
//		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE REQUESTMED SET NGONAME=?,BRANDNAME=?,GENERICNAME=?,DELIVERYADDRESS=?,"
					
					+ "CREATEDBY=?,MODIFIEDBY=?,CREATEDDATETIME=?,MODIFIEDDATETIME=? ,QUAN= ?, SENDERNO=?, SENDERNAME = ? WHERE ID=?");
			pstmt.setString(1, bean.getNgoName());
			pstmt.setString(2, bean.getBrandName());
			pstmt.setString(3, bean.getGenericName());
		
			pstmt.setString(4, bean.getDeliveryAddress() );					
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setTimestamp(7, bean.getCreatedDatetime());
			pstmt.setString(6, bean.getModifiedBy());			
			pstmt.setTimestamp(8, bean.getModifiedDatetime());
			pstmt.setLong(9, bean.getQuantity());
			pstmt.setString(10, bean.getSenderContact());
			pstmt.setString(11, bean.getSenderName());
			pstmt.setLong(12, bean.getId());
			
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
			throw new ApplicationException("Exception in updating REQUESTMED "+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
	}

	/**
	 * Search REQUESTMED
	 * 
	 * @param bean
	 *            : Search Parameters
	 * @throws DatabaseException
	 */

	public List search(RequestMedBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/**
	 * Search REQUESTMED with pagination
	 * 
	 * @return list : List of REQUESTMEDs
	 * @param bean
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * 
	 * @throws DatabaseException
	 */

	public List search(RequestMedBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model search Started");
		//StringBuffer sql = new StringBuffer("SELECT * FROM REQUESTMED WHERE 1=1");
		StringBuffer sql = new StringBuffer("SELECT * FROM REQUESTMED WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getNgoName() != null && bean.getNgoName().length() > 0) {
				sql.append(" AND NGONAME like '" + bean.getNgoName() + "%'");
			}
			if (bean.getBrandName() != null && bean.getBrandName().length() > 0) {
				sql.append(" AND BRANDNAME like '" + bean.getBrandName() + "%'");
			}
			if (bean.getGenericName() != null && bean.getGenericName().length() > 0) {
				sql.append(" AND GENERICNAME like '" + bean.getGenericName() + "%'");
			}
			

		}

		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
			// sql.append(" limit " + pageNo + "," + pageSize);
		}

		System.out.println("REQUESTMED model search  :"+sql);
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new RequestMedBean();
				bean.setId(rs.getLong(1));
				bean.setNgoName(rs.getString(2));
				bean.setBrandName(rs.getString(3));
				bean.setGenericName(rs.getString(4));
				bean.setDeliveryAddress(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));								
				bean.setModifiedDatetime(rs.getTimestamp(9));	
				bean.setQuantity(rs.getLong(10));
				bean.setSenderContact(rs.getString(11));
				bean.setSenderName(rs.getString(12));
				bean.setNgoId(rs.getLong(13));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in search REQUESTMED"+e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model search End");
		return list;
	}

	/**
	 * Get List of REQUESTMED
	 * 
	 * @return list : List of REQUESTMED
	 * @throws DatabaseException
	 */

	public List list() throws ApplicationException {
		return list(0, 0);
	}

	/**
	 * Get List of REQUESTMED with pagination
	 * 
	 * @return list : List of REQUESTMEDs
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @throws DatabaseException
	 */

	public List list(int pageNo, int pageSize) throws ApplicationException {
		log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from REQUESTMED");
		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		
		System.out.println("sql in list REQUESTMED :"+sql);
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				RequestMedBean bean = new RequestMedBean();
				bean.setId(rs.getLong(1));
				bean.setNgoName(rs.getString(2));
				bean.setBrandName(rs.getString(3));
				bean.setGenericName(rs.getString(4));
				//bean.setNgoId(rs.getLong(5));
				bean.setDeliveryAddress(rs.getString(5));
				bean.setCreatedBy(rs.getString(6));
				bean.setModifiedBy(rs.getString(7));
				bean.setCreatedDatetime(rs.getTimestamp(8));								
				bean.setModifiedDatetime(rs.getTimestamp(9));	
				bean.setQuantity(rs.getLong(10));
				bean.setNgoId(rs.getLong(13));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of REQUESTMEDs");
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

	

	


	

	/**
	 * Register a REQUESTMED
	 * 
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 *             : throws when REQUESTMED already exists
	 * @throws org.omg.CORBA.portable.ApplicationException
	 */

	public long register(RequestMedBean bean)
			throws ApplicationException, DuplicateRecordException {

		log.debug("Model add Started");

		long pk = add(bean);

		
		return pk;
	}

	/**
	 * Reset Password of REQUESTMED with auto generated Password
	 * 
	 * @return boolean : true if success otherwise false
	 * @param login
	 *            : REQUESTMED Login
	 * @throws ApplicationException
	 * @throws org.omg.CORBA.portable.ApplicationException
	 * @throws RecordNotFoundException
	 *             : if REQUESTMED not found
	 */

	/*public boolean resetPassword(REQUESTMEDBean bean)
			throws ApplicationException, org.omg.CORBA.portable.ApplicationException {

		String newPassword = String.valueOf(new Date().getTime()).substring(0, 4);
		REQUESTMEDBean REQUESTMEDData = findByPK(bean.getId());
		REQUESTMEDData.setPassword(newPassword);

		try {
			update(REQUESTMEDData);
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

	

	
}
