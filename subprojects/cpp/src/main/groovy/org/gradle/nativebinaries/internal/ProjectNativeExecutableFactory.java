/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.nativebinaries.internal;

import org.gradle.api.NamedDomainObjectFactory;
import org.gradle.api.Project;
import org.gradle.internal.reflect.Instantiator;
import org.gradle.nativebinaries.ProjectNativeExecutable;
import org.gradle.runtime.base.ComponentSpecIdentifier;
import org.gradle.runtime.base.internal.DefaultComponentSpecIdentifier;

public class ProjectNativeExecutableFactory implements NamedDomainObjectFactory<ProjectNativeExecutable> {
    private final Instantiator instantiator;
    private final Project project;

    public ProjectNativeExecutableFactory(Instantiator instantiator, Project project) {
        this.instantiator = instantiator;
        this.project = project;
    }

    public ProjectNativeExecutable create(String name) {
        ComponentSpecIdentifier id = new DefaultComponentSpecIdentifier(project.getPath(), name);
        return instantiator.newInstance(DefaultProjectNativeExecutable.class, id);
    }
}
