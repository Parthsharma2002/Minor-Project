package in.co.omd.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.NGOBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.model.NGOModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.DataValidator;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;

/**
 * Servlet implementation class NGORegistrationCtl
 */

/**
 * 
 * @author NAvigable set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */

@WebServlet(name = "NGORegistrationCtl", urlPatterns = { "/ngo-register" })
public class NGORegistrationCtl extends BaseCtl {
	public static final String OP_SIGN_UP = "SignUp";

	private static Logger log = Logger.getLogger(NGORegistrationCtl.class);

	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {
		log.debug("NGORegistrationCtl Method validate Started");

		boolean pass = true;

		String login = request.getParameter("login");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getValue("error.name", "First Name"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.require", "Last Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getValue("error.name", "Last Name"));
			pass = false;
		}
		

		if (DataValidator.isNull(login)) {
			request.setAttribute("login", PropertyReader.getValue("error.require", "Login Id"));
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login", PropertyReader.getValue("error.email", "Login"));
			pass = false;
		}
		/*
		 * if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
		 * request.setAttribute("confirmPassword", PropertyReader.getValue(
		 * "error.require", "Confirm Password")); pass = false; }
		 */
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("gender"))) {
			request.setAttribute("gender", PropertyReader.getValue("error.require", "Gender"));
			pass = false;
		}

		

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getValue("error.require", "Password"));
			pass = false;

		} else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getValue("error.password", "Password"));
			pass = false;
		} 

		if (DataValidator.isNull(request.getParameter("mobile"))) {
			request.setAttribute("mobile", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("mobile"))) {
			request.setAttribute("mobile", PropertyReader.getValue("error.invalid", "Mobile No"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("ngoname"))) {
			request.setAttribute("ngoname", PropertyReader.getValue("error.require", "NGO Name"));
			pass = false;
		} 
		if (DataValidator.isNull(request.getParameter("uniqueId"))) {
			request.setAttribute("uniqueId",
					PropertyReader.getValue("error.require", "Id Proof"));
			pass = false;
		}

		

		log.debug("NGORegistrationCtl Method validate Ended");
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
		log.debug("NGORegistrationCtl Method populatebean Started");

		UserBean bean = new UserBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));

		bean.setRoleId(3L);
		
		bean.setRoleName("NGO");

		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));

		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));

		bean.setLogin(DataUtility.getString(request.getParameter("login")));	
		

		bean.setPassword(DataUtility.getString(request.getParameter("password")));

		//bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));

		bean.setGender(DataUtility.getString(request.getParameter("gender")));

		

		bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));

		bean.setStatus("0");
		bean.setUniqueId(DataUtility.getString(request.getParameter("uniqueId")));
	

		populateDTO(bean, request);

		log.debug("NGORegistrationCtl Method populatebean Ended");

		return bean;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NGORegistrationCtl() {
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
		log.debug("NGORegistrationCtl Method doGet Started");
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
		log.debug("NGORegistrationCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));
		// get model
		NGOModel model = new NGOModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SIGN_UP.equalsIgnoreCase(op)) {

			UserBean bean = (UserBean) populateBean(request);
			NGOBean ngoBean = new NGOBean();
			ngoBean.setNgoName(DataUtility.getString(request.getParameter("ngoname")));
			try {
				// System.out.println("in try sign up");
				long pk = model.registerUser(bean,ngoBean);
				// System.out.println("register");
				bean.setId(pk);

				request.getSession().setAttribute("UserBean", bean);
				ServletUtility.setSuccessMessage("NGO Successfully Registered", request);
				ServletUtility.forward(OMDSView.NGO_REGISTRATION_VIEW, request, response);
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
			ServletUtility.redirect(OMDSView.USER_REGISTRATION_CTL, request, response);
			return;
		}
		log.debug("NGORegistrationCtl Method doPost Ended");
	}

	
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.NGO_REGISTRATION_VIEW;
	}

}
