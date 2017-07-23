### Supermarket

##### Things to consider

* An offer can be applied to multiple products
* An offer needs to have a list of included products - by product (entire object) or by product name?

* TDD an approach to create different offer objects that inherit from an abstract offer object
* Each SubOffer overrides an apply method to add a saving to the basket depending on the items, and specific quantities of those items in the basket

* Implement packages