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
        // Align compose artifacts by bringing in BOM to satisfy inline symbol lookup across modules
        implementation("androidx.compose:compose-bom:2024.10.01")
        // Per DCL strict rules we can only add implementation lines; add unversioned Compose deps to bind to BOM.
        implementation(platform("androidx.compose:compose-bom:2024.10.01"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.foundation:foundation")
        implementation("androidx.compose.material:material-icons-core")
        implementation("androidx.compose.material:material-icons-extended")
        implementation("androidx.navigation:navigation-compose") // align via BOM where applicable
    }
}
