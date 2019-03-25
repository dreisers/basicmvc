package kr.co.form1.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// URL���� ��û�� ��ɾ ó���ϴ� Ŭ����
@Controller // -> �����������̳ʿ� ���ؼ� �ڵ����� ��ü�� �����ȴ�
public class LoginCont {

	public LoginCont() {
		System.out.println("---- LoginCont()��ü ���� ----");
	}

	// ���Ȯ��
	// http://localhost:9090/form1/login.do

	// 1)
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.GET) public
	 * ModelAndView loginForm() { ModelAndView mav = new ModelAndView();
	 * mav.setViewName(""); return mav; }
	 */
	// 2)
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}

	// ����ڰ� ��û�� ������ �����ͼ� ó���ϴ� �پ��� ���
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.POST) public
	 * ModelAndView loginProc(HttpServletRequest req) { String id =
	 * req.getParameter("id"); String pw = req.getParameter("id"); }
	 */
	// 2)
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.POST) public
	 * ModelAndView loginProc(@RequestParam("id") String id, @RequestParam("pw")
	 * String pw) {
	 * 
	 * }
	 */
	// 3)
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.POST) public
	 * ModelAndView loginProc(String id, String pw) { }//loginProc end
	 */
	// 4) �Ű������� DTO��ü�� ���� �������, getter�� setter�Լ��� ����
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.POST) public
	 * ModelAndView loginProc(LoginVO vo) { }//loginProc end
	 */
	// 5)
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginProc(LoginVO vo, HttpServletRequest req, HttpSession session) {
		String id = vo.getId();
		String pw = vo.getPw();
		// System.out.println(id + "," + pw);
		ModelAndView mav = new ModelAndView();

		if (id.equals("soldesk") && pw.equals("1234")) { // �α��� ����
			mav.setViewName("login/loginResult");
			// session����
			session.setAttribute("s_id", id);
			session.setAttribute("s_pw", pw);
			// request����
			req.setAttribute("r_id", id);
			req.setAttribute("r_pw", pw);
			req.setAttribute("msg", "�α��� ����");
			
		} else {// �α��� ����
			mav.setViewName("login/msgView");
			// request����
			mav.addObject("msg", "<p>���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�</p>");
			mav.addObject("link", "<a href='javascript:history.back()'>[�ٽýõ�]");
		} // if end
		return mav;
	}// loginProc end

}// class end
