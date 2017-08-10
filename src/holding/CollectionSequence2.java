package holding;

import java.util.*;

import typeinfo.pets.*;

class CollectionSequence extends AbstractCollection<Pet> implements Collection<Pet> {
	int i = 0;
	private Pet[] pets = Pets.createArray(8);

	static void display(Collection<Pet> pets) {
		for (Pet p : pets)
			System.out.print(p.id() + ":" + p + " ");
		System.out.println();
	}

	static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			@Override
			public boolean hasNext() {
				return i < pets.length;
			}

			@Override
			public Pet next() {
				return pets[i];
			}
		};
	}

	@Override
	public int size() {
		return pets.length;
	}
}

public class CollectionSequence2 {
	public static void main(String[] args) {
		CollectionSequence collectionSequence = new CollectionSequence();
		CollectionSequence.display(collectionSequence.iterator());
	}
}
