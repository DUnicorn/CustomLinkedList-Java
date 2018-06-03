package lt.abstractExample;

public class CustomLinkedList implements NodeList {

	private ListItem head = null;

	public CustomLinkedList(ListItem head) {
		super();
		this.head = head;
	}

	@Override
	public ListItem getHead() {
		return this.head;
	}

	@Override
	public boolean addItem(ListItem newItem) {
		if (this.head == null) {
			// list was empty, this item becomes the head of the list
			this.head = newItem;
			return true;
		}

		ListItem currentItem = this.head;
		while (currentItem != null) {
			int comparison = (currentItem.compareTo(newItem));
			if (comparison < 0) {
				// new item is greater, move right
				if (currentItem.next() != null) {
					currentItem = currentItem.next();

				} else {
					// there is no next, so insert at the end of the list
					currentItem.setNext(newItem).setPrevious(currentItem);
					return true;
				}
			} else if (comparison > 0) {
				// newItem is less, insert before
				if (currentItem.previous() != null) {
					currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
					newItem.setNext(currentItem).setPrevious(newItem);
				} else {
					// node with no previous id the head
					newItem.setNext(this.head).setPrevious(newItem);
				}
				return true;
			} else {
				// equal
				System.out.println(newItem.getValue() + " is already present, not added");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeItem(ListItem item) {
		if (item != null) {
			System.out.println("Deleting item " + item.getValue());
		}
		ListItem currentItem = this.head;
		while (currentItem != null) {
			int comparison = currentItem.compareTo(item);
			if (comparison == 0) {
				// found item to delete
				if (currentItem == this.head) {
					this.head = currentItem.next();
				} else {
					currentItem.previous().setNext(currentItem.next());
					if (currentItem.next() != null) {
						currentItem.next().setPrevious(currentItem.previous());
					}
				}
				return true;
			} else if (comparison < 0) {
				currentItem = currentItem.next();

			} else { // comparison > 0
				// at an item greater than the one to be deleted
				// so the item is not in the list
				return false;

			}
		}
		// reached the end of the list
		// without finding item to delete
		return false;
	}

	@Override
	public void traverse(ListItem head) {
		if (head == null) {
			System.out.println("The list is empty.");
		} else {
			while (head != null) {
				System.out.println(head.getValue());
				head = head.next();
			}
		}
//		if (head != null) {
//			System.out.println(head.getValue());
//			traverse(head.next());
//		}
	}
}
