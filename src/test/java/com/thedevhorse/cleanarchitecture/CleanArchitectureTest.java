package com.thedevhorse.cleanarchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class CleanArchitectureTest {

    @Test
    void givenControllerClasses_thenNotBeAccessedByAnyLayer() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.thedevhorse.cleanarchitecture");

        Architectures.LayeredArchitecture arch = layeredArchitecture()
                .consideringAllDependencies()
                .layer("Controller").definedBy("..controller..")

                .whereLayer("Controller").mayNotBeAccessedByAnyLayer();

        arch.check(importedClasses);
    }
}
