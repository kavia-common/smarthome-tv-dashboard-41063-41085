androidApplication {
    namespace = "org.example.app"

    dependencies {
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
        implementation("androidx.activity:activity-compose:1.9.3")
        implementation("androidx.compose.ui:ui:1.7.5")
        implementation("androidx.compose.ui:ui-tooling-preview:1.7.5")
        implementation("androidx.compose.material3:material3:1.3.0")
        implementation("androidx.compose.foundation:foundation:1.7.5")
        implementation("androidx.navigation:navigation-compose:2.8.3")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
        implementation("androidx.compose.material:material-icons-core:1.7.5")
        implementation("androidx.compose.material:material-icons-extended:1.7.5")
    }
}
