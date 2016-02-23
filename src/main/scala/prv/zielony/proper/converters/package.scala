package prv.zielony.proper

import prv.zielony.proper.exceptions.PropertyException
import prv.zielony.proper.model.PropertyResult

/**
 * Created by zielony on 21.02.16.
 */
package object converters {

  /**
   * A set of automatic type conversion for PropertyResult
   */
  object auto {

    implicit def autoBoolean(input:PropertyResult[String]):Boolean = {
      input map (_.toBoolean) value
    }

    implicit def autoInt(input:PropertyResult[String]):Int = {
      input map (_.toInt) value
    }

    implicit def autoLong(input:PropertyResult[String]):Long = {
      input map (_.toLong) value
    }

    implicit def autoFloat(input:PropertyResult[String]):Float = {
      input map (_.toFloat) value
    }

    implicit def autoDouble(input:PropertyResult[String]):Double = {
      input map (_.toDouble) value
    }

    implicit def autoByte(input:PropertyResult[String]):Byte = {
      input map (_.toByte) value
    }

    implicit def autoShort(input:PropertyResult[String]):Short = {
      input map (_.toShort) value
    }

    implicit def autoBooleanOption(input:PropertyResult[String]):Option[Boolean] = {
      (input ?) map(_.toBoolean)
    }

    implicit def autoIntOption(input:PropertyResult[String]):Option[Int] = {
      (input ?) map(_.toInt)
    }

    implicit def autoLongOption(input:PropertyResult[String]):Option[Long] = {
      (input ?) map(_.toLong)
    }

    implicit def autoFloatOption(input:PropertyResult[String]):Option[Float] = {
      (input ?) map(_.toFloat)
    }

    implicit def autoDoubleOption(input:PropertyResult[String]):Option[Double] = {
      (input ?) map (_.toDouble)
    }

    implicit def autoByteOption(input:PropertyResult[String]):Option[Byte] = {
      (input ?) map (_.toByte)
    }

    implicit def autoShortOption(input:PropertyResult[String]):Option[Short] = {
      (input ?) map (_.toShort)
    }

    implicit def autoBooleanEither(input:PropertyResult[String]):Either[PropertyException, Boolean] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toBoolean)})
    }

    implicit def autoIntEither(input:PropertyResult[String]):Either[PropertyException, Int] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toInt)})
    }

    implicit def autoLongEither(input:PropertyResult[String]):Either[PropertyException, Long] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toLong)})
    }

    implicit def autoFloatEither(input:PropertyResult[String]):Either[PropertyException, Float] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toFloat)})
    }

    implicit def autoDoubleEither(input:PropertyResult[String]):Either[PropertyException, Double] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toDouble)})
    }

    implicit def autoByteEither(input:PropertyResult[String]):Either[PropertyException, Byte] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toByte)})
    }

    implicit def autoShortEither(input:PropertyResult[String]):Either[PropertyException, Short] = {
      input.either.fold({left => Left(left)}, {right => Right(right.toShort)})
    }
  }
}