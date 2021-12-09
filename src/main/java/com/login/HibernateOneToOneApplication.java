package com.login;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.login.model.Gender;
import com.login.model.User;
import com.login.model.UserProfile;
import com.login.repo.UserProfileRepository;
import com.login.repo.UserRepository;

@SpringBootApplication
public class HibernateOneToOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setName("Vinayak");
		user.setEmail("vinayaknaik4196@gmail.com");

		UserProfile userProfile = new UserProfile();

		userProfile.setAddress("Honavar");
		userProfile.setGender(Gender.male);

		userProfile.setPhoneNumber("12345");
		userProfile.setDob(LocalDate.of(1996, 04, 01));
		
		user.setUserProfile(userProfile);
		
		userProfile.setUser(user);
		
		userRepository.save(user);

	}

}
