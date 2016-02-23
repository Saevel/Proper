package prv.zielony.proper.inject

import java.util.MissingResourceException

import org.junit.runner.RunWith
import org.scalatest.{GivenWhenThen, ShouldMatchers, FunSpec}
import org.scalatest.junit.JUnitRunner

import prv.zielony.proper.inject._
import prv.zielony.proper.path.classpath
import prv.zielony.proper.utils.load

/**
 * Created by zielony on 22.02.16.
 */
@RunWith(classOf[JUnitRunner])
class InjectionTest extends FunSpec with ShouldMatchers with GivenWhenThen {

  implicit val defaultBundle = load(classpath:/"sample.properties")

  describe("Proper") {
    it("should inject existing properties from the default bundle") {

      val username:String = %("user.name")

      username should not be (null)
      username should be ("Kamil")
    }

    it("should not inject for nonexistent property from default bundle") {

      intercept[MissingResourceException] {
        val nonexistent:String = %("non.existent.property")
      }
    }

    it("should inject from a given bundle") {

      val otherBundle = load(classpath:/"application.properties")
      val username:String = %("user.name" @@ otherBundle )

      username should not be (null)
      username should be ("Kamil")
    }

    it("should not inject if there is no such key in a given bundle") {

      val otherBundle = load(classpath:/"application.properties")

      intercept[MissingResourceException] {
        val evaluator:String = %("key.value" @@ otherBundle)
      }
    }
  }
}
