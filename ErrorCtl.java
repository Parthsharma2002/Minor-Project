package in.co.omd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.omd.bean.BaseBean;
import in.co.omd.bean.UserBean;
import in.co.omd.exception.ApplicationException;
import in.co.omd.model.UserModel;
import in.co.omd.util.DataUtility;
import in.co.omd.util.DataValidator;
import in.co.omd.util.PropertyReader;
import in.co.omd.util.ServletUtility;




/**
 * Servlet implementation class ErrorCtl
 */

@WebServlet(name = "ErrorCtl", urlPatterns = { "/ctl/ErrorCtl" })
public class ErrorCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;
	
	public static String HIT_URI = null;
	
	private  static Logger log = Logger.getLogger(ErrorCtl.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate input Data Entered By User
	 * 
	 * @param request
	 * @return
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ServletUtility.forward(getView(), request, response);
		log.debug("ErrorCtl Method doGet end");
	}

	
	@Override
	protected String getView() {
		return OMDSView.ERROR_VIEW;
	}

}
