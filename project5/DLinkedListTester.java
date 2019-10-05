package project5;

public class DLinkedListTester {
	public static void main(String[] args) {

		DLinkedList ages = new DLinkedList();
		for(int i = 1; i <= 15; i++) {
			ages.addFirst(i);
		}

		for(int i = 16; i <= 30; i++) {
			ages.addLast(i);
		}
		System.out.println("Remove First Expected: 15");
		System.out.println("Output: "+ages.removeFirst() + "\n");

		System.out.println("Remove Last Expected: 30");
		System.out.println("Output: "+ages.removeLast() + "\n");

		System.out.println("Get First Expected: 14");
		System.out.println("Output: "+ages.getFirst() + "\n");

		System.out.println("Get Last Expected: 29");
		System.out.println("Output: "+ages.getLast() + "\n");

		System.out.println("Contains 10 Expected: true");
		System.out.println("Output: " + ages.contains(10) + "\n");

		System.out.println("Contains 100 Expected: false");
		System.out.println("Output: " + ages.contains(100) + "\n");

		ListIterator iter = ages.listIterator();

		System.out.print("While has next Expected: 14 13 12 11 10 9 8 7 6 5 4 3 2 1 16 17 18 19 20 21 22 23 24 25 26 27 28 29 \nOutput: ");
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		System.out.println("\n");

		System.out.print("While has previous Expected: 29 28 27 26 25 24 23 22 21 20 19 18 17 16 1 2 3 4 5 6 7 8 9 10 11 12 13 14 \nOutput: ");
		while(iter.hasPrevious()) {
			System.out.print(iter.previous() + " ");
		}

		iter = ages.listIterator();
		iter.next(); //14 | 13 12 11 10 ...
		iter.next(); //14 13 | 12 11 10 ...
		iter.add(12.5); //14 13 12.5 | 12 11 10 ...
		
		//System.out.println(ages.contains(12.5));
		iter.next(); //14 13 12.5 12 | 11 10 ...
		System.out.println("\n\nRemove Expected: 12");
		System.out.println("Output: " + iter.remove() + "\n");

		iter.previous(); //14 13 | 12.5 11 10 ... 
		iter.previous(); //14 | 13 12.5 11 10 ...
		iter.remove(); //14 | 12.5 11 10 ...
		while(iter.hasNext()) {
			iter.next();
		}
		iter.previous();
		iter.set(100);
		System.out.print("\nWhile has next Expected: 14 12.5 11 10 9 8 7 6 5 4 3 2 1 16 17 18 19 20 21 22 23 24 25 26 27 28 100 \nOutput: ");
		iter = ages.listIterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

}
