package kr.co.form1.bbs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsCont {

	public BbsCont() {
		System.out.println("----- BbsCont() ��ü ������");		
	}
	
	//���Ȯ��
	//http://localhost:9090/form1/bbs/create.do
	
	/*	 
	//1)
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.GET)
	public ModelAndView bbsForm() {
		ModelAndView mav = new ModelAndView();
		// servlet-context.xml
		// prefix="/", suffix=".jsp"
		// View������ :  /bbs/bbsForm.jsp
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
	
	//������ ��û��ɾ GET �Ǵ� POST�������
	//�и��ؼ� ȣ�Ⱑ��
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
	
	//2) �Ű�����(parameter)�� DTO��ü�� ���
	//   -> �ش� Ŭ������ �ݵ��
	//   -> �� ��Ʈ�� ����̸����� �Ǿ� �ִ�
	//   -> �������, �� getter�� setter�Լ��� 
	//   -> �־�� �Ѵ�
	@RequestMapping(value="/bbs/create.do", method=RequestMethod.POST)	
	public ModelAndView bbsIns(BbsDTO dto) {
		System.out.println("wname   : " + dto.getWname());
		System.out.println("subject : " + dto.getSubject());
		System.out.println("content : " + dto.getContent());
		System.out.println("passwd  : " + dto.getPasswd());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/bbsResult2");
		//request������ dto��ü �ø���
		mav.addObject("dto", dto);
		return mav;
	}//bbsIns() end
	
}//class end
