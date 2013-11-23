package scala.worldwind

import gov.nasa.worldwind.{Configuration, BasicModel}
import java.awt.Dimension

/**
 * Author: Ringo Wathelet
 * Date: 18/11/2013 
 * Version: 1
 */
object HelloWorldWind extends javax.swing.JFrame {

  def main(args: Array[String]) {

    if (Configuration.isMacOS) {
      System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Hello World Wind")
    }

    java.awt.EventQueue.invokeLater(new Runnable {
      def run {
        val appPanel = AppPanel(new Dimension(1000, 800), true)
        appPanel.getWwd.setModel(new BasicModel)
        getContentPane.add(appPanel, java.awt.BorderLayout.CENTER)
        pack
        setVisible(true)
      }
    })

  }
}
