/*
Jazzy - a Java library for Spell Checking
Copyright (C) 2001 Mindaugas Idzelis
Full text of license can be found in LICENSE.txt

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.swabunga.test.spell.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.swabunga.spell.TeXWordFinder;
import com.swabunga.spell.tokenizer.FileWordTokenizer;

public class FileWordTokenizerTest {

    FileWordTokenizer texTok;

    @Before
    public void setUp() {
        texTok = new FileWordTokenizer(new File(FileWordTokenizerTest.class
                .getResource("/com/swabunga/test/spell/event/test.tex")
                .getFile()), new TeXWordFinder());
    }

    @After
    public void tearDown() {
        texTok = null;
    }

    @Test
    public void testRead() {
        assertTrue(!texTok.getContext().equals(""));
    }

    @Test
    public void testTeXWordA() {
        assertEquals("width", texTok.nextWord());
        assertEquals("1", texTok.nextWord());
        assertEquals("1", texTok.nextWord());
        assertEquals("1cm", texTok.nextWord());
        assertEquals("1", texTok.nextWord());
        assertEquals("Key", texTok.nextWord());
        assertEquals("Words", texTok.nextWord());
    }

    public static void main(String[] args) {
        // System.out.println("No tests currently written for FileWordTokenizerTester.");
        TestRunner.run(new TestSuite(FileWordTokenizerTest.class));
    }

}
