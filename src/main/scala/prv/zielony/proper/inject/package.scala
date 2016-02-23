package prv.zielony.proper

import prv.zielony.proper.converters.{long, int, boolean}
import prv.zielony.proper.exceptions.PropertyException
import prv.zielony.proper.model.{PropertyResult, BundledInjectableProperty, Bundle, InjectableProperty}
import prv.zielony.proper.path.{PathRoot, classpath}
import prv.zielony.proper.path.Path;
import prv.zielony.proper.utils.load;

/**
 * Created by zielony on 21.02.16.
 */
package object inject {

  implicit def propertyResultToValue[T](result:PropertyResult[T]):T = {
    result.value
  }

  implicit def stringToPath(element:String) = new Path {
    override val root: PathRoot = null
    override val segments: Traversable[String] = Traversable(element)
  }

  implicit def stringToInjectableProperty(property:String):InjectableProperty = {
    new InjectableProperty {
      override val name: String = property
    }
  }

  def % (property:BundledInjectableProperty):PropertyResult[String] = {
    new PropertyResult(property.bundle.apply(property.property.name))
  }

  def % (name:String)(implicit bundle:Bundle):PropertyResult[String] = {
    new PropertyResult(bundle.resourceBundle.getString(name));
  }
}
