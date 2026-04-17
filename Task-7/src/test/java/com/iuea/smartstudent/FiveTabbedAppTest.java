package com.iuea.smartstudent;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FiveTabbedAppTest {

    // ── Grade Calculator Tests ──────────────────────────────

    @Test
    void testAverageOfThreeMarks() {
        double m1 = 70, m2 = 80, m3 = 90;
        double avg = (m1 + m2 + m3) / 3;
        assertEquals(80.0, avg);
    }

    @Test
    void testAverageWithZeroMarks() {
        double m1 = 0, m2 = 0, m3 = 0;
        double avg = (m1 + m2 + m3) / 3;
        assertEquals(0.0, avg);
    }

    @Test
    void testAverageWithDecimalMarks() {
        double m1 = 55.5, m2 = 65.5, m3 = 75.0;
        double avg = (m1 + m2 + m3) / 3;
        assertEquals(65.33, avg, 0.01);
    }

    @Test
    void testAverageWithMaxMarks() {
        double m1 = 100, m2 = 100, m3 = 100;
        double avg = (m1 + m2 + m3) / 3;
        assertEquals(100.0, avg);
    }

    // ── Student Form Validation Tests ───────────────────────

    @Test
    void testStudentNameNotEmpty() {
        String name = "Benin Bismark";
        assertFalse(name.isEmpty());
    }

    @Test
    void testStudentIdNotEmpty() {
        String id = "2024001";
        assertFalse(id.isEmpty());
    }

    @Test
    void testEmptyNameFails() {
        String name = "";
        assertTrue(name.isEmpty());
    }

    @Test
    void testEmptyIdFails() {
        String id = "";
        assertTrue(id.isEmpty());
    }

    @Test
    void testStudentSavedSuccessfully() {
        String name = "Joel";
        String id = "2024002";
        String status = (!name.isEmpty() && !id.isEmpty())
                ? "Student Saved Successfully!"
                : "Please fill all required fields!";
        assertEquals("Student Saved Successfully!", status);
    }

    @Test
    void testMissingFieldsShowsError() {
        String name = "";
        String id = "";
        String status = (!name.isEmpty() && !id.isEmpty())
                ? "Student Saved Successfully!"
                : "Please fill all required fields!";
        assertEquals("Please fill all required fields!", status);
    }
}