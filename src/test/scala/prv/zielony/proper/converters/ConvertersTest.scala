package prv.zielony.proper.converters

import org.junit.runner.RunWith
import org.scalacheck.Prop
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.{Checkers, PropertyChecks}
import org.scalatest.{FunSuite, FlatSpec, ShouldMatchers, FunSpec}

import prv.zielony.proper.inject._
import prv.zielony.proper.model.PropertyResult
import prv.zielony.proper.path.classpath
import prv.zielony.proper.utils.load


/**
 * Created by zielony on 22.02.16.
 */
@RunWith(classOf[JUnitRunner])
class ConvertersTest extends FunSuite with PropertyChecks with Checkers  {

  test("Should convert a Boolean correctly") {
    check(Prop.forAll{ input:Boolean =>
       boolean(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert an Int correctly") {
    check(Prop.forAll{ input:Int =>
      int(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert a Long correctly") {
    check(Prop.forAll{ input:Long =>
      long(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert a Float correctly") {
    check(Prop.forAll{ input:Float =>
      float(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert a Double correctly") {
    check(Prop.forAll{ input:Double =>
      double(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert a Byte correctly") {
    check(Prop.forAll{ input:Byte =>
      byte(new PropertyResult(input.toString)) == input
    })
  }

  test("Should convert a Short correctly") {
    check(Prop.forAll{ input:Short =>
     short(new PropertyResult(input.toString)) == input
    })
  }
}