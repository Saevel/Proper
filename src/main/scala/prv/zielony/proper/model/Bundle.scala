package prv.zielony.proper.model

import java.util.ResourceBundle

/**
 * Created by zielony on 21.02.16.
 */
trait Bundle {

  val resourceBundle:ResourceBundle;

  def apply(property:String):PropertyResult[String] = {
    new PropertyResult(resourceBundle.getString(property))
  }
}

