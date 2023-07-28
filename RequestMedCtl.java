package in.co.omd.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.mysql.cj.Session;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.RequestMedBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.model.NGOModel;
import in.co.omd.model.RequestMedModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.DataValidator;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;

/**
 * Servlet implementation class RequestMedCtl
 */

/**
 * 
 * @author NAvigable set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */

@WebServlet(name = "RequestMedCtl", urlPatterns = { "/request-med" })
public class RequestMedCtl extends BaseCtl {
	public static final String OP_SIGN_UP = "SignUp";

	private static Logger log = Logger.getLogger(RequestMedCtl.class);

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

		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "Delivery Address"));
			pass = false;
		} 
		
		

		log.debug("RequestMedCtl Method validate Ended");
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
		log.debug("RequestMedCtl Method populatebean Started");

		RequestMedBean bean = new RequestMedBean();
		HttpSession session = request.getSession();
		UserBean  userBean = (UserBean)session.getAttribute("user");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setNgoId(userBean.getId());
		
		bean.setQuantity(DataUtility.getLong(request.getParameter("quan")));
		bean.setNgoName(DataUtility.getString(request.getParameter("ngoname")));

		bean.setBrandName(DataUtility.getString(request.getParameter("brandName")));

		bean.setGenericName(DataUtility.getString(request.getParameter("genericName")));	
		

		bean.setDeliveryAddress(DataUtility.getString(request.getParameter("address")));

		
	

		populateDTO(bean, request);

		log.debug("RequestMedCtl Method populatebean Ended");

		return bean;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestMedCtl() {
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
		log.debug("RequestMedCtl Method doGet Started");
		HttpSession session = request.getSession();
		
		UserBean bean = (UserBean)session.getAttribute("user");
		System.out.println("here========== "+bean.getId());
		NGOModel model = new NGOModel();
		try {
			UserBean bean2 = model.findFromBothTableByPK(bean.getId());
			System.out.println("Ngo Name "+bean2.getNgoName());
			String ngoName = bean2.getNgoName();
			request.setAttribute("ngoName", ngoName);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		log.debug("RequestMedCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));
		// get model
		RequestMedModel model = new RequestMedModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_SAVE.equalsIgnoreCase(op)) {

			RequestMedBean bean = (RequestMedBean) populateBean(request);
			
			try {
				// System.out.println("in try sign up");
				long pk = model.register(bean);
				// System.out.println("register");
				bean.setId(pk);
				ServletUtility.setBean(bean, request);
				request.getSession().setAttribute("UserBean", bean);
				ServletUtility.setSuccessMessage("Medicine Successfully Added", request);
				ServletUtility.forward(OMDSView.REQUEST_MED_VIEW, request, response);
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
			ServletUtility.redirect(OMDSView.REQUEST_MED_CTL, request, response);
			return;
		}
		log.debug("RequestMedCtl Method doPost Ended");
	}

	

	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.REQUEST_MED_VIEW;
	}

}
