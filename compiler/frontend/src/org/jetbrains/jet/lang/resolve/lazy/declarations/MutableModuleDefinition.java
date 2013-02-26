/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve.lazy.declarations;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import org.jetbrains.jet.lang.resolve.name.Name;

import java.util.Collection;
import java.util.Collections;

public class MutableModuleDefinition implements ModuleDefinition {

    private final Name name;
    private final Collection<SubModuleDefinition> subModuleProviders = Lists.newArrayList();
    private final PlatformToKotlinClassMap platformToKotlinClassMap;

    public MutableModuleDefinition(@NotNull Name name, @NotNull PlatformToKotlinClassMap map) {
        this.name = name;
        platformToKotlinClassMap = map;
    }

    @NotNull
    @Override
    public Name getName() {
        return name;
    }

    @NotNull
    @Override
    public Collection<SubModuleDefinition> getSubModules() {
        return Collections.unmodifiableCollection(subModuleProviders);
    }

    public void addSubModuleDefinition(@NotNull SubModuleDefinition subModule) {
        subModuleProviders.add(subModule);
    }

    @NotNull
    @Override
    public PlatformToKotlinClassMap getPlatformToKotlinClassMap() {
        return platformToKotlinClassMap;
    }
}
