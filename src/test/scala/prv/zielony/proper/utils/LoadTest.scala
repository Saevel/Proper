package prv.zielony.proper.utils

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner
import prv.zielony.proper.model.Bundle
import prv.zielony.proper.path.classpath

/**
 * Created by zielony on 22.02.16.
 */
@RunWith(classOf[JUnitRunner])
class LoadTest extends FunSpec with ShouldMatchers with GivenWhenThen {

  describe("loader") {
    it("should load an existing classpath bundle") {
      load(classpath:/"sample.properties") should not be (null)
    }

    it("should not load a non-existent classpath bundle") {
      intercept[Exception] {
        load(classpath:/"abc.properties")
      }
    }

    it("should load classpath bundle from a complex location") {
      load(classpath:/"sample/sample.properties") should not be (null)
    }

    it("should load the default bundle on default._ import") {

      def checkImplicit()(implicit bundle:Bundle) = {
        bundle should not be (null)
      }

      import prv.zielony.proper.default._

      checkImplicit()
    }
  }
}
