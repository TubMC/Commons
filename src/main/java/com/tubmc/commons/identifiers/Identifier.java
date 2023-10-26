package com.tubmc.commons.identifiers;

import org.jetbrains.annotations.NotNull;

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
 * A union of a {@link Namespace} and a {@link Path}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public final record Identifier(@NotNull Namespace namespace, @NotNull Path path) implements Cloneable, Comparable<Identifier> {
	
	public static final @NotNull String SEPERATOR = ":";
	
	public static final @NotNull Identifier of(@NotNull final String identifier) {
		final String[] split = identifier.split(SEPERATOR);
		return new Identifier(new Namespace(split[0]), new Path(split[1]));
	}
	
	@Override
	public final @NotNull String toString() {
		return this.namespace.asString() + SEPERATOR + this.path.asString();
	}
	
	@Override
	public final @NotNull Identifier clone()  {
		return new Identifier(this.namespace.clone(), this.path.clone());
	}
	
	@Override
	public final int compareTo(Identifier o) {
		return this.toString().compareTo(o.toString());
	}
	
}
