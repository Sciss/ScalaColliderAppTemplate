/* Published under the GNU GPL v2+, the same as ScalaCollider */

package doe.john.myscalacolliderapp

import javax.imageio.ImageIO
import javax.swing.ImageIcon

import de.sciss.synth._
import ugen._
import Ops._

import scala.swing.event.ValueChanged
import scala.swing.{Alignment, BorderPanel, GridPanel, Slider, Label, MainFrame, Swing, Frame, SimpleSwingApplication}
import Swing._

object MyScalaColliderApp extends SimpleSwingApplication {
  lazy val top: Frame = {
    val lb = new Label("Booting...")
    val sl = new Slider {
      min     = 40
      max     = 130
      value   = 80
      enabled = false
    }
    val grid = new GridPanel(3, 1) {
      contents += lb
      contents += sl
    }
    val image = ImageIO.read(getClass.getResourceAsStream("icon.png"))
    val icon  = new Label(null, new ImageIcon(image), Alignment.Leading)
    val f  = new MainFrame {
      title     = "ScalaCollider"
      contents  = new BorderPanel {
        add(icon, BorderPanel.Position.West)
        add(grid, BorderPanel.Position.Center)
      }
      pack().centerOnScreen()
      open()
    }

    val cfg = Server.Config()
    cfg.pickPort()
    // runs a server and executes the function
    // when the server is booted, with the
    // server as its argument
    Server.run(cfg) { s =>
      val synth = play {
        val p = "pitch".kr(80f)
        val f = LFSaw.kr(0.4).madd(24, LFSaw.kr(Seq(8.0, 7.23)).madd(3, p)).midicps
        CombN.ar(SinOsc.ar(f) * 0.04, 0.2, 0.2, 4)
      }
      onEDT {
        lb.text = "scsynth started."
        sl.listenTo(sl)
        sl.reactions += {
          case ValueChanged(_) => synth.set("pitch" -> sl.value)
        }
        sl.enabled = true
      }
    }

    f
  }
}