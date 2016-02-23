package prv.zielony.proper

import prv.zielony.proper.model.Bundle
import prv.zielony.proper.path.classpath
import prv.zielony.proper.utils.load

/**
 * Created by zielony on 21.02.16.
 */
package object default {
  implicit val applicationProperties:Bundle = load(classpath:/"application.properties")
}
