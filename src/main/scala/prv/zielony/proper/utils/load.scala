package prv.zielony.proper.utils

/**
 * Created by zielony on 22.02.16.
 */
import java.io.{FileInputStream, File}
import java.util.{PropertyResourceBundle, ResourceBundle}

import prv.zielony.proper.model.Bundle
import prv.zielony.proper.path.Path

object load extends (Path => Bundle) {

  override def apply(path: Path): Bundle = path.root.name match {
    case "classpath" => loadBundleFromClasspath(path)
    case "file" => loadBundleFromFilesystem(path)
    case _ => ???
  }

  private def loadBundleFromClasspath(path:Path):Bundle = {

    val relativePath = path.segments.reduce { (segment1, segment2) =>
      segment1 + File.separator + segment2
    }

    val self = this;

    new Bundle {
      override val resourceBundle: ResourceBundle =
        new PropertyResourceBundle(self.getClass.getClassLoader.getResourceAsStream(relativePath))
    }
  }

  private def loadBundleFromFilesystem(path:Path):Bundle = {

    val fis = new FileInputStream(path.segments.reduce { (segment1, segment2) =>
      segment1 + File.separator + segment2
    })

    new Bundle {
      override val resourceBundle: ResourceBundle = new PropertyResourceBundle(fis)
    }
  }
}