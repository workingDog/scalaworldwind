package scala.worldwind.fx

import java.awt.Dimension
import javax.swing.SwingUtilities
import gov.nasa.worldwind.BasicModel
import gov.nasa.worldwind.layers.Earth.OSMMapnikLayer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.embed.swing.SwingNode
import scalafx.scene.Scene
import scalafx.scene.layout.StackPane

/**
 * Author: Ringo Wathelet
 * Date: 18/03/2015
 * Version: 1
 */

/**
 * basic test of a scalaFX stage showing a wwj window for java 8 and scalafx8
 */
object FXHelloWorldWind extends JFXApp {

  val ws = new Dimension(1000, 800)
  val swingNode = new SwingNode()
  val root = new StackPane()
  root.getChildren.add(swingNode)

  stage = new PrimaryStage {
    title = "ScalaFX Hello World"
    width = ws.width
    height = ws.height
    scene = new Scene(root, ws.width, ws.height)
  }
  stage.show()

  SwingUtilities.invokeLater(new Runnable {
    def run() {
      val fxPanel = WWfxPanel(swingNode, ws)
      fxPanel.getWwd.setModel(new BasicModel)
    //  fxPanel.getWwd.getModel.getLayers.add(new OSMMapnikLayer())
    }
  })

}