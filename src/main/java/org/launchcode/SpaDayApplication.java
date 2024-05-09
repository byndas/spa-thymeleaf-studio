package org.launchcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpaDayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpaDayApplication.class, args);
	}
}

/*
TODO CREATE:
  User.java in models package --> done
  UserController file in "org.launchcode.controllers"
			add @Controller & @RequestMapping("user")
	user folder in "resources/templates"
	index.html & add.html in "resources/templates/user"
	User class in "org.launchcode.models"
		needs username, email, password private fields with getters & setters
  ////////////////////////////////////////////////////////////////////////
	Render Add-User-Form:
		in UserController,
			create handler method displayAddUserForm()
		    to render form corresponding to "/user/add" path
					returning path to "add.html"
			add "/user/add" to path when testing new features
  ////////////////////////////////////////////////////////////////////////
		in add.html,
			create form accepting inputs for each User class property
			add password input field to verify password
			POST input form request to "/user"
	////////////////////////////////////////////////////////////////////////
	set type="password" for password & verify inputs
	set type="email" on email input to enable basic client-side validation
  ///////////////////////////////////////////////////////////////////////
	Processing Form Submission
		in UserController,
			create handler method:
				public String processAddUserForm(
					Model model,
					@ModelAttribute User user,
					String verify
				) {}
  ////////////////////////////////////////////////////////////////////////
		create user object using model binding
			pass it to handler method above
  ////////////////////////////////////////////////////////////////////////
	no need to store User object anywhere
	focus on form handling & validation
  ////////////////////////////////////////////////////////////////////////
  verify parameter matches password in user object
		if so, render "user/index.html" with welcome username message
		else, re-render form
  ////////////////////////////////////////////////////////////////////////
	Refining Form Submission:
		once user registered, let user select from "index" spa services form
  ////////////////////////////////////////////////////////////////////////
	in user/index.html,
		add th:href element
			to return user to "/" app root path
	      where serviceSelection template renders
  ////////////////////////////////////////////////////////////////////////
	if form re-renders without password verification:
		inform user that form not submitted
		use model.addAttribute to add error attribute
		informing user that passwords must match
		model attribute must correspond to element in template
		only render error text when passwords not match
  ////////////////////////////////////////////////////////////////////////
	if user returns to re-submit form, display their previous input values
  ////////////////////////////////////////////////////////////////////////
	in form submission handler,
		add submitted username & email fields as model attributes
  ////////////////////////////////////////////////////////////////////////
	in form, add value attribute to form fields equal to model attributes
  ////////////////////////////////////////////////////////////////////////
  ========================================================================
  ////////////////////////////////////////////////////////////////////////
	BONUS:
		add id field to User & accessor methods (with appropriate access level)
  ////////////////////////////////////////////////////////////////////////
	create UserData class in "org.launchcode.data"
		providing access to users list via add(), getAll(), getById()
  ////////////////////////////////////////////////////////////////////////
  in user/index.html, display list of all users by username
    each username needs link to detail page listing user’s username & email
  ////////////////////////////////////////////////////////////////////////
  add Date field in User & initialize to when user joined
		when User object created
			display that Data value in user detail html page
*/