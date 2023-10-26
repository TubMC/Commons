package com.tubmc.commons.identifiers;

import java.util.regex.Pattern;

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
 * Definition of the shared methods of {@link Namespace} and {@link Path}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
sealed interface IIdentifierComponent extends Cloneable, Comparable<IIdentifierComponent> permits Namespace, Path {
	
	public @NotNull String asString();
	
	public @NotNull Pattern getRegex();
	
	public default boolean isValid() {
		return this.getRegex().matcher(this.asString()).matches();
	}
	
	@Override
	public default int compareTo(@NotNull final IIdentifierComponent o) {
		return this.asString().compareTo(o.asString());
	}
	
	public IIdentifierComponent clone();
	
}
