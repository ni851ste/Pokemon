package de.knxamk.model.stage.stageComponents;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest
{

    @Test
    public void toStringShouldReturnCorrectString()
    {
        Tree tree = new Tree();
        assertEquals("tree", tree.toString());
    }

}