package architecture;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class LayeredArchitectureTest extends ArchitectureTest {

    @Test
    void layer_dependencies_must_be_respected_include_the_tests() {
        layeredArchitecture()

                .layer("Rest").definedBy("demo.fxzou.baseframework.adapters.inbound.rest..")
//                .layer("Rpc").definedBy("demo.fxzou.baseframework.adapters.inbound.rpc..")
//                .layer("Gateway").definedBy("demo.fxzou.baseframework.adapters.outbound.gateway..")
                .layer("Persistence").definedBy("demo.fxzou.baseframework.adapters.outbound.persistence..")
                .layer("Application").definedBy("demo.fxzou.baseframework.application..")
                // 由于Domain层位于最内层，可以被所有其它层访问，所以在此不用显式声明和进行测试
                // .layer("Domain").definedBy("demo.fxzou.baseframework.domain..")

                .whereLayer("Rest").mayNotBeAccessedByAnyLayer()
//                .whereLayer("Rpc").mayNotBeAccessedByAnyLayer()
//                .whereLayer("Gateway").mayNotBeAccessedByAnyLayer()
                .whereLayer("Persistence").mayNotBeAccessedByAnyLayer()
                .whereLayer("Application").mayOnlyBeAccessedByLayers("Rest")
                // 由于Domain层位于最内层，可以被所有其它层访问，所以在此不用显式声明和进行测试
                // .whereLayer("Domain").mayOnlyBeAccessedByLayers("Adapters", "Application")

                .as("The layer dependencies must be respected (include the tests)")
                .because("we must follow the DIP principle.")
                .check(classes);
    }
}
