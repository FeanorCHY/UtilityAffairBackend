package hello;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import hello.Tenant;
import hello.TenantRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
public class TenantController {
	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private TenantRepository tenantRepository;
	
	@CrossOrigin()
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam(required=true) String LastName,
			@RequestParam(required=true)  String FirstName,
			@RequestParam(defaultValue="",required=false)  String email,
			@RequestParam(defaultValue="2017-10-01",required=false)  String start,
			@RequestParam(defaultValue="2017-10-01",required=false)  String end){
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Tenant n = new Tenant(FirstName,LastName,email,start,end);
		tenantRepository.save(n);
		return "Saved";
	}
	
	@CrossOrigin()
	@RequestMapping(path = "/insert" , method = RequestMethod.POST)
	public @ResponseBody String postNewUser (@RequestBody Tenant newTenant){
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

//		Tenant n = new Tenant(FirstName,LastName,email,start,end);
		tenantRepository.save(newTenant);
		System.out.println(newTenant.toString()+" saved");
		return "saved"+ newTenant.toString();
	}
	

	@CrossOrigin()
	@RequestMapping(path = "/update" , method = RequestMethod.PUT)
	public @ResponseBody String updateUser (@RequestBody Tenant tenant){
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

//		Tenant n = new Tenant(FirstName,LastName,email,start,end);
		tenantRepository.save(tenant);
		System.out.println(tenant.toString()+" updated");
		return "saved"+ tenant.toString();
	}
	
	

	@CrossOrigin()
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Tenant> getAllUsers() {
		// This returns a JSON or XML with the users
		return tenantRepository.findAll();
	}
	
	
	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Tenant> deleteUser(@PathVariable("id") long id) {
//		System.out.println("Fetching & Deleting User with id " + id);
//
//		Tenant tenant = tenantRepository.findById(id);
//		if (tenant == null) {
//			System.out.println("Unable to delete. User with id " + id + " not found");
//			return new ResponseEntity<Tenant>(HttpStatus.NOT_FOUND);
//		}
//
//		tenantRepository.deleteUserById(id);
//		return new ResponseEntity<Tenant>(HttpStatus.NO_CONTENT);
//	}

	@CrossOrigin()
	@RequestMapping(path="/delete", method = RequestMethod.DELETE)
	public void deleteUsersById(@RequestParam(required=true) long id) {
		// This returns a JSON or XML with the users
		tenantRepository.delete(id);
	}

}
