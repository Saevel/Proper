package prv.zielony.proper.path

/**
 * Created by zielony on 22.02.16.
 */

trait Path {

  val root:PathRoot;

  val segments:Traversable[String]

  def / (rest:String):Path = {
    //TODO: Parse rest

    val self = this;

    new Path {
      override val root: PathRoot = self.root
      override val segments: Traversable[String] = self.segments ++ rest.split("/")
    }
  }

  def / (path:Path):Path = {
    val self = this;

    new Path {
      override val root: PathRoot = self.root
      override val segments: Traversable[String] = self.segments ++ path.segments
    }
  }
}