package xyz.matthewtgm.requisite.gui

import gg.essential.elementa.WindowScreen
import gg.essential.elementa.dsl.*
import gg.essential.universal.GuiScale
import net.minecraft.client.Minecraft
import xyz.matthewtgm.requisite.Requisite
import xyz.matthewtgm.requisite.gui.wrapper.RequisiteWindow

class RequisiteMenu : WindowScreen(
    drawDefaultBackground = false,
    restoreCurrentGuiOnClose = true,
    newGuiScale = GuiScale.scaleForScreenSize().ordinal
) {
    init {
        val window = RequisiteWindow(Requisite.getInstance(), window, {
            restorePreviousScreen()
        }).constrain {
            width = 100.percent()
            height = 100.percent()
        } childOf this.window

        val menu = RequisiteMenuWindow(window, {

        }, {
            displayScreen(RequisiteHudMenu())
        }, {

        }).constrain {
            width = 100.percent()
            height = 100.percent()
        } childOf window
    }

    override fun setWorldAndResolution(mc: Minecraft?, width: Int, height: Int) {
        newGuiScale = GuiScale.scaleForScreenSize().ordinal
        super.setWorldAndResolution(mc, width, height)
    }
}
