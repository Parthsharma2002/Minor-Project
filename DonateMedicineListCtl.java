package in.co.omd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.DonateMedicineBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.model.DonateMedicineModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;





/**
 * Servlet implementation class DonateMedicineListCtl
 */

/**
 *
 * @author Navigable set
 * @version 1.0
 * @Copyright (c) Navigable Set
 *
 */
@WebServlet(name = "DonateMedicineListCtl", urlPatterns = { "/ctl/donationList" })
public class DonateMedicineListCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(DonateMedicineListCtl.class);

	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("UserListCtl populateBean method start");
		DonateMedicineBean bean = new DonateMedicineBean();
		bean.setMedicineBrand(DataUtility.getString(request.getParameter("brandName")));
		bean.setMedicineGeneric(DataUtility.getString(request.getParameter("genericName")));
		log.debug("UserListCtl populateBean method end");
		return bean;
	}

	/**
	 * Contains Display logics
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("DonateMedicineListCtl doGet Start");
		List list = null;

		int pageNo = 1;

		int pageSize = DataUtility.getInt(PropertyReader
				.getValue("page.size"));

		DonateMedicineBean bean = (DonateMedicineBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));
		// get the selected checkbox ids array for delete list

		String[] ids = request.getParameterValues("ids");

		DonateMedicineModel model = new DonateMedicineModel();
		try {

			list = model.search(bean, pageNo, pageSize);

			
		
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("DonateMedicineListCtl doPOst End");
	}

	/**
	 * Contains Submit logics
	 */
	@Override

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		log.debug("DonateMedicineListCtl doPost Start");
		
		
		List list = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		
		DonateMedicineBean bean = (DonateMedicineBean) populateBean(request);
		
		String op = DataUtility.getString(request.getParameter("operation"));
		// get the selected checkbox ids array for delete list
		
		String[] ids = request.getParameterValues("ids");
		HttpSession session = request.getSession();
		DonateMedicineModel model = new DonateMedicineModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(OMDSView.USER_CTL, request, response);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(OMDSView.DONATE_MEDICINE_LIST_CTL, request, response);
				return;

			}else if(OP_CONFIRM.equalsIgnoreCase(op)) {
				if (ids != null && ids.length > 0) {
				UserBean acceptbean = new UserBean();
				for (String id : ids) {
					acceptbean.setId(DataUtility.getInt(id));
					model.accept(acceptbean);
				}
				ServletUtility.setSuccessMessage("User accepted Successfully", request);
				}else {
					ServletUtility.setErrorMessage("Select at least one user", request);
				}
			//	System.out.println("session === "+ids[0]);
			}

			list = model.search(bean, pageNo, pageSize);
			
			
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}
		log.debug("DonateMedicineListCtl doGet End");

	}

	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.DONATE_MEDICINE_LIST_VIEW;
	}
}
