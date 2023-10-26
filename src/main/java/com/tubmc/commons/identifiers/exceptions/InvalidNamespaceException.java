package com.tubmc.commons.identifiers.exceptions;

import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;

import com.tubmc.commons.identifiers.Namespace;

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
 * Thrown by a {@link Namespace} when the passed {@link String} form is invalid/does not meet the requirements set out by {@link Namespace#NAMESPACE_PATTERN}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public final class InvalidNamespaceException extends RuntimeException {

	private static final long serialVersionUID = 539522506188625169L;
	
	@Internal
	public InvalidNamespaceException(@NotNull Namespace namespace) {
		super("The provided namespace \"" + namespace.asString() + "\" does not meet the regex expected: " + namespace.getRegex().pattern());
	}
	
	@Internal
	public InvalidNamespaceException(NullPointerException cause) {
		super("The provided namespace was null!", cause);
	}
	
	@Internal
	public InvalidNamespaceException(Throwable cause) {
		super("The provided namespace caused an exception!", cause);
	}
	
}
