package kr.co.form1.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

//������ �����ӿ�ũ Ư¡
//-> ������̼� ������� ������ �� �ִ�
//-> ȯ�� ������ �����ϴ�

//������ �����̳�(����)���� �ڵ����� ��ü ����
//-> @Controller
//-> @Autowired
//-> @Component

@Controller
public class AddController {
	
	public AddController() {
		System.out.println("----- AddController() ��ü ������");
	}

	//���Ȯ��
	//http://localhost:9090/form1/plus.do?no1=3&no2=5
		
	//@RequestMapping
	//-> ��û��ɾ� ���
	//-> ��û��ɾ� ����� ������ ��ü�� �޼ҵ�� �Ѵ�          
	@RequestMapping("/plus.do")
	public ModelAndView plus(HttpServletRequest req) {
		//����� ��û�� ��������
		int no1 = Integer.parseInt(req.getParameter("no1"));
		int no2 = Integer.parseInt(req.getParameter("no2"));
		System.out.println(no1);
		System.out.println(no2);

		int result = no1 + no2 ;
		
		//View������ �̵��ϱ� ���� Ŭ����
		//-> Model
		//-> ModelAndView				
		ModelAndView mav = new ModelAndView();
		//view������ �̵�
		// -> prefix="/", suffix=".jsp"
		// -> /calc/calcResult.jsp
		mav.setViewName("calc/calcResult");
		
		//��������� req������ ���ø���
		req.setAttribute("msg", "<h1>�μ��� ��</h1>");
		req.setAttribute("img", "<img src='images/add.png'>");
		
		req.setAttribute("no1", no1);
		req.setAttribute("no2", no2);
		req.setAttribute("result", result);
		
		return mav;		
	}//plus() end
	
	
	
	
	
}//class end
