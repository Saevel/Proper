package prv.zielony.proper.converters

import prv.zielony.proper.exceptions.PropertyException
import prv.zielony.proper.model.PropertyResult

/**
 * Created by zielony on 21.02.16.
 */
sealed trait PropertyConverter[T] extends (PropertyResult[String] => T)

object boolean {
  def apply(input: PropertyResult[String]): Boolean =
    input.map (_.toBoolean) value

  def apply(input: Option[String]):Option[Boolean] = {
    input map (_.toBoolean)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Boolean] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toBoolean)})
  }
}

object int  {
  def apply(input: PropertyResult[String]): Int = {
    input.map(_.toInt) value
  }

  def apply(input: Option[String]):Option[Int] = {
    input map (_.toInt)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Int] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toInt)})
  }
}

object long {
  def apply(input: PropertyResult[String]): Long = {
    input.map(_.toLong) value
  }

  def apply(input: Option[String]):Option[Long] = {
    input map (_.toLong)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Long] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toLong)})
  }
}

object float {
  def apply(input: PropertyResult[String]): Float = {
    input.map(_.toFloat) value
  }

  def apply(input: Option[String]):Option[Float] = {
    input map (_.toFloat)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Float] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toFloat)})
  }
}

object double {
  def apply(input: PropertyResult[String]): Double = {
    input.map(_.toDouble) value
  }

  def apply(input: Option[String]):Option[Double] = {
    input map (_.toDouble)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Double] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toDouble)})
  }
}

object byte {
  def apply(input: PropertyResult[String]): Byte = {
    input.map(_.toByte) value
  }

  def apply(input: Option[String]):Option[Byte] = {
    input map (_.toByte)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Byte] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toByte)})
  }
}

object short {
  def apply(input: PropertyResult[String]): Short = {
    input.map(_.toShort) value
  }

  def apply(input: Option[String]):Option[Short] = {
    input map (_.toShort)
  }

  def apply(input: Either[PropertyException, String]):Either[PropertyException, Short] = {
    input.fold ({ left => Left(left)}, {right => Right(right.toShort)})
  }
}