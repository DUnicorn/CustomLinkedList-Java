package lt.abstractExample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomLinkedList list = new CustomLinkedList(null);
		list.traverse(list.getHead());

		// String stringData = "London Lisbon Riga Vilnius Talin Oslo London";
		//
		String stringData = "1 4 3 5 2 0";

		String[] data = stringData.split(" ");
		for (String s : data) {
			// create new item with values set to the string s
			// list.addItem(new Node(s));
			list.addItem(new Node(s));
		}

		list.traverse(list.getHead());

		// ----------------Test for LinkedList----------------------------
		list.traverse(list.getHead());
		list.removeItem(new Node("3"));
		list.traverse(list.getHead());

		list.removeItem(new Node("5"));
		list.traverse(list.getHead());

		list.removeItem(new Node("0"));
		list.removeItem(new Node("4"));
		list.removeItem(new Node("2"));
		list.traverse(list.getHead());

		list.removeItem(list.getHead());
		list.traverse(list.getHead());
		// ------------------------------------------------------------------

	}

}
