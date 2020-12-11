package it.unimi.dsi.fastutil.objects;

import static org.junit.Assert.assertEquals;

/*
 * Copyright (C) 2017-2020 Sebastiano Vigna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.RandomAccess;

import org.junit.Test;

public class ObjectListTest {
	@Test
	public void testOf() {
		final ObjectList<String> l = ObjectList.of("0", "1", "2");
		assertEquals(ObjectArrayList.wrap(new String[] { "0", "1", "2" }), l);
	}

	@Test
	public void testOfEmpty() {
		final ObjectList<String> l = ObjectList.of();
		assertTrue(l.isEmpty());
	}

	@Test
	public void testOfSingleton() {
		final ObjectList<String> l = ObjectList.of("0");
		assertEquals(ObjectArrayList.wrap(new String[] { "0" }), l);
	}

	@Test
	public void testOfPair() {
		final ObjectList<String> l = ObjectList.of("0", "1");
		assertEquals(ObjectArrayList.wrap(new String[] { "0", "1" }), l);
	}
	
	@Test
	public void testOfTriplet() {
		final ObjectList<String> l = ObjectList.of("0", "1", "2");
		assertEquals(ObjectArrayList.wrap(new String[] { "0", "1", "2" }), l);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testOfImmutable() {
		final ObjectList<String> l = ObjectList.of("0", "1", "2");
		l.add("3");
	}
}
