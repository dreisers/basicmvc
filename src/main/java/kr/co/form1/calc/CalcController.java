package kr.co.form1.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	public CalcController() {
		System.out.println("----- CalcController() 객체 생성됨");
	}
	
	//1)요청명령어를 하나의 컨트롤러 클래스에
	//  한꺼번 등록 가능하다
	/*
	  @RequestMapping(value   = "요청명령어",
	                  method  = GET | POST,
	                  produces= "text/plain; charset=UTF-8")	
	*/
	
	@RequestMapping(value="multi.do", method=RequestMethod.GET)
	public ModelAndView multi(HttpServletRequest req) {
		int no1 = Integer.parseInt(req.getParameter("no1"));
		int no2 = Integer.parseInt(req.getParameter("no2"));
		int result = no1 * no2 ;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");
		
		req.setAttribute("msg", "<h1>두수의 곱</h1>");
		req.setAttribute("img", "<img src='images/mul.png'>");
		
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		
		return mav;
	}//multi() end
	
	
	@RequestMapping(value="div.do", method=RequestMethod.GET)
	public ModelAndView div(HttpServletRequest req) {
		int no1 = Integer.parseInt(req.getParameter("no1"));
		int no2 = Integer.parseInt(req.getParameter("no2"));
		int result = no1 / no2 ;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");
		
		req.setAttribute("msg", "<h1>두수의 몫</h1>");
		req.setAttribute("img", "<img src='images/div.png'>");
		
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		return mav;
	}//div() end
//----------------------------------------------	
	//2) 요청명령어를 처리하는
	//   메소드의 매개변수의 유연성
	
	//사용자가 요청한 값 가져오기
	//@RequestParam("요청변수명") 자료형 변수명
	
	@RequestMapping(value="diff.do", method=RequestMethod.GET)
	public ModelAndView diff(@RequestParam("no1") int no1,
			                 @RequestParam("no2") int no2) {

		//System.out.println(no1);
		//System.out.println(no2);
		//두수 사이의 간격
		int result = no1-no2;
		if(result<0) {
			result = -result;
		}//if end		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");
		
		//request영역에 값 올리기
		//req.setAttribute()함수와 동일한 기능
		mav.addObject("msg", "<h1>두수사이의 간격</h1>");		
		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);		
		
		return mav;
		
	}//diff() end
//--------------------------------------------
	//3)사용자 요청 전달값 처리
	//  -> 요청 변수명을 매개변수로 직접 접근
	@RequestMapping(value="max.do", method=RequestMethod.GET)
	public ModelAndView max(int no1, int no2) {
		int result = (no1<no2)? no2 : no1;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");		
		mav.addObject("msg", "<h1>두수 중 큰값</h1>");		
		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);		
		
		return mav;
	}//max()
	
	
	
}//class end



