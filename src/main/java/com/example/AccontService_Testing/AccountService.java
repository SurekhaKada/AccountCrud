package com.example.AccontService_Testing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.example.AccontService_Testing.Account;
import com.example.AccontService_Testing.AccountRepository;

@Service
public class AccountService {


	String url = "jdbc:mysql://localhost:3306/banking_app";
	String user = "root";
	String pswd = "Surekha@370";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	AccountRepository repo;


	
	public String saveAccount(Account a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pswd);
			String query = "insert into account values (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, a.getId());
			st.setString(2, a.getName());
			st.setString(3, a.getDesc());
			st.executeUpdate();
			st.close();
			con.close();
} catch (Exception e) {

e.printStackTrace();		}
//		
		repo.save(a);
		return "accont saved "+a.getId()+ " "+a.getName()+" "+a.getDesc(); 
		
	}
	
	public List<Account> getAccounts() {
//		List<Account> li = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "select * from account";
//			PreparedStatement st = con.prepareStatement(query);
//			ResultSet rs = st.executeQuery();
//			while(rs.next()) {
//				//System.out.println(rs.getInt(1)+" -> "+rs.getString(2)+" -> "+rs.getString(3));
//				Account acc = new Account();
//				acc.setId(rs.getInt(1));
//				acc.setAccName(rs.getString(2));
//				acc.setAccDesc(rs.getString(3));
//				
//				li.add(acc);
//			}
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return repo.findAll();
	}
	
	public String updateAccount(Integer id, Account a) {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "update account set accountname=?, accountdesc=? where id=?";
//			PreparedStatement st = con.prepareStatement(query);
//			
//			st.setString(1, a.getAccName());
//			st.setString(2, a.getAccDesc());
//			st.setInt(3, a.getId());
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Account a1 = repo.findById(id).get();
		a.setId(id);
		if(a.getName().equals(null)) {
			a.setName(a1.getName());
		}
		if(a.getDesc().equals(null)) {
			a.setDesc(a1.getDesc());
		}
		repo.save(a);
		return "updated successfully "+a.getName()+" -> "+a.getDesc();
	
	}
	
	public String deleteAccoount(int id) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, user, pswd);
//			String query = "delete from account where id = ?";
//			PreparedStatement st = con.prepareStatement(query);
//			st.setInt(1,id);
//			
//			
//			st.executeUpdate();
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		repo.deleteById(id);
		return "deleted successfully";
	}
	
//	public String implementRestTemp() {
//		//RestTemplate rt = new RestTemplate();
//		String body = restTemplate.getForObject("http://localhost:8081/hi", String.class);
//		return body;
//				
//	}
	
	public String print() {
		return "Greetings from Wipro";
	}
}