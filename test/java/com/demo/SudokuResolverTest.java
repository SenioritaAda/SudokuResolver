package com.demo;

import org.junit.jupiter.api.Test;

class SudokuResolverTest {

    @Test
    void shouldResolveSudoku() {
        final String template =
                "x3xxxxx4x\n" +
                "54xx71x2x\n" +
                "xxx3xxxx6\n" +
                "xx8xx9xxx\n" +
                "3x2xxxxxx\n" +
                "x1xxx7xx3\n" +
                "xxxxxxx89\n" +
                "7859xxxxx\n" +
                "xxx5xxx62\n";

        final String result = new SudokuResolver().solveSudoku(template);
        System.out.println(result);
    }
}