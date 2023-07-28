package in.co.omd.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.RequestMedBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.exception.DuplicateRecordException;
import in.co.omd.model.RequestMedModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.DataValidator;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;





/**
 * Servlet implementation class RequestCtl
 */

/**
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */

@ WebServlet(name="RequestCtl",urlPatterns={"/ctl/requestmedicine"})
@MultipartConfig(maxFileSize = 16177215)
public class RequestCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(RequestCtl.class);
	/**
	 * Loads list and other data required to display at HTML form
	 * 
	 * @param request
	 */
//	@Override
//	protected void preload(HttpServletRequest request) {
//		log.debug("UserCtl preload method start");
//		RoleModel model = new RoleModel();
//		try {
//			List l = model.list();
//			request.setAttribute("roleList", l);
//		} catch (ApplicationException e) {
//			log.error(e);
//		}
//		log.debug("UserCtl preload method end");
//	}
	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("RequestCtl Method validate Started");

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
		} //else if (!DataValidator.isPassword(request.getParameter("password"))) {
//			request.setAttribute("password", PropertyReader.getValue("error.password", "Password"));
//			return false;
//		}

		/*
		 * if (!request.getParameter("password").equals(
		 * request.getParameter("confirmPassword")) &&
		 * !"".equals(request.getParameter("confirmPassword"))) {
		 * ServletUtility.setErrorMessage("Confirm Password did not match", request);
		 * request.setAttribute("confirmPassword",
		 * PropertyReader.getValue("error.confirmPassword","Confirm Password")); pass =
		 * false; }
		 */

		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "Delivery Address"));
			pass = false;
		} 


		log.debug("RequestCtl Method validate Ended");

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

		log.debug("RequestCtl Method populatebean Started");

		RequestMedBean bean = new RequestMedBean();
		HttpSession session = request.getSession();
		UserBean  userBean = (UserBean)session.getAttribute("user");
		bean.setSenderName(userBean.getFirstName()+" "+userBean.getLastName());
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		
		
		bean.setQuantity(DataUtility.getLong(request.getParameter("quan")));
		bean.setNgoName(DataUtility.getString(request.getParameter("ngoname")));

		bean.setBrandName(DataUtility.getString(request.getParameter("brandName")));

		bean.setGenericName(DataUtility.getString(request.getParameter("genericName")));	
		

		bean.setDeliveryAddress(DataUtility.getString(request.getParameter("address")));
		bean.setSenderContact(DataUtility.getString(request.getParameter("scontact")));
		populateDTO(bean, request);

		log.debug("RequestCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * Contains DIsplay logics
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("RequestCtl Method doGet Started");

		String op = DataUtility.getString(request.getParameter("operation"));
        // get model
        
		RequestMedModel model = new RequestMedModel();
        
		long id = DataUtility.getLong(request.getParameter("id"));
       
		if (id > 0 || op != null) {
          
            
			RequestMedBean bean;
            try {
                bean = model.findByPK(id);
             
                ServletUtility.setBean(bean, request);
            
            } catch (ApplicationException e) {
                log.error(e);
            
                ServletUtility.handleException(e, request, response);
                return;
            }
        }

        ServletUtility.forward(getView(), request, response);
        log.debug("RequestCtl Method doGet Ended");
	}

	

/**
 * Contains Submit logics
 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("requestctl");
        String op = DataUtility.getString(request.getParameter("operation"));
        // get model
        RequestMedModel model = new RequestMedModel();
        long id = DataUtility.getLong(request.getParameter("id"));
        if (OP_SAVE.equalsIgnoreCase(op)) {
            RequestMedBean bean = (RequestMedBean) populateBean(request);
                       
            try {
                if (id > 0) {
                	System.out.println("heere");
                    model.update(bean);
                    ServletUtility.setBean(bean, request);
                    ServletUtility.setSuccessMessage("Request for medicine is successfully send to NGO", request);
                } else {
                    long pk = model.add(bean);
                   // bean.setId(pk);
                    ServletUtility.setSuccessMessage("Request for medicine is successfully send to NGO",request);
                }
              
               
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
                return;
            } catch (DuplicateRecordException e) {
                ServletUtility.setBean(bean, request);
                ServletUtility.setErrorMessage("Login id already exists", request);
            }
            ServletUtility.forward(getView(), request, response);
        } else if (OP_DELETE.equalsIgnoreCase(op)) {

            RequestMedBean bean = (RequestMedBean) populateBean(request);
            try {
                model.delete(bean);
                ServletUtility.redirect(OMDSView.REQUEST_LIST_CTL, request,
                        response);
                return;
            } catch (ApplicationException e) {
                log.error(e);
                ServletUtility.handleException(e, request, response);
              
                return;
            }

        } else if (OP_CANCEL.equalsIgnoreCase(op)) {
        	ServletUtility.redirect(OMDSView.REQUEST_LIST_CTL, request, response);
        	
        }
    				
    		
       // ServletUtility.forward(getView(), request, response);
        

        log.debug("RequestCtl Method doPostEnded");
	}
	
	
	protected String SubImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("");
		String savePath = DataUtility.getString(PropertyReader.getValue("imagePath"));

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part part = request.getPart("photo");
		String fileName = extractFileName(part);
		part.write(savePath + File.separator + fileName);
		String filePath = fileName;
		System.out.println("Path----" + savePath + File.separator + fileName);

		return fileName;

	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	
	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.REQUEST_VIEW;
	}

}
