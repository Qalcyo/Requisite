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

package xyz.qalcyo.crimson.core.files;

import xyz.qalcyo.crimson.core.CrimsonAPI;

import java.io.File;

public class FileManager {

    private final CrimsonAPI crimson;

    public FileManager(CrimsonAPI crimson) {
        this.crimson = crimson;
    }

    public File getQalcyoDirectory(File launchDirectory) {
        return checkExistence(new File(launchDirectory, "Qalcyo"));
    }

    public File getCrimsonDirectory(File qalcyoDirectory) {
        return checkExistence(new File(qalcyoDirectory, crimson.name()));
    }

    public File getCrimsonConfigDirectory(File crimsonDirectory) {
        return checkExistence(new File(crimsonDirectory, "config"));
    }

    private File checkExistence(File directory) {
        if (!directory.exists() && !directory.mkdirs())
            throw new IllegalStateException("Unable to create Crimson directories.");

        return directory;
    }

}