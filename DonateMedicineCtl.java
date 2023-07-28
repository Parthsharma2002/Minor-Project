package in.co.omd.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.log4j.Logger;


import com.mysql.cj.Session;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.DonateMedicineBean;
import in.co.omd.bean.NGOBean;
import in.co.omd.bean.RequestMedBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.model.DonateMedicineModel;
import in.co.omd.model.NGOModel;
import in.co.omd.model.RequestMedModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.DataValidator;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;

/**
 * Servlet implementation class DonateMedicineCtl
 */

/**
 * DonateMedicineCtl functionality Controller. 
 * 
 * @author NAvigable set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */

@WebServlet(name = "DonateMedicineCtl", urlPatterns = { "/donatemedicine" })
@MultipartConfig(maxFileSize = 16177215)
public class DonateMedicineCtl extends BaseCtl {
	public static final String OP_SIGN_UP = "SignUp";

	private static Logger log = Logger.getLogger(DonateMedicineCtl.class);


	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("UserRegistrationCtl Method validate Started");

		boolean pass = true;

		

		if (DataValidator.isNull(request.getParameter("manufacturerdate"))) {
			request.setAttribute("manufacturerdate", PropertyReader.getValue("error.require", "Manufacturer  Date"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("expirydate"))) {
			request.setAttribute("expirydate", PropertyReader.getValue("error.require", "Expiry  Date"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("brandName"))) {
			request.setAttribute("brandName", PropertyReader.getValue("error.require", "Brand Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("brandName"))) {
			request.setAttribute("brandName", PropertyReader.getValue("error.name", "Brand Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("genericName"))) {
			request.setAttribute("genericName", PropertyReader.getValue("error.require", "Generic Name"));
			pass = false;
		} 	

		if (DataValidator.isNull(request.getParameter("quan"))) {
			request.setAttribute("quan", PropertyReader.getValue("error.require", "Quantity"));
			pass = false;

		} else if (!DataValidator.isInteger(request.getParameter("quan"))) {
			request.setAttribute("quan", PropertyReader.getValue("error.integer", "Quantity"));
			pass = false;
		} 

		
		if (DataValidator.isNull(request.getParameter("ngoname"))) {
			request.setAttribute("ngoname", PropertyReader.getValue("error.require", "NGO Name"));
			pass = false;
		}

		
		

		log.debug("UserRegistrationCtl Method validate Ended");
		return pass;
	}

	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("DonateMedicineCtl Method populatebean Started");

		DonateMedicineBean bean = new DonateMedicineBean();
		HttpSession session = request.getSession();
		UserBean  userBean = (UserBean)session.getAttribute("user");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setUserid(userBean.getId());
		
		bean.setQuantity(DataUtility.getLong(request.getParameter("quan")));
		bean.setNgoId(DataUtility.getLong(request.getParameter("ngoname")));

		bean.setMedicineBrand(DataUtility.getString(request.getParameter("brandName")));

		bean.setMedicineGeneric(DataUtility.getString(request.getParameter("genericName")));	
		

		bean.setMedicineManufacturerDate(DataUtility.getDate(request.getParameter("manufacturerdate")));
		bean.setMedicineExpiryDate(DataUtility.getDate(request.getParameter("expirydate")));

		Blob blob=null;
		
		
			Part filepart;
			try {
				filepart = request.getPart("uploadpacket");
				
				blob = medicinePacketUpload(filepart);
				
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //Upload material method called
		
		bean.setMedicinePacket(blob);
	

		populateDTO(bean, request);

		log.debug("DonateMedicineCtl Method populatebean Ended");

		return bean;
	}
	
	public Blob medicinePacketUpload(Part part) throws IOException {
		InputStream inputStream = null;
		Blob blob = null;
		inputStream = part.getInputStream();
		byte[] b = new byte[inputStream.available()];
		inputStream.read(b);

		try {
			blob = new SerialBlob(b);

		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blob;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonateMedicineCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contains display logic
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("DonateMedicineCtl Method doGet Started");

		ServletUtility.forward(getView(), request, response);

	}

	/**
	 * Contains submit logic
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in post method");
		
		log.debug("DonateMedicineCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));
		// get model
		DonateMedicineModel model = new DonateMedicineModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op)) {

			DonateMedicineBean bean = (DonateMedicineBean) populateBean(request);
			System.out.println("ngo id "+bean.getNgoId());
			try {
				System.out.println("in try sign up");
				long pk = model.registerUser(bean);
				// System.out.println("register");
				bean.setId(pk);

				request.getSession().setAttribute("UserBean", bean);
				ServletUtility.setSuccessMessage("Medicine Successfully Added", request);
				ServletUtility.forward(OMDSView.DONATE_MEDICINE_VIEW, request, response);
				return;
			} catch (DuplicateRecordException e) {
				log.error(e);
				System.out.println("msg = "+e.getMessage());
				ServletUtility.setBean(bean, request);
				String erroMsg = e.getMessage(); 
				if(erroMsg.equalsIgnoreCase("Account No already exists")) {
					ServletUtility.setErrorMessage("Account No already exist", request);
				}else {
					ServletUtility.setErrorMessage("Login id already exists", request);
				}
				
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				e.printStackTrace();
				return;
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(OMDSView.DONATE_MEDICINE_CTL, request, response);
			return;
		}
		log.debug("DonateMedicineCtl Method doPost Ended");
	}

	
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.DONATE_MEDICINE_VIEW;
	}

}
