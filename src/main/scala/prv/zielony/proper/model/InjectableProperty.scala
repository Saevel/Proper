package prv.zielony.proper.model

/**
 * Created by zielony on 21.02.16.
 */
trait InjectableProperty {

  val name:String;

  def @@(bundle:Bundle):BundledInjectableProperty = {
    BundledInjectableProperty(this, bundle);
  }
}