package com.tubmc.commons.definables;

import org.jetbrains.annotations.NotNull;

import com.tubmc.commons.identifiers.Identifier;

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
 * Denotes an object as pertaining an {@link Identifier}
 * 
 * @author BradBot_1
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IIdentifiable {
	/**
	 * @since 1.0.0
	 * 
	 * @return The unique {@link Identifier} for this object
	 */
	public @NotNull Identifier getIdentifier();
}
