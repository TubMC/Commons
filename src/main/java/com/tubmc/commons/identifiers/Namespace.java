package com.tubmc.commons.identifiers;

import java.util.regex.Pattern;

import org.jetbrains.annotations.NotNull;

import com.tubmc.commons.identifiers.exceptions.InvalidNamespaceException;
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
 * The start part of an {@link Identifier}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public final record Namespace(@NotNull String namespace) implements IIdentifierComponent {
	/**
	 * The {@link Pattern} that {@link #namespace} must match, else a {@link InvalidNamespaceException} is thrown
	 * 
	 * @since 1.0.0
	 */
	public static final @NotNull Pattern NAMESPACE_PATTERN = Pattern.compile("[^a-z0-9_.-]");
	
	public Namespace(@NotNull String namespace) {
		if (namespace == null || namespace.equals("")) throw new InvalidNamespaceException(new NullPointerException(namespace));
		this.namespace = namespace;
		if (this.isValid()) throw new InvalidNamespaceException(this);
	}
	
	@Override
	public final @NotNull String asString() {
		return this.namespace;
	}

	@Override
	public @NotNull Pattern getRegex() {
		return NAMESPACE_PATTERN;
	}
	
	@Override
	public final @NotNull Namespace clone() {
		return new Namespace(this.namespace);
	}
	
	public final @NotNull Identifier toIdentifier(@NotNull final Path path) {
		return new Identifier(this, path);
	}
	
	public final @NotNull Identifier toIdentifier(@NotNull final String path) throws InvalidPathException {
		return new Identifier(this, new Path(path));
	}
	
}
