package com.tubmc.commons.identifiers.exceptions;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import com.tubmc.commons.identifiers.Path;

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
 * Thrown by a {@link Path} when the passed {@link String} form is invalid/does not meet the requirements set out by {@link Path#PATH_PATTERN}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public final class InvalidPathException extends RuntimeException {
	
	private static final long serialVersionUID = 3335051649265295502L;
	
	@Internal
	public InvalidPathException(@NotNull final Path path) {
		super("The provided path \"" + path.asString() + "\" does not meet the regex expected: " + path.getRegex().pattern());
	}
	
	@Internal
	public InvalidPathException(@NotNull final NullPointerException cause) {
		super("The provided path was null!", cause);
	}
	
	@Internal
	public InvalidPathException(@NotNull final Throwable cause) {
		super("The provided path caused an exception!", cause);
	}
	
}
