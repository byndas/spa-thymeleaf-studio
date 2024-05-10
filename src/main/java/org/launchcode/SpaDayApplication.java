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
TODO:
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