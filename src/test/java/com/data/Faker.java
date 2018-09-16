package com.data;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.*;

public class Faker {
	
	Fairy fairy;
	
	public Faker(){
		fairy= Fairy.create();
	}
	
	public String getFemaleFirstName(){
		return fairy.person(PersonProperties.female()).getFirstName();
	}
	
	public String getRandomNumber(){
		return fairy.person(PersonProperties.male()).getNationalIdentityCardNumber();
	}
	
	public String getAge(){
		return String.valueOf(  fairy.person(PersonProperties.minAge(14)).getAge()   );
	}
	
	public String getCity(){		
		return fairy.person(PersonProperties.female()).getAddress().getCity();
	}
	
	public String getCityMalePerson(){
		return fairy.person(PersonProperties.male()).getAddress().getCity();
	}

	public String getEmail(){
		return fairy.person().getEmail();
	}

	public String getPhone(){
		return fairy.person().getTelephoneNumber();
	}

	public String getAddress(){
		return fairy.person().getAddress().getAddressLine1();
	}

}
