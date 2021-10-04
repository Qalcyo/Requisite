/*
 * Requisite - Minecraft library mod
 *  Copyright (C) 2021 Qalcyo
 *
 * Requisite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * Requisite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Requisite. If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.qalcyo.requisite.gui.screens

import gg.essential.elementa.WindowScreen
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import xyz.qalcyo.requisite.Requisite
import xyz.qalcyo.requisite.gui.components.Button
import xyz.qalcyo.requisite.gui.components.builders.ButtonBuilder

class TestMenu : WindowScreen() {

    init {
        val button = ButtonBuilder({
            val toggle = toggle()
            Requisite.getInstance().chatHelper.send("Toggled button to - $toggle")
        }, "Test button").build(Requisite.getInstance().componentFactory).constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            width = Button.DEFAULT_WIDTH_PIXELS
            height = Button.DEFAULT_HEIGHT_PIXELS
        } childOf window

        val reset = ButtonBuilder({
            (button as Button).setToggled(true)
        }, "Reset test button").build(Requisite.getInstance().componentFactory).constrain {
            x = CenterConstraint()
            y = SiblingConstraint()
            width = Button.DEFAULT_WIDTH_PIXELS
            height = Button.DEFAULT_HEIGHT_PIXELS
        } childOf window
    }

}