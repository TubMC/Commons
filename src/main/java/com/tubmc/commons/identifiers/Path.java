package com.tubmc.commons.identifiers;

import java.util.regex.Pattern;

import org.jetbrains.annotations.NotNull;

import com.tubmc.commons.identifiers.exceptions.InvalidPathException;

/**
 *    Copyright 2023 TubMC.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
/**
 * The end part of an {@link Identifier}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public final record Path(@NotNull String path) implements IIdentifierComponent {
	/**
	 * The {@link Pattern} that {@link #path} must match, else a {@link InvalidPathException} is thrown
	 * 
	 * @since 1.0.0
	 */
	public static final @NotNull Pattern PATH_PATTERN = Pattern.compile("[^a-z0-9_.-/]");
	
	public Path(@NotNull String path) {
		if (path == null || path.equals("")) throw new InvalidPathException(new NullPointerException(path));
		this.path = path;
		if (this.isValid()) throw new InvalidPathException(this);
	}
	
	@Override
	public final @NotNull String asString() {
		return this.path;
	}
	
	@Override
	public @NotNull Pattern getRegex() {
		return PATH_PATTERN;
	}
	
	@Override
	public final Path clone() {
		return new Path(this.path);
	}
	
}
