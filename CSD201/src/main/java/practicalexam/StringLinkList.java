package practicalexam;

// Modified by Sriram Pemmaraju on September 24, 2007 
// Added a few new methods as per Lab 5 description
//
// Also added a main method for testing the class
class StringLinkList {
	private StringLink first; // ref to first link on list
	private int numLinks; // tracks the number of links in the linked list

	// -------------------------------------------------------------
	public StringLinkList() // constructor
	{
		first = null; // no links on list yet
		numLinks = 0;
	}

	// -------------------------------------------------------------
	public void insertFirst(String id) { // make new link and make it point to
		// the old first
		StringLink newLink = new StringLink(id, first);
		first = newLink; // now first points to this
		numLinks++;
	}

	// -------------------------------------------------------------
	public StringLink find(String key) // find link with given key
	{
		// if empty linked list, then return null
		if (first == null)
			return null;

		// otherwise scan list until a node with key is found
		StringLink current = first; // start at 'first'
		while (!(current.sData).equals(key)) // while no match,
		{
			if (current.next == null) // if end of list,
				return null; // didn't find it
			else // not end of list,
				current = current.next; // go to next link
		}
		return current; // found it
	}

	// -------------------------------------------------------------
	public StringLink delete(String key) // delete link with given key
	{

		if (first == null)
			return null;

		StringLink current = first; // search for link
		StringLink previous = first;
		while (current.sData != key) {
			if (current.next == null)
				return null; // didn't find it
			else {
				previous = current; // go to next link
				current = current.next;
			}
		} // found it
		if (current == first) // if first link,
			first = first.next; // change first
		else // otherwise,
			previous.next = current.next; // bypass it

		numLinks--;
		return current;
	}

	// -------------------------------------------------------------
	public void displayList() // display the list
	{
		System.out.print("List (first-->last): ");
		StringLink current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}

	// -------------------------------------------------------------
	// The rest of the functions here were added on Sept 24
	// -------------------------------------------------------------
	// Appends the given element to the end of this list.
	void addLast(String x) {
		// Make a new node containing x
		StringLink newNode = new StringLink(x, null);

		// If list is empty, then make first point to the new node
		if (first == null)
			first = newNode;

		// otherwise scan to the end of the list
		StringLink current = first;
		while (current.next != null)
			current = current.next;

		// connect the new node after current
		current.next = newNode;

		numLinks++;

	}

	// -------------------------------------------------------------
	// Removes all of the elements from this list.
	void clear() {
		first = null;
		numLinks = 0;
	}

	// -------------------------------------------------------------
	// Retrieves, but does not remove, the first (first element) of this list.
	String element() {
		if (first != null)
			return first.sData;

		return " ";
	}

	// -------------------------------------------------------------
	// Returns the element at the specified position in this list.
	String get(int index) {

		// Initialize current and initialize a counter
		StringLink current = first;
		int count = 0;

		// Scan as many nodes as specified by index
		while (count < index) {
			// check to make sure that we have not scanned
			// past the end of the list; if not move
			// current and increment counter
			if (current != null) {
				current = current.next;
				count++;
			} else
				return " ";
		}

		// We have reached index
		if (current != null)
			return current.sData;
		else
			return " ";
	}

	// -------------------------------------------------------------
	String removeFirst() {
		StringLink temp = first;

		if (first != null) {
			first = first.next;
			numLinks--;
			return temp.sData;
		} else
			return " ";
	}

	// -------------------------------------------------------------
	int size() {
		return numLinks;
	}

	// -------------------------------------------------------------
	// Added by Sriram Pemmaraju on Sept 24, 2007.
	// The function returns a copy of the list, but with items
	// in reverse order.
	// -----------------------------------------------------------------
	public StringLinkList copy() {
		StringLinkList temp = new StringLinkList();
		StringLink current = first;

		// Scan this list from front to back
		while (current != null) {
			temp.insertFirst(current.sData);
			current = current.next;
		}

		return temp;
	}

	// --------------------------------------------------------------
	// Added by Sriram Pemmaraju on Sept 24, 2007.
	// The function returns a copy of the list in an array, but with items
	// in reverse order.
	// -----------------------------------------------------------------
	public String[] copyIntoArray() {
		String[] temp = new String[numLinks];
		StringLink current = first;

		// Scan this list from front to back
		int index = 0;
		while (current != null) {
			temp[index++] = current.sData;
			current = current.next;
		}

		return temp;
	}

	// -----------------------------------------------------------------
	// Main method for testing the class
	// -----------------------------------------------------------------
	public static void main(String[] args) {

		StringLinkList L = new StringLinkList();

		L.insertFirst("5");
		L.insertFirst("15");
		L.insertFirst("25");

		// Should see 25, 15, 5
		L.displayList();

		// Looking for an item that should be found
		StringLink a = L.find("15");
		if (a != null) {
			a.displayLink();
			System.out.println("");
		} else
			System.out.println("15 not found");

		// Looking for an item that should be not found
		StringLink b = L.find("17");
		if (b != null) {
			b.displayLink();
			System.out.println("");
		} else
			System.out.println("17 not found");

		// Deleting in the middle
		L.delete("15");
		// Should see 25-5
		L.displayList();

		L.insertFirst("50");

		// Deleting from the end
		L.delete("5");
		// Should see 50-25
		L.displayList();

		// Deleting from the front
		L.delete("50");
		// Should see 25
		L.displayList();

		L.addLast("30");
		L.addLast("22");
		// Should see 25-30-22
		L.displayList();

		// Should see 25
		System.out.println(L.element());

		// should see 25-30-22-0-0-0...
		for (int i = 0; i < 10; i++)
			System.out.println(L.get(i));

		// should see 25
		System.out.println(L.removeFirst());

		// should see 30
		System.out.println(L.removeFirst());

		// should see 22
		System.out.println(L.removeFirst());

		// Should see an empty list
		L.displayList();
	}
} // end class LinkList
