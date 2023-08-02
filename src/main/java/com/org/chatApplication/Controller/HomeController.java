package com.org.chatApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.chatApplication.Entity.userInfo;
import com.org.chatApplication.Service.userService;
@Controller
@ComponentScan("com.org.chatApplication")
public class HomeController 
{
	@Autowired
    private userService service;

	
	
	
	 @RequestMapping(value = "/help")
	    public String showHelpPage()
	    {
	        return "help"; 
	    }
	
    @RequestMapping(value = "/chatHomePage")
    public String showHomePage() 
    {
        return "chatHomePage";
    }
 
    @RequestMapping(value = "/signup")
    public String showSignUpForm() 
    {
        return "signup";
    }
    @PostMapping("/adduser")
    public String addUser(@RequestParam("FirstName") String firstName,
                          @RequestParam("LastName") String lastName,
                          @RequestParam("Email") String email,
                          @RequestParam("password") String password,
                          Model model) {
        // Create an instance of the entity class and set its properties
        userInfo userinfo = new userInfo();
        userinfo.setFirstName(firstName);
        userinfo.setLastName(lastName);
        userinfo.setEmail(email);
        userinfo.setPassword(password);
        try 
        {
            // Save the user information into the database using the userService
            service.saveuser(userinfo);

            return "redirect:/chatHomePage"; // Redirect to the game page after successful signup
        } catch (Exception e) {
            // In case of any error, handle it here
            model.addAttribute("errorMessage", "An error occurred while signing up. Please try again later.");
            return "SignUp"; // Redirect back to the signUp page with the error message
        }
    }

    @RequestMapping(value = "/login")
	  public String showLoginForm()
	  {
	      return "login"; // Assuming you have a login.html or login.jsp file for the login form
	  }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        // Fetch the user from the database using the provided email
        userInfo user = service.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // If the user is found in the database and the password matches, redirect to the game page
            return "redirect:/chatHomePage";
        } 
        else
        {
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
            return "login"; // Redirect back to the login page with the error message
        }
    }
}