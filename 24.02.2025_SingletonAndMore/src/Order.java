public class Order {
    String mainDish;
    String drink;
    String dessert;
    String notes;

    public Order(OrderBuilder builder) {
        this.mainDish = builder.mainDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
        this.notes = builder.notes;
    }

    public static class OrderBuilder {
        protected String mainDish;
        protected String drink;
        protected String dessert;
        protected String notes;

        public OrderBuilder setMainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }
        public OrderBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }
        public OrderBuilder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }
        public OrderBuilder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
