package showcase.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import showcase.codegym.model.Employee;

import javax.xml.ws.BindingProvider;

@Controller
//@RequestMapping("employee/")
public class EmployeeController {
    @RequestMapping(value = "showform", method = RequestMethod.GET)
    public String show(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, ModelMap modelMap) {
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("id", employee.getId());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        return "employee/info";
    }
}
