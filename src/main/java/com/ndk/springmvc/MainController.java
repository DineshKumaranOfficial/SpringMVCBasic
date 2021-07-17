package com.ndk.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ndk.springmvc.dao.EmployeeDAO;
import com.ndk.springmvc.models.Employee;

@Controller
public class MainController {

	@Autowired
	private EmployeeDAO employeeDao;
	
	@ModelAttribute
	public void techModel(Model model) {
		model.addAttribute("techName", "NDK");
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// We can use Model or ModelMap instead of the ModelAndView. It is based on the
	// choice of the developer and project
	// ModelMap uses linked hash map and stores values in map format
	@RequestMapping("add")
	public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
		int sum = num1 + num2;
		model.addAttribute("sum", sum);
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("result");
		// mv.addObject("sum", sum);
		return "result";
	}

	// We can use model attribute instead of request params to get whatever data the user sends as a particular class object.
	// It also automatically assigns the model. If different names are used in model and view then we can mention that name in the model attribute annotation.
	// We can also just simply mention the class without using the model attribute annotation if both the model and view data names are same
	@PostMapping("addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee) {

		employeeDao.addEmployee(employee);
		
		return "EmployeeDetails";
	}
	
	@GetMapping("getEmployees")
	public String getEmployee(Model model) {
		
		model.addAttribute("employee", employeeDao.getEmployees());
		
		return "EmployeeDetails";
	}
	
	@GetMapping("getEmployee")
	public String getEmployee(@RequestParam int empId, Model model) {
		
		model.addAttribute("employee", employeeDao.getEmployee(empId));
		
		return "EmployeeDetails";
	}
	
	/*
	 * @RequestMapping("add") public String add(HttpServletRequest req) { int num1 =
	 * Integer.parseInt(req.getParameter("num1")); int num2 =
	 * Integer.parseInt(req.getParameter("num2")); int num3 = num1 + num2;
	 * HttpSession session = req.getSession(); session.setAttribute("num3", num3);
	 * 
	 * return "result.jsp"; }
	 */

	// The above code can be minimized to the following one using request parameters
	/*
	 * @RequestMapping("add") public ModelAndView add(@RequestParam("num1") int
	 * num1, @RequestParam("num2") int num2) { int sum = num1 + num2; ModelAndView
	 * mv = new ModelAndView(); mv.setViewName("result"); mv.addObject("sum", sum);
	 * return mv; }
	 */
}
