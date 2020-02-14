package de.knxamk.model.stage.stageComponents;

import org.junit.Test;

import static org.junit.Assert.*;

public class FreeTest
{

    @Test
    public void toStringShouldReturnCorrectString()
    {
        Free free = new Free();
        assertEquals("free", free.toString());
    }

}