package com.sandeep.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="RegistrationMicroservice", url = "http://localhost:1202")
public interface RegistrationClient {
	 @GetMapping("/allUser")
	    String getAllUser();
}
