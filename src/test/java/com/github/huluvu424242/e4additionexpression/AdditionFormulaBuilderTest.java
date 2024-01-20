package com.github.huluvu424242.e4additionexpression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionFormulaBuilderTest {

    @Test
    @DisplayName("11+7=")
    void add11und7(){
        final FormulaContext context = AdditionFormulaBuilder.builder()
                .digit(1)
                .digit(1)
                .plus()
                .digit(7)
                .equals()
                .build();
        assertEquals(18,context.summe());
        assertEquals(0,context.zahlBuilder().length());
    }

}