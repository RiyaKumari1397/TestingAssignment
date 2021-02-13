package com.knoldus


import org.scalatest.flatspec.AnyFlatSpec

class EmailTest extends AnyFlatSpec
{
"email" should "hava alphanumeric username in lowercase and uppercase" in {
    var result: Boolean = Email.isValidEmail("riya.k@knoldus.com")
    assert(result==true)
}

"email" should "valid when with starting numbers" in {
    var result: Boolean = Email.isValidEmail("82riya@knoldus.com")
    assert(result == true)
  }
  "email" should "valid when recipient name has dot and underscore" in {
    var result: Boolean = Email.isValidEmail("1.riya-verma@knoldus.com")
    assert(result == true)
  }

  "email" should "invalid with missing @" in {
    var result: Boolean = Email.isValidEmail("riyaknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {
    var result: Boolean = Email.isValidEmail("*/riya@knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with space in between" in {
    var result: Boolean = Email.isValidEmail("riya @knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with missing top level domain" in {
    var result: Boolean = Email.isValidEmail("riya@gmail")
    assert(result == false)
  }

  "email" should "invalid with missing main domain" in {
    var result: Boolean = Email.isValidEmail("riya@.com")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {
    var result: Boolean = Email.isValidEmail("riya@gdgu.cgf")
    assert(result == false)
  }

  "email" should "invalid with more than one top level domain" in {
    var result: Boolean = Email.isValidEmail("riya@knoldus.com.net")
    assert(result == false)
  }

  "email" should "invalid with double dots after domain name" in {
    var result: Boolean = Email.isValidEmail("riya@knoldus..com")
    assert(result == false)
  }
}
