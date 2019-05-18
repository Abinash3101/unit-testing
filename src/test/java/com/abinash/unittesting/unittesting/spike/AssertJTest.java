package com.abinash.unittesting.unittesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12,15,45);

        //assertThat(numbers, hasSize(3));
        assertThat(numbers).hasSize(3)
                .contains(12, 15)
                .anyMatch(x -> x > 10)
                .noneMatch(x -> x < 10);

        //assertThat("", isEmptyString());
        assertThat("").isEmpty();
        assertThat("ABCDE").contains("BCD")
                .startsWith("AB")
                .endsWith("CDE");
        //assertThat("ABCDE", containsString("BCD"));
       // assertThat("ABCDE", startsWith("ABC"));
        //assertThat("ABCDE", endsWith("E"));
    }
}
