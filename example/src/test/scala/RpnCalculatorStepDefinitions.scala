

import cucumber.api.Scenario
import cucumber.api.scala.{ScalaDsl, EN}
import org.junit.Assert._

class RpnCalculatorStepDefinitions extends ScalaDslIndirection with EN {

  val calc = new Calculator

  When("""^I add (\d+) and (\d+)$"""){ (arg1: Double, arg2: Double) =>
    calc push arg1
    calc push arg2
    calc push "+"
  }

  Then("^the result is (\\d+)$") { expected: Double =>
    assertEquals(expected, calc.value, 0.001)
  }

  Before("~@foo"){ scenario : Scenario =>
    println("Runs before scenarios *not* tagged with @foo")
  }
}