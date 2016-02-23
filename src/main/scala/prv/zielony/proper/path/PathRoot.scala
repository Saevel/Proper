package prv.zielony.proper.path

/**
 * Created by zielony on 21.02.16.
 */
abstract class PathRoot(val name:String) {

  private val self = this;

  def :/(restOfPath:String):Path = {

    val pathSegments:Traversable[String] =
      if(restOfPath contains "/") {
        restOfPath.split("/")
      }
      else {
        Traversable(restOfPath)
      }

    val self = this;

    new Path {
      override val root: PathRoot = self
      override val segments: Traversable[String] = pathSegments
    }
  }

  def :/(restOfPath:Path):Path = new Path {
    override val root: PathRoot = self
    override val segments: Traversable[String] = restOfPath.segments
  }
}

case object classpath extends PathRoot("classpath")

case object file extends PathRoot("file")