package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence implements Iterable<Pet>{

	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>(){
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index<pets.length;
			}

			@Override
			public Pet next() {
				return pets[index++];
			}
		};
	}
	
	public Iterable<Pet> reversed(){
		return new Iterable<Pet>(){

			@Override
			public Iterator<Pet> iterator() {
				return new Iterator<Pet>() {
					private int index = pets.length-1;
					@Override
					public boolean hasNext() {
						return index>-1;
					}
		
					@Override
					public Pet next() {
						return pets[index--];
					}
				};
			}

			
		};
	}
	
	public Iterable<Pet> randomized(){
		return new Iterable<Pet>(){

			@Override
			public Iterator<Pet> iterator() {
				List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
				Collections.shuffle(shuffled, new Random(47));
				return shuffled.iterator();
			}
			
		};
		
	}
	
	
	public static void main(String[] args) {
		NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
		for(Pet p: nonCollectionSequence) {
			System.out.print(p+" ");
		}
		System.out.println();
		for(Pet p: nonCollectionSequence.reversed()) {
			System.out.print(p+" ");
		}
		System.out.println();
		for(Pet p: nonCollectionSequence.randomized()) {
			System.out.print(p+" ");
		}
		System.out.println();
	}
}
