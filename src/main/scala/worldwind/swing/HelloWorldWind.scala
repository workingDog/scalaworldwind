package scala.worldwind.swing

import java.awt.Dimension
import gov.nasa.worldwind.{BasicModel, Configuration}

/**
 * Author: Ringo Wathelet
 * Date: 18/11/2013 
 * Version: 1
 */

/**
 * basic test of a JFrame showing a wwj window for java 7 swing
 */
object HelloWorldWind extends javax.swing.JFrame {

  def main(args: Array[String]) {

    if (Configuration.isMacOS) {
      System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Hello World Wind")
    }

    java.awt.EventQueue.invokeLater(new Runnable {
      def run {
        val appPanel = WWswingPanel(new Dimension(1000, 800), true)
        appPanel.getWwd.setModel(new BasicModel)
        getContentPane.add(appPanel, java.awt.BorderLayout.CENTER)
        pack
        setVisible(true)
      }
    })

  }
}
