package prv.zielony.proper.converters

import org.junit.runner.RunWith
import org.scalacheck.Prop
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.{Checkers, PropertyChecks}
import prv.zielony.proper.model.PropertyResult

import prv.zielony.proper.converters.auto._

/**
 * Created by zielony on 22.02.16.
 */
@RunWith(classOf[JUnitRunner])
class AutoConvertersTest extends FunSuite with PropertyChecks with Checkers  {

  test("Should convert a Boolean correctly") {
    check(Prop.forAll{ input:Boolean =>

      val result:Boolean = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert an Int correctly") {
    check(Prop.forAll{ input:Int =>

      val result:Int = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert a Long correctly") {
    check(Prop.forAll{ input:Long =>

      val result:Long = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert a Float correctly") {
    check(Prop.forAll{ input:Float =>

      val result:Float = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert a Double correctly") {
    check(Prop.forAll{ input:Double =>

      val result:Double = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert a Byte correctly") {
    check(Prop.forAll{ input:Byte =>

      val result:Byte = new PropertyResult(input.toString);
      result == input
    })
  }

  test("Should convert a Short correctly") {
    check(Prop.forAll{ input:Short =>

      val result:Short = new PropertyResult(input.toString);
      result == input
    })
  }
}