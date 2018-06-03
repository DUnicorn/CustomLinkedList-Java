package lt.abstractExample;

public interface NodeList {

	ListItem getHead();

	boolean addItem(ListItem item);

	boolean removeItem(ListItem item);

	void traverse(ListItem head);

}
