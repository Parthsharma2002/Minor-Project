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
import in.co.omd.bean.RequestMedBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.model.RequestMedModel;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;





/**
 * Servlet implementation class RequestMedListCtl
 */

/**
 *
 * @author Navigable set
 * @version 1.0
 * @Copyright (c) Navigable Set
 *
 */
@WebServlet(name = "RequestMedListCtl", urlPatterns = { "/ctl/requestList" })
public class RequestMedListCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(RequestMedListCtl.class);

	/**
	 * Populates bean object from request parameters
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("RequestMedListCtl populateBean method start");
		RequestMedBean bean = new RequestMedBean();
		bean.setBrandName(DataUtility.getString(request.getParameter("brandName")));
		bean.setGenericName(DataUtility.getString(request.getParameter("genericName")));
		
		log.debug("RequestMedListCtl populateBean method end");
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
		log.debug("RequestMedListCtl doGet Start");
		List list = null;

		int pageNo = 1;

		int pageSize = DataUtility.getInt(PropertyReader
				.getValue("page.size"));

		RequestMedBean bean = (RequestMedBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));
		// get the selected checkbox ids array for delete list

		String[] ids = request.getParameterValues("ids");

		RequestMedModel model = new RequestMedModel();
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
		log.debug("RequestMedListCtl doPOst End");
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
		
		log.debug("RequestMedListCtl doPost Start");
		
		
		List list = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		
		RequestMedBean bean = (RequestMedBean) populateBean(request);
		
		String op = DataUtility.getString(request.getParameter("operation"));
		// get the selected checkbox ids array for delete list
		
		String[] ids = request.getParameterValues("ids");
		HttpSession session = request.getSession();
		RequestMedModel model = new RequestMedModel();
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
				ServletUtility.redirect(OMDSView.REQUEST_LIST_CTL, request, response);
				return;
			}  else if (OP_RESET.equalsIgnoreCase(op)) {
				ServletUtility.redirect(OMDSView.REQUEST_LIST_CTL, request, response);
				return;

			}
			//	System.out.println("session === "+ids[0]);
			

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
		log.debug("RequestMedListCtl doGet End");

	}

	/**
	 * Returns the VIEW page of this Controller
	 * 
	 * @return
	 */
	@Override
	protected String getView() {
		return OMDSView.REQUEST_LIST_VIEW;
	}
}
