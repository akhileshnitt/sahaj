package com.sahaj.text.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StopWordUtilTest {

    @Test
    public void isStopWord() {
        assertEquals(true,StopWordUtil.isStopWord("whom"));
        assertEquals(true,StopWordUtil.isStopWord("they've"));
        assertEquals(true,StopWordUtil.isStopWord("themselves"));
        assertEquals(false,StopWordUtil.isStopWord("zebra"));
        assertEquals(true,StopWordUtil.isStopWord("why"));
        assertEquals(true,StopWordUtil.isStopWord("whom"));
    }
}