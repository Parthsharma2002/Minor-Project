package in.co.omd.controller;

public interface OMDSView {

	public String APP_CONTEXT = "/OnlineMedicineDonation";

	public String PAGE_FOLDER = "/jsp";

	public String ERROR_VIEW = PAGE_FOLDER + "/Error.jsp";
	
	public String ERROR_CTL = "/ctl/ErrorCtl";
	
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";	
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/register";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	
	public String NGO_REGISTRATION_CTL = APP_CONTEXT + "/ngo-register";
	public String NGO_REGISTRATION_VIEW = PAGE_FOLDER + "/NGORegistrationView.jsp";
	
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";	
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String USER_CTL = APP_CONTEXT + "/ctl/user";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/userList";
	
	public String NGO_VIEW = PAGE_FOLDER + "/NGOView.jsp";	
	public String NGO_LIST_VIEW = PAGE_FOLDER + "/NGOListView.jsp";
	public String NGO_CTL = APP_CONTEXT + "/ctl/ngos";
	public String NGO_LIST_CTL = APP_CONTEXT + "/ctl/ngoList";
	
	public String REQUEST_MED_CTL = APP_CONTEXT + "/request-med";
	public String REQUEST_MED_VIEW = PAGE_FOLDER + "/RequestMedView.jsp";
	public String REQUEST_LIST_CTL = APP_CONTEXT + "/ctl/requestList";
	public String REQUEST_LIST_VIEW = PAGE_FOLDER + "/RequestListView.jsp";
	public String REQUESTED_MED_LIST_CTL = APP_CONTEXT + "/ctl/requestmedList";
	public String REQUESTED_MED_LIST_VIEW = PAGE_FOLDER + "/RequestedMedicineListView.jsp";
	
	public String REQUEST_CTL = APP_CONTEXT + "/ctl/requestmedicine";
	public String REQUEST_VIEW = PAGE_FOLDER + "/RequestView.jsp";
	
	public String DONATE_MEDICINE_CTL = APP_CONTEXT + "/donatemedicine";
	public String DONATE_MEDICINE_VIEW = PAGE_FOLDER + "/DonateMedicineView.jsp";
	public String DONATE_MEDICINE_LIST_CTL = APP_CONTEXT + "/ctl/donationList";
	public String DONATE_MEDICINE_LIST_VIEW =  PAGE_FOLDER + "/DonationListView.jsp";
	
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String CONTACT_US_VIEW = PAGE_FOLDER + "/ContactUsView.jsp";
	
	
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/changePassword";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/myProfile";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/forgetPassword";
	
	public String USER_DONATION_LIST_CTL = APP_CONTEXT + "/ctl/donations";
	public String USER_DONATION_LIST_VIEW = PAGE_FOLDER + "/AllDonationUserView.jsp";
	
}
