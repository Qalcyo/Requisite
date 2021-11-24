/*
 * Crimson - The ultimate Minecraft library mod
 * Copyright (C) 2021 Qalcyo
 *
 * Crimson is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * Crimson is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Crimson. If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.qalcyo.crimson.transformers.hooks.impl

import gg.essential.elementa.dsl.*
import net.minecraft.client.gui.GuiMainMenu
import xyz.qalcyo.crimson.Crimson
import xyz.qalcyo.crimson.core.transformers.hooks.GuiMixinHook
import xyz.qalcyo.crimson.core.gui.components.InteractableText

class GuiMainMenuHook(
    instance: GuiMainMenu
) : GuiMixinHook<GuiMainMenu>(
    instance
) {
    init {
        val brandingText = InteractableText("${Crimson.getInstance().name()} v${Crimson.getInstance().version()}", true, InteractableText.Alignment.RIGHT, {
            Crimson.getInstance().openCrimsonMenu()
        }).constrain {
            x = 2.pixels(true)
            y = 11.pixels(true)
        } childOf window
    }
}