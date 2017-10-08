public final class Item extends Renderable {

	int id;

	int quantity;

	protected final Model getModel() {
		return class46.getItemDefinition(this.id).getModel(this.quantity);
	}
}
