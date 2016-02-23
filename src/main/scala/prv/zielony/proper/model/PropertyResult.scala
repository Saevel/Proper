package prv.zielony.proper.model

import java.io.{IOException, FileNotFoundException}
import java.util.MissingResourceException

import prv.zielony.proper.exceptions.{PropertyExceptionType, PropertyException}

/**
 * Created by zielony on 21.02.16.
 */
class PropertyResult[T](content: => T) {

  def value:T = content

  def ?():Option[T] = {

    try {
      val evaluator = value
      Option(evaluator)
    }
    catch {
      case _ => None
    }
  }

  def either:Either[PropertyException, T] = {

    try {
      val evaluator = value;
      Right(evaluator)
    }
    catch {

      case mre:MissingResourceException =>
        Left(PropertyException(mre.getMessage, PropertyExceptionType.PropertyNotFound))

      case fileNotFound:FileNotFoundException =>
        Left(PropertyException(fileNotFound.getMessage, PropertyExceptionType.BundleNotFound))

      case nfe:NumberFormatException =>
        Left(PropertyException(nfe.getMessage, PropertyExceptionType.ConversionError))

      case io:IOException =>
        Left(PropertyException(io.getMessage, PropertyExceptionType.IncorrectBundleFormat))

      case _ =>
        Left(PropertyException(null, PropertyExceptionType.Unknown))
    }
  }

  def map[B](f:(T => B)) = {
    new PropertyResult[B](f(value))
  }

  def flatMap[B](f:(T => PropertyResult[B])) = {
    f(value)
  }
}