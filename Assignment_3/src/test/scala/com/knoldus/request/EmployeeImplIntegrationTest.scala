package com.knoldus.request
import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeImplIntegrationTest extends AnyFlatSpec {
  val employeeReadDto = new EmployeeReadDto
  val emailValidator = new EmailValidator
  val employeeValidator = new EmployeeValidator(employeeReadDto, emailValidator)
  val employeeImpl = new EmployeeImpl(employeeValidator)



  "Employee" should "exist" in {
    val RiyaEmployee: Employee = Employee("Riya", "Kumari", 22,70000.00,"Software Developer","Knoldus","Riya@knoldus.com")
    val result =  employeeImpl.createEmployee(RiyaEmployee)
    assert(result=="Knoldus")
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: Employee = Employee("Sunidhi","Sharma",30,40000,"Software Trainee","Wipro","sun@wipro.com")
    val result =  employeeImpl.createEmployee(klausEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid" in {
    val RiyaEmployee: Employee = Employee("Riya", "Kumari", 22,70000.00,"Software Developer","Knoldus","Riyacom")
    val result = employeeImpl.createEmployee(RiyaEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid and company does not exists" in {
    val klausEmployee: Employee = Employee("Sunidhi","Sharma",30,40000,"Software Trainee","Wipro","sunidhiwiprocom")
    val result =  employeeImpl.createEmployee(klausEmployee)
    assert(result.isEmpty)
  }
}
