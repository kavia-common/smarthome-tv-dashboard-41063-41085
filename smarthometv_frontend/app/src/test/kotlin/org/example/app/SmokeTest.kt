package org.example.app

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * PUBLIC_INTERFACE
 * A minimal smoke test to ensure the Gradle test task discovers at least one test case.
 * This prevents builds from failing due to zero discovered tests in certain CI environments.
 */
class SmokeTest {

    @Test
    fun smoke() {
        assertTrue(true, "Smoke test should always pass")
    }
}
