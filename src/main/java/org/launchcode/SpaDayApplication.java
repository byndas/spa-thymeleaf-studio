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
remove name field from service selection form
use given user’s name to identify spa client
move data into Client model from SpaDayController

write another model called User
	so that non-Client user can log in

in spa-day, create:

	UserController file in "org.launchcode.spaday.controllers"
			add @Controller & @RequestMapping("user")
	user folder in "resources/templates"
	index.html & add.html in "resources/templates/user"
	User class in "org.launchcode.spaday.models"

create Model:
	User class needs some private fields
			with getters & setters: username, email, password

render Add-User-Form:
	in UserController, create handler method displayAddUserForm() to render form
			corresponding to "/user/add" path & for now, returns path to "add.html"

add "/user/add" to path when testing new features

in add.html, create form accepting inputs for each User class property
		add password input field to verify password input
		  form POST request to "/user"

set type="password" for password & verify inputs
set type="email" on email input to enable basic client-side validation

Processing Form Submission
in UserController, create handler method:

	public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {}

	uses model binding to create new user object, passed into handler method


don't store User object anywhere
focus on form handling & validation

verify parameter must match password in user object
	if so, render user/index.html with a welcome username message
		else, re-render form

Refining Form Submission:
	once user registered, let user select from spa services form

	in user/index.html, add th:href element
		to return user to "/" app root path
	    where serviceSelection template renders

	if form re-rendered when password not verified,
		inform user that form not submitted
		  use model.addAttribute to add an error attribute
		    informing user that passwords must match
		      model attribute must correspond to element in template
		        that only renders error text when passwords not match

	if user returns to re-submit form, display their previous input values

	in form submission handler,
	add submitted username & email fields as model attributes

	in form, add value attribute to form fields equal to model attributes

/////////////////////////////////////////////////////////////////////

Bonus!

add id field to User & accessor methods (with appropriate access level)

create UserData class in "org.launchcode.spaday.data"
	providing access to users list via add(), getAll(), getById()

in user/index.html, display list of all users by username
  each username needs link to detail page listing user’s username & email

add Date field in User & initialize to when user joined
	--> when User object created
	   display this property value in user detail html page
*/