package com.service.loginclient.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.loginclient.model.UserLogin;

@FeignClient(name="UserClientInterface",url="http://127.0.0.1:8084/usuario")
public interface UserClientInterface {

	@GetMapping("/getusertologin/{emailrequest}")
	UserLogin userRequestLogin(@PathVariable("emailrequest") String emailrequest);
	
}
