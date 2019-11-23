package cs146F19.Garcia.project1;

public class LinkedList {
	
	LinkedNode head;
	int size;
	int winner;
	
	// Initialize list with no prisoners
	public LinkedList() {
		size = 0;
	}
	
	// Initialize list with proper amount of prisoners
	public LinkedList(int prisoners) {
		insert(prisoners);
	}
	
	// Insert given amount of prisoners in linked list
	public void insert(int amount) {
		size = amount;											// Set size of linked list to insertion amount
		if(amount <= 0)
			return;
		else {
			head = new LinkedNode(1);							// Set head as first node with id 1
			LinkedNode previous = head;							// Create a node "previous" linking to the head
			for(int i = 2; i <= amount; i++) {
				previous.next = new LinkedNode(i);				// Set previous' next to a new node with id of i in for loop
				previous.next.prev = previous;					// Set the new node's previous to current previous node
				previous = previous.next;						// Increment previous to rerun for loop
			}
			previous.next = head;								// Last element's next points to head
			head.prev = previous;								// Head's previous points to last element
		}
	}
	
	// Remove specified node from linked list
	private void remove(LinkedNode node) {
		node.prev.next = node.next;								// Assign the previous node's next to jump over passed in node and point to passed in node's next
		node.next.prev = node.prev;								// Assign the next node's previous to jump over passed in node and point to previous of passed in node's
		size--;													// Decrease size of linked list
		if(node.equals(head))									// If the node to be removed is the head, set the next node to be the head
			head = node.next;
	}
	
	// Play the actual elimination game using step passed into parameter "countBy"
	public void play(int countBy) {
		if(size <= 0) {													// Check to make sure size of linked list is > 0
			System.out.println("Insert some prisoners!");
			return;
		}
		if(countBy <= 0) {												// Check to make sure step is > 0
			System.out.println("Negative steps are not allowed!");
			return;
		}
		LinkedNode position = head;										// Set start position at head
		while(size > 1) {
			for(int i = 1; i <= countBy; i++)							// Cycle through each position until you reach the prisoner to remove
				position = position.next;
			remove(position);											// Remove prisoner
			System.out.println(position.getId() + " was removed");
			position = position.next;									// Set prisoner to start counting from to the next prisoner
		}
		winner = head.getId();											// Get the # of last prisoner
		System.out.println("The winner is: " + winner);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
