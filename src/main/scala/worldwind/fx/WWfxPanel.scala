package scala.worldwind.fx

import java.awt.Dimension
import scalafx.embed.swing.SwingNode
import gov.nasa.worldwind.avlist.AVKey
import gov.nasa.worldwind.awt.WorldWindowGLJPanel
import gov.nasa.worldwind.event.SelectEvent
import gov.nasa.worldwind.layers.{LayerList, WorldMapLayer}
import gov.nasa.worldwind.{Model, WorldWind, WorldWindow}
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener
import gov.nasa.worldwindx.examples.util.{HighlightController, ToolTipController}

/**
 * Author: Ringo Wathelet
 * Date: 18/03/2015
 * Version: 1
 */

/**
 * for java 8 and scalafx8
 */
object WWfxPanel {

  def apply(swingNode: SwingNode, canvasSize: Dimension) = new WWfxPanel(swingNode, canvasSize)

}

/**
 * a wwj WorldWindow (WorldWindowGLJPanel)
 *
 * @param swingNode to embed a Swing content into a JavaFX application
 * @param canvasSize just the size of the "canvas"
 */
class WWfxPanel(swingNode: SwingNode, canvasSize: Dimension) {

  val wwd = new WorldWindowGLJPanel()
  wwd.setPreferredSize(canvasSize)

  swingNode.setContent(wwd)

  val m: Model = WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME).asInstanceOf[Model]
  wwd.setModel(m)
  wwd.addSelectListener(new ClickAndGoSelectListener(getWwd, classOf[WorldMapLayer]))

  val toolTipController = new ToolTipController(getWwd, AVKey.DISPLAY_NAME, null)

  val highlightController = new HighlightController(getWwd, SelectEvent.ROLLOVER)

  val layerList: LayerList = wwd.getModel.getLayers

  def getWwd: WorldWindow = wwd

}