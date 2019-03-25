package kr.co.form1.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// URL에서 요청한 명령어를 처리하는 클래스
@Controller // -> 스프링컨테이너에 의해서 자동으로 객체가 생성된다
public class LoginCont {

	public LoginCont() {
		System.out.println("---- LoginCont()객체 생성 ----");
	}

	// 결과확인
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

	// 사용자가 요청한 정보를 가져와서 처리하는 다양한 방법
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
	// 4) 매개변수로 DTO객체가 오면 멤버변수, getter와 setter함수를 생성
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

		if (id.equals("soldesk") && pw.equals("1234")) { // 로그인 성공
			mav.setViewName("login/loginResult");
			// session영역
			session.setAttribute("s_id", id);
			session.setAttribute("s_pw", pw);
			// request영역
			req.setAttribute("r_id", id);
			req.setAttribute("r_pw", pw);
			req.setAttribute("msg", "로그인 성공");
			
		} else {// 로그인 실패
			mav.setViewName("login/msgView");
			// request영역
			mav.addObject("msg", "<p>아이디 혹은 비밀번호가 일치하지 않습니다</p>");
			mav.addObject("link", "<a href='javascript:history.back()'>[다시시도]");
		} // if end
		return mav;
	}// loginProc end

}// class end
