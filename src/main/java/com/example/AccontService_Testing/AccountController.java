package com.example.AccontService_Testing;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccontService_Testing.Account;
import com.example.AccontService_Testing.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accService;

	@GetMapping("/getAccounts")
	public List<Account> getAccount() {
		return accService.getAccounts();
		
	}
	
	@PostMapping("/save")
	public String saveAccount(@RequestBody Account a) {
		return accService.saveAccount(a);
	}
	
	@PutMapping("/update")
	public String updateAcc(@RequestParam Integer id,  @RequestBody Account a) {
		return accService.updateAccount(id,a);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAcc(@PathVariable int id) {
		return accService.deleteAccoount(id);
	}
	
//	@GetMapping("/wipro")
//	public String invokeRest() {
//		return accService.implementRestTemp();
//	}
	
	@GetMapping("/wish")
	public String wish() {
		return "Good Morning from wipro";
	}
	
	@GetMapping("/greet")
	public String greet() {
		return accService.print();
	}
	
}