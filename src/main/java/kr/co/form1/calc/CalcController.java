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
		System.out.println("----- CalcController() ��ü ������");
	}
	
	//1)��û��ɾ �ϳ��� ��Ʈ�ѷ� Ŭ������
	//  �Ѳ��� ��� �����ϴ�
	/*
	  @RequestMapping(value   = "��û��ɾ�",
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
		
		req.setAttribute("msg", "<h1>�μ��� ��</h1>");
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
		
		req.setAttribute("msg", "<h1>�μ��� ��</h1>");
		req.setAttribute("img", "<img src='images/div.png'>");
		
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		return mav;
	}//div() end
//----------------------------------------------	
	//2) ��û��ɾ ó���ϴ�
	//   �޼ҵ��� �Ű������� ������
	
	//����ڰ� ��û�� �� ��������
	//@RequestParam("��û������") �ڷ��� ������
	
	@RequestMapping(value="diff.do", method=RequestMethod.GET)
	public ModelAndView diff(@RequestParam("no1") int no1,
			                 @RequestParam("no2") int no2) {

		//System.out.println(no1);
		//System.out.println(no2);
		//�μ� ������ ����
		int result = no1-no2;
		if(result<0) {
			result = -result;
		}//if end		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");
		
		//request������ �� �ø���
		//req.setAttribute()�Լ��� ������ ���
		mav.addObject("msg", "<h1>�μ������� ����</h1>");		
		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);		
		
		return mav;
		
	}//diff() end
//--------------------------------------------
	//3)����� ��û ���ް� ó��
	//  -> ��û �������� �Ű������� ���� ����
	@RequestMapping(value="max.do", method=RequestMethod.GET)
	public ModelAndView max(int no1, int no2) {
		int result = (no1<no2)? no2 : no1;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calc/calcResult");		
		mav.addObject("msg", "<h1>�μ� �� ū��</h1>");		
		mav.addObject("no1", no1);
		mav.addObject("no2", no2);
		mav.addObject("result", result);		
		
		return mav;
	}//max()
	
	
	
}//class end



