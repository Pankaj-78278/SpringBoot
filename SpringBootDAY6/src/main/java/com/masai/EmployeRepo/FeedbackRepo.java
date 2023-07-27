package com.masai.EmployeRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.Feedback;


@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	
}
//	public List<Feedback> findByAddress(String address);
//	
//	@Query("select e.empName,e.address from Employee e where e.empId =?1")
//	public String findNameById(Integer empId);
//	
//	@Query("select new com.masai.model.EmployeeDTO(e.empName,e.address,e.salary) from Employee e where e.empId =?1")
//	public List<EmployeeDTO> findByNameAdress(Integer empId);
//	
//	
//	@Query("select new com.masai.model.EmployeeDTO(e.empName,e.address,e.salary) from Employee e")
//	public List<EmployeeDTO> getNameAddressSalary();
//	

