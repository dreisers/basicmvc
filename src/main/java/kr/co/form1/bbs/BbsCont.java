package kr.co.form1.bbs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsCont {

	public BbsCont() {
		System.out.println("----- BbsCont() 객체 생성됨");		
	}
	
	//결과확인
	//http://localhost:9090/form1/bbs/create.do
	
	/*	 
	//1)
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.GET)
	public ModelAndView bbsForm() {
		ModelAndView mav = new ModelAndView();
		// servlet-context.xml
		// prefix="/", suffix=".jsp"
		// View페이지 :  /bbs/bbsForm.jsp
		mav.setViewName("bbs/bbsForm"); 
		return mav;
	}//bbsForm() end
	*/
	
	//2)
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.GET)
	public String bbsForm() {
		return "bbs/bbsForm";
	}//bbsForm() end
//--------------------------------------------------------------------
	
	//동일한 요청명령어를 GET 또는 POST방식으로
	//분리해서 호출가능
	/*
	1)
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.POST)	
	public ModelAndView bbsIns(HttpServletRequest req) {
		String wname   = req.getParameter("wname").trim();
		String subject = req.getParameter("subject").trim();
		String content = req.getParameter("content").trim();
		String passwd  = req.getParameter("passwd").trim();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/bbsResult");
		
		mav.addObject("wname", wname);
		mav.addObject("subject", subject);
		mav.addObject("content", content);
		mav.addObject("passwd", passwd);

		return mav;
	}//bbsIns() end
	*/
	
	//2) 매개변수(parameter)가 DTO객체인 경우
	//   -> 해당 클래스에 반드시
	//   -> 폼 컨트롤 요소이름으로 되어 있는
	//   -> 멤버변수, 각 getter와 setter함수가 
	//   -> 있어야 한다
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.POST)	
	public ModelAndView bbsIns(BbsDTO dto) {
		System.out.println("wname   : " + dto.getWname());
		System.out.println("subject : " + dto.getSubject());
		System.out.println("content : " + dto.getContent());
		System.out.println("passwd  : " + dto.getPasswd());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/bbsResult2");
		//request영역에 dto객체 올리기
		mav.addObject("dto", dto);
		return mav;
	}//bbsIns() end
	
}//class end
