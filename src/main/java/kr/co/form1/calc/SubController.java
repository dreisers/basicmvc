package kr.co.form1.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubController {

	public SubController() {
		System.out.println("----- SubController() 객체 생성됨");
	}
	
	// 결과확인
	// http://localhost:9090/form1/sub.do?no1=3&no2=5
	
	@RequestMapping("/sub.do")
	public ModelAndView sub(HttpServletRequest req) {
		
		int no1 = Integer.parseInt(req.getParameter("no1"));
		int no2 = Integer.parseInt(req.getParameter("no2"));
		int result = no1 - no2 ;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");
		
		req.setAttribute("msg", "<h1>두수의 차</h1>");
		req.setAttribute("img", "<img src='images/sub.png'>");
		
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		
		return mav;			
	}//sub() end
	
	
}//class end


