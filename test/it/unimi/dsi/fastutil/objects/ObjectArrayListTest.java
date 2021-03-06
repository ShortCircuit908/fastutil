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

package it.unimi.dsi.fastutil.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ObjectArrayListTest {

	@SuppressWarnings("boxing")
	@Test
	public void testRemoveAll() {
		ObjectArrayList<Integer> l = ObjectArrayList.wrap(new Integer[] { 0, 1, 1, 2 });
		l.removeAll(ObjectSets.singleton(1));
		assertEquals(ObjectArrayList.wrap(new Integer[] { 0, 2 }), l);
		assertTrue(l.elements()[2] == null);
		assertTrue(l.elements()[3] == null);

		l = ObjectArrayList.wrap(new Integer[] { 0, 1, 1, 2 });
		l.removeAll(ObjectSets.singleton(1));
		assertEquals(ObjectArrayList.wrap(new Integer[] { 0, 2 }), l);
		assertTrue(l.elements()[2] == null);
		assertTrue(l.elements()[3] == null);
	}

	@Test
	public void testSizeOnDefaultInstance() {
		final ObjectArrayList<Integer> l = new ObjectArrayList<>();
		l.size(100);
	}

	@Test
	public void testOf() {
		final ObjectArrayList<String> l = ObjectArrayList.of("0", "1", "2");
		assertEquals(ObjectArrayList.wrap(new String[] { "0", "1", "2" }), l);
	}

	@Test
	public void testOfEmpty() {
		final ObjectArrayList<String> l = ObjectArrayList.of();
		assertTrue(l.isEmpty());
	}

	@Test
	public void testOfSingleton() {
		final ObjectArrayList<String> l = ObjectArrayList.of("0");
		assertEquals(ObjectArrayList.wrap(new String[] { "0" }), l);
	}
}
