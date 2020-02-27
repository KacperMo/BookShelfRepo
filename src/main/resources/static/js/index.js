function getProducts() {
    return fetch("/api/products")
        .then((response) => response.json())
        .catch((error) => console.log(error))
}

function toProductHtmlTemplate(product) {
    return `
        
        <div class="col-sm col-md-6 col-lg ftco-animate">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="${product.cover}" alt="Colorlib Template"></a>
    					<div class="text py-3 px-3">
    						<h3><a href="#">${product.title}</a></h3>
                            <h6>${product.description}</h6>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>${product.price}PLN</span></p>
		    					</div>
		    					<div class="rating">
	    							<p class="text-right">
	    								<span class="ion-ios-star-outline"></span>
	    								<span class="ion-ios-star-outline"></span>
	    								<span class="ion-ios-star-outline"></span>
	    								<span class="ion-ios-star-outline"></span>
	    								<span class="ion-ios-star-outline"></span>
	    							</p>
	    						</div>
	    					</div>
	    					<hr>
    						<p class="bottom-area d-flex">
    							<button class="add-to-cart" data-product-id="${product.id}"><span>Add to cart <i class="ion-ios-add ml-1"></i></span></button>
    							
    						</p>
    					</div>
    				</div>
    			</div>

    `;
}
function toHtmlElement(templateStr) {
    let htmlElement = document.createElement('div');
    htmlElement.innerHTML = templateStr.trim();

    return htmlElement.firstChild;
}

function initializeAddToBasket(htmlElement) {

    htmlElement.querySelector('button').addEventListener('click', (e) => {
        const productId = e.target.getAttribute('data-product-id');
        console.log(`i going to add product with id ${productId}`);
    });

    return htmlElement;
}
(() => {
    const productsListEl$ = document.querySelector('.products-list');

    getProducts().then((products) => {
        products
            .map(p => toProductHtmlTemplate(p))
            .map(htmlStr => toHtmlElement(htmlStr))
            .map(elem => initializeAddToBasket(elem))
            .forEach((element) => {
                productsListEl$.appendChild(element);
            })
        ;
    });
})();
