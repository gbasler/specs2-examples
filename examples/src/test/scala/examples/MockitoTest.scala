package examples

class MockitoTest extends BaseSpecification {

  "simple" should {

    "stub" in {
      val m = mock[java.util.List[String]] // a concrete class would be mocked with: mock[new java.util.LinkedList[String]]
      m.get(0) returns "one" // stub a method call with a return value
      m.get(0) must_== "one" // call the method
    }

    "verify" in {
      val m = mock[java.util.List[String]] // a concrete class would be mocked with: mock[new java.util.LinkedList[String]]
      m.get(0) returns "one" // stub a method call with a return value
      m.get(0) // call the method
      there was one(m).get(0) // verify that the call happened
    }

    "verify2" in {
      val m = mock[java.util.List[String]] // a concrete class would be mocked with: mock[new java.util.LinkedList[String]]
      there was no(m).get(0) // verify that the call never happened
    }
  }
}
