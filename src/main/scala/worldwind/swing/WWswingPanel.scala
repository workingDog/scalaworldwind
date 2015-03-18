package scala.worldwind.swing

import java.awt.{BorderLayout, Component, Dimension}
import javax.swing.JPanel
import gov.nasa.worldwind.avlist.AVKey
import gov.nasa.worldwind.awt.WorldWindowGLCanvas
import gov.nasa.worldwind.event.SelectEvent
import gov.nasa.worldwind.layers.{LayerList, WorldMapLayer}
import gov.nasa.worldwind.util.StatusBar
import gov.nasa.worldwind.{Model, WorldWind, WorldWindow}
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener
import gov.nasa.worldwindx.examples.util.{HighlightController, ToolTipController}


/**
 * Author: Ringo Wathelet
 * Date: 18/11/2013 
 * Version: 1
 */

object WWswingPanel {

  def apply(canvasSize: Dimension, includeStatusBar: Boolean) = new WWswingPanel(canvasSize, includeStatusBar)

}

/**
 * a wwj WorldWindow (WorldWindowGLCanvas)
 *
 * @param canvasSize just the size of the "canvas"
 * @param includeStatusBar true to include a status bar
 */
class WWswingPanel(canvasSize: Dimension, includeStatusBar: Boolean) extends JPanel {

  super.setLayout(new BorderLayout())

  val wwd: WorldWindowGLCanvas = new WorldWindowGLCanvas
  wwd.setPreferredSize(canvasSize)
  val m: Model = WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME).asInstanceOf[Model]
  wwd.setModel(m)
  wwd.addSelectListener(new ClickAndGoSelectListener(getWwd, classOf[WorldMapLayer]))
  add(wwd.asInstanceOf[Component], BorderLayout.CENTER)

  val statusBar = if (includeStatusBar) new StatusBar else null
  if (statusBar != null) {
    statusBar.setEventSource(wwd)
    add(statusBar, BorderLayout.PAGE_END)
  }

  val toolTipController = new ToolTipController(getWwd, AVKey.DISPLAY_NAME, null)

  val highlightController = new HighlightController(getWwd, SelectEvent.ROLLOVER)

  val layerList: LayerList = wwd.getModel.getLayers

  def getWwd: WorldWindow = wwd

  def getStatusBar = statusBar

}
