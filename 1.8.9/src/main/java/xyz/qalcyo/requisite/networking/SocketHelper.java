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

package xyz.qalcyo.requisite.networking;

import net.minecraft.client.Minecraft;
import xyz.qalcyo.requisite.Requisite;
import xyz.qalcyo.requisite.util.ChatHelper;
import xyz.qalcyo.requisite.core.networking.ISocketHelper;

import java.util.UUID;

public class SocketHelper implements ISocketHelper {

    public UUID getUuid() {
        return Minecraft.getMinecraft().getSession().getProfile().getId();
    }

    public String getName() {
        return Minecraft.getMinecraft().getSession().getUsername();
    }

    public void chat(String message) {
        ChatHelper chatHelper = Requisite.getInstance().getChatHelper();
        if (chatHelper != null) {
            chatHelper.send(message);
        }
    }

}