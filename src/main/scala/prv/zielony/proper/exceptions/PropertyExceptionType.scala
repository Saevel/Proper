package prv.zielony.proper.exceptions

/**
 * Created by zielony on 22.02.16.
 */
sealed trait PropertyExceptionType {
  val name:String;
}

object PropertyExceptionType {

  case object Unknown extends PropertyExceptionType {
    override val name: String = "Unknown"
  }

  case object ConversionError extends PropertyExceptionType {
    override val name: String = "Conversion error"
  }

  case object BundleNotFound extends PropertyExceptionType {
    override val name: String = "Bundle not found"
  }

  case object PropertyNotFound extends PropertyExceptionType {
    override val name: String = "Property not found"
  }

  case object IncorrectBundleFormat extends PropertyExceptionType {
    override val name: String = "Incorrect bundle format"
  }
}

